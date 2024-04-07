package com.ykomarnytskyi2022.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ykomarnytskyi2022.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
