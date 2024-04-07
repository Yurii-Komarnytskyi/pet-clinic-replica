package com.ykomarnytskyi2022.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ykomarnytskyi2022.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
