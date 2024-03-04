package com.ykomarnytskyi2022.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.VetService;
import com.ykomarnytskyi2022.petclinic.services.map.OwnerServiceMap;
import com.ykomarnytskyi2022.petclinic.services.map.VetServiceMap;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService; 
	private final VetService vetService;
	
	
	
	public DataLoader() {
		ownerService = new OwnerServiceMap();
		vetService = new VetServiceMap();
	}



	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
