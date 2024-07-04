package com.ykomarnytskyi2022.petclinic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private final OwnerService ownerService;
	
	@Autowired
	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder webDataBinder) {
		webDataBinder.setAllowedFields("id");
	}

	@RequestMapping("/find")
	public String findOwners(Model model) {
		model.addAttribute("owner", new Owner());
		return "owners/findOwners";
	}
	
	@GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){
		if (owner.getLastName() == null) {
            owner.setLastName("");
        }
		String lastName = String.format("%%%s%%", owner.getLastName());
        List<Owner> results = ownerService.findAllByLastNameLike(lastName);
        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            owner = results.get(0);
            return "redirect:/owners/".concat(String.valueOf(owner.getId()));
        } else {
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }
	
	@GetMapping("/{ownerId}")
	public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
		ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
		modelAndView.addObject(ownerService.findById(ownerId));
		return modelAndView;
	}
}
