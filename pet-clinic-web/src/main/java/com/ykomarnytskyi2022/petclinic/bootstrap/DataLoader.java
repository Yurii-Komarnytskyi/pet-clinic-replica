package com.ykomarnytskyi2022.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.model.Pet;
import com.ykomarnytskyi2022.petclinic.model.PetType;
import com.ykomarnytskyi2022.petclinic.model.Speciality;
import com.ykomarnytskyi2022.petclinic.model.Vet;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;
import com.ykomarnytskyi2022.petclinic.services.SpecialityService;
import com.ykomarnytskyi2022.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService; 
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
	}



	@Override
	public void run(String... args) throws Exception {
		
		boolean weGotNoData = petTypeService.findAll().size() == 0;
		
		if(weGotNoData) {
			loadData();			
		}
	}

	private void loadData() {
		PetType rat = new PetType();
		rat.setName("rat");
		PetType savedPetTypeDawg = petTypeService.save(rat);
		
		PetType coon = new PetType();
		coon.setName("coon");
		PetType savedPetTypeCoon = petTypeService.save(coon);
		
		Speciality radiology = new Speciality();
		radiology.setSpecialityDescription("Radiology");
		Speciality savedRadiology = specialityService.save(radiology);
		Speciality surgery = new Speciality();
		surgery.setSpecialityDescription("Surgery");
		Speciality savedSurgery = specialityService.save(surgery);
		Speciality dentistry = new Speciality();
		dentistry.setSpecialityDescription("Dentistry");
		Speciality savedDentistry = specialityService.save(dentistry);

        Owner mrSlave = new Owner();
        mrSlave.setName("mr Slave");
        mrSlave.setLastName("Garrison");
        mrSlave.setAddress("308 Negra Arroyo Lane");
        mrSlave.setCity("South Park CO");
        mrSlave.setTelephone("1234567890");
        ownerService.save(mrSlave);
        
        Pet lemmiwinks = new Pet();
        lemmiwinks.setName("Lemmiwinks");
        lemmiwinks.setOwner(mrSlave);
        lemmiwinks.setPetType(savedPetTypeDawg);
        lemmiwinks.setBirthDate(LocalDate.now());
        mrSlave.getPets().get().add(lemmiwinks); 
        
        Owner eric = new Owner();
        eric.setName("Eric");
        eric.setLastName("Carteman");
        eric.setAddress("28201 E. Bonanza St.");
        eric.setCity("South Park CO");
        eric.setTelephone("0987654321");
        ownerService.save(eric);

        Pet ericsCoon = new Pet();
        ericsCoon.setName("Coon");
        ericsCoon.setOwner(eric);
        ericsCoon.setPetType(savedPetTypeCoon);
        ericsCoon.setBirthDate(LocalDate.now());
        eric.getPets().get().add(ericsCoon); 
        
        Vet yaroslav = new Vet();
        yaroslav.setName("Yaroslav");
        yaroslav.setLastName("Tchuma");
        vetService.save(yaroslav);
        yaroslav.getSpecialities().get().add(savedSurgery);
        
        Vet ace = new Vet();
        ace.setName("Ace");
        ace.setLastName("Ventura");
        vetService.save(ace);
        ace.getSpecialities().get().add(savedDentistry);
	}

}
