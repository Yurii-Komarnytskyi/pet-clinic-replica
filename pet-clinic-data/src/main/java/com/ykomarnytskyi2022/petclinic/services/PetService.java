package com.ykomarnytskyi2022.petclinic.services;

import java.util.Set;

import com.ykomarnytskyi2022.petclinic.model.Pet;


public interface PetService {

	Pet findById(Long id);

	Pet save(Pet pet);

	Set<Pet> findAll();
}
