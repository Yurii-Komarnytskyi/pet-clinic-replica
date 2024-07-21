package com.ykomarnytskyi2022.petclinic.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.model.Pet;
import com.ykomarnytskyi2022.petclinic.model.PetType;
import com.ykomarnytskyi2022.petclinic.model.Speciality;
import com.ykomarnytskyi2022.petclinic.model.Vet;
import com.ykomarnytskyi2022.petclinic.model.Visit;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;
import com.ykomarnytskyi2022.petclinic.services.SpecialityService;
import com.ykomarnytskyi2022.petclinic.services.VetService;
import com.ykomarnytskyi2022.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService; 
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialityService specialityService;
	private final VisitService visitService;

	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialityService specialityService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
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
        mrSlave.setFirstName("mr Slave");
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
        mrSlave.getPets().add(lemmiwinks); 
        
        Owner eric = new Owner();
        eric.setFirstName("Eric");
        eric.setLastName("Carteman");
        eric.setAddress("28201 E. Bonanza St.");
        eric.setCity("South Park CO");
        eric.setTelephone("0987654321");
        ownerService.save(eric);
        
        Visit visit = new Visit();
        visit.setPet(lemmiwinks);
        visit.setDate(LocalDate.now());
        visit.setDescription("Claustrophobic after being in Mr Slave's intestine");
        visitService.save(visit);
        
        Pet ericsCoon = new Pet();
        ericsCoon.setName("Coon");
        ericsCoon.setOwner(eric);
        ericsCoon.setPetType(savedPetTypeCoon);
        ericsCoon.setBirthDate(LocalDate.now());
        eric.getPets().add(ericsCoon); 
        
        Vet yaroslav = new Vet();
        yaroslav.setFirstName("Yaroslav");
        yaroslav.setLastName("Tchuma");
        yaroslav.getSpecialities().add(savedSurgery);
        vetService.save(yaroslav);
        
        Vet ace = new Vet();
        ace.setFirstName("Ace");
        ace.setLastName("Ventura");
        ace.getSpecialities().add(savedDentistry);
        vetService.save(ace);
	}

}
