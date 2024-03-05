package com.ykomarnytskyi2022.petclinic.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.model.Vet;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService; 
	private final VetService vetService;
	
	
	@Autowired
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}



	@Override
	public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setName("Michael");
        owner1.setSurname("Weston");
        ownerService.save(owner1);
        
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setName("Fiona");
        owner2.setSurname("Glenanne");
        ownerService.save(owner2);

        
        Vet yaroslav = new Vet();
        yaroslav.setId(3L);
        yaroslav.setName("Yaroslav");
        yaroslav.setSurname("Tchuma");
        vetService.save(yaroslav);
        
        Vet ace = new Vet();
        ace.setId(4L);
        ace.setName("Ace");
        ace.setSurname("Ventura");
        vetService.save(ace);
	}

}
