package com.ykomarnytskyi2022.petclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ykomarnytskyi2022.petclinic.model.Pet;
import com.ykomarnytskyi2022.petclinic.model.Visit;
import com.ykomarnytskyi2022.petclinic.services.PetService;
import com.ykomarnytskyi2022.petclinic.services.VisitService;

@Controller
public class VisitController {
	
	private final VisitService visitService; 
	private final PetService petService;

	@Autowired
	public VisitController(VisitService visitService, PetService petService) {
		this.visitService = visitService;
		this.petService = petService;
	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("id");
	}
	
	@ModelAttribute("visit")
	public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model ) {
		System.out.println(" IN @ModelAttribute(\"visit\") ************************************************");
		Pet pet = petService.findById(petId);
		model.addAttribute("pet", pet);
		Visit visit = new Visit();
		pet.getVisits().add(visit);
		visit.setPet(pet);
		return visit;
	}
	
	@GetMapping("/owners/*/pets/{petId}/visits/new")
	public String initNewVisitForm(@PathVariable("petId") Long petId, Model model) {
		return "pets/createOrUpdateVisitForm";
	}
	
	@PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Validated Visit visit, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		} else {
			visitService.save(visit);
			return "redirect:/owners/{ownerId}";
		}
	}

	
	
	
}
