package com.ykomarnytskyi2022.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.repositories.OwnerRepository;
import com.ykomarnytskyi2022.petclinic.repositories.PetRepository;
import com.ykomarnytskyi2022.petclinic.repositories.PetTypeRepository;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

	private final OwnerRepository ownerRepository;
	@SuppressWarnings("unused")
	private final PetRepository petRepository;
	@SuppressWarnings("unused")
	private final PetTypeRepository petTypeRepository;
	
	@Autowired
	public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository,
			PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().forEach(owners::add);
		return owners;
	}

	@Override
	public Owner findById(Long id) {
		return ownerRepository.findById(id).get();
	}

	@Override
	public Owner save(Owner object) {
		return ownerRepository.save(object);
	}

	@Override
	public void delete(Owner object) {
		ownerRepository.delete(object);
	}

	@Override
	public void deleteByID(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(String lastName) {
		return ownerRepository.findAllByLastNameLike(lastName);
	}

}
