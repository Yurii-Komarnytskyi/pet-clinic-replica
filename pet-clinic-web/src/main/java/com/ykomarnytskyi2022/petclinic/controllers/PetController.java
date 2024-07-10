package com.ykomarnytskyi2022.petclinic.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.model.Pet;
import com.ykomarnytskyi2022.petclinic.model.PetType;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.PetService;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;



@Controller
@RequestMapping("/owners/{ownerId}")
public class PetController {
	private static final String PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";
	private final PetService petService;
	private final PetTypeService petTypeService;
	private final OwnerService ownerService;

	@Autowired
	public PetController(PetService petService, PetTypeService petTypeService, OwnerService ownerService) {
		this.petService = petService;
		this.petTypeService = petTypeService;
		this.ownerService = ownerService;
	}
	
	
	@ModelAttribute("types")
	public Set<PetType> populatePetPypes() {
		return petTypeService.findAll();
	}
	

	@ModelAttribute("owner")
	public Owner findOwner(@PathVariable("ownerId") Long ownerId) {
		return ownerService.findById(ownerId);
	}
	
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}
	
	@GetMapping("/pets/new")
	public String initCreationForm(Owner owner, Model model) {
		Pet pet = new Pet();
		owner.getPets().add(pet);
		model.addAttribute("pet", pet);
		return PETS_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/pets/new") // Annot jakarta.validation.Valid on pet in the orig.
	public String processCreationForm(Owner owner,@Validated Pet pet, BindingResult bindingResult, Model model) {
		if(StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null)	 {
			bindingResult.rejectValue("name", "duplicate", "already exists");
		}
		owner.getPets().add(pet);
		if(bindingResult.hasErrors()) {
			model.addAttribute("pet", pet);
			return PETS_CREATE_OR_UPDATE_FORM;
		} else {
			petService.save(pet);
			return "redirect:/owners/".concat(String.valueOf(owner.getId()));
		}
	}
	
	@GetMapping("/pets/{petId}/edit")
	public String initUpdateForm(@PathVariable Long petId, Model model) {
		model.addAttribute("pet", petService.findById(petId));
		return PETS_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping("/pets/{petId}/edit") // Annot jakarta.validation.Valid on pet in the orig.
	public String processUpdateForm(@Validated Pet pet, BindingResult bindingResult, Owner owner, Model model) {
		if(bindingResult.hasErrors()) {
			pet.setOwner(owner);
			model.addAttribute("pet", pet);
			return PETS_CREATE_OR_UPDATE_FORM;
		} else {
			 owner.getPets().add(pet);
			 petService.save(pet);
			 return "redirect:/owners/".concat(String.valueOf(owner.getId()));
		}
	}
}
