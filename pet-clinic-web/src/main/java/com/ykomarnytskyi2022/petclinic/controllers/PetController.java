package com.ykomarnytskyi2022.petclinic.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ykomarnytskyi2022.petclinic.model.Owner;
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
}
