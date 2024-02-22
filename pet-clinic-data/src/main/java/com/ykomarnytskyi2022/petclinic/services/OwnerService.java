package com.ykomarnytskyi2022.petclinic.services;

import java.util.Set;

import com.ykomarnytskyi2022.petclinic.model.Owner;

public interface OwnerService {

	Owner findByLastName(String lastName);
	
	Owner findById(Long id);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();
	
	
}
