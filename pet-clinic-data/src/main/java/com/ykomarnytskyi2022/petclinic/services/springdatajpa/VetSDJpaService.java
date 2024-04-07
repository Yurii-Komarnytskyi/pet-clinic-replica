package com.ykomarnytskyi2022.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Vet;
import com.ykomarnytskyi2022.petclinic.repositories.VetRepository;
import com.ykomarnytskyi2022.petclinic.services.VetService;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {

	private final VetRepository vetRepository;

	@Autowired
	public VetSDJpaService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().forEach(vets::add);
		return vets;
	}

	@Override
	public Vet findById(Long id) {
		return vetRepository.findById(id).get();
	}

	@Override
	public Vet save(Vet object) {
		return vetRepository.save(object);
	}

	@Override
	public void delete(Vet object) {
		vetRepository.delete(object);
	}

	@Override
	public void deleteByID(Long id) {
		vetRepository.deleteById(id);
	}

}
