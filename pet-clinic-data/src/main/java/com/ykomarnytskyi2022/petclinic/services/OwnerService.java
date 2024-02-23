package com.ykomarnytskyi2022.petclinic.services;

import com.ykomarnytskyi2022.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> { 

	Owner findByLastName(String lastName);
	
}
