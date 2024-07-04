package com.ykomarnytskyi2022.petclinic.services;

import java.util.List;

import com.ykomarnytskyi2022.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> { 

	Owner findByLastName(String lastName);
	
	List<Owner> findAllByLastNameLike(String lastName);	
	
}
