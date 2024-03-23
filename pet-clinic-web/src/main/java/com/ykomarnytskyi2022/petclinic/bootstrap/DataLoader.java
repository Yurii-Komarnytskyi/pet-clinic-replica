package com.ykomarnytskyi2022.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.model.PetType;
import com.ykomarnytskyi2022.petclinic.model.Vet;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;
import com.ykomarnytskyi2022.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService; 
	private final VetService vetService;
	private final PetTypeService petTypeService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		PetType dawg = new PetType();
		dawg.setName("da dawg");
		PetType savedPetTypeDawg = petTypeService.save(dawg);
		
		PetType coon = new PetType();
		coon.setName("da coon");
		PetType savedPetTypeCoon = petTypeService.save(coon);

        Owner owner1 = new Owner();
        owner1.setName("Michael");
        owner1.setSurname("Weston");
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setName("Fiona");
        owner2.setSurname("Glenanne");
        ownerService.save(owner2);

        
        Vet yaroslav = new Vet();
        yaroslav.setName("Yaroslav");
        yaroslav.setSurname("Tchuma");
        vetService.save(yaroslav);
        
        Vet ace = new Vet();
        ace.setName("Ace");
        ace.setSurname("Ventura");
        vetService.save(ace);
	}

}
