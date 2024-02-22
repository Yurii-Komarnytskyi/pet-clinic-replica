package com.ykomarnytskyi2022.petclinic.services;

import java.util.Set;

import com.ykomarnytskyi2022.petclinic.model.Vet;

public interface VetService {

	Vet findById(Long id);
	
	Vet save(Vet vet);
	
	Set<Vet> findAll();
}

