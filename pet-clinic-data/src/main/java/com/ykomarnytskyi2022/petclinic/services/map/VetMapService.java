package com.ykomarnytskyi2022.petclinic.services.map;

import java.util.Collections;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.PetType;
import com.ykomarnytskyi2022.petclinic.model.Vet;
import com.ykomarnytskyi2022.petclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	static final Vet SPECIAL_CASE_OBJECT;
	static {
		SPECIAL_CASE_OBJECT = new Vet();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setName("specialCaseObject thus no name");
		SPECIAL_CASE_OBJECT.setSurname("specialCaseObject thus no surname");
		SPECIAL_CASE_OBJECT.setSpecialities(Collections.emptySet());
	}

	
	@Override
	public Set<Vet> findAll(){
		return super.findAll();
	}
	
	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet vet) {
		return super.save(vet);
	}

	@Override
	public void delete(Vet vet) {
		super.delete(vet);
	}

	@Override
	public void deleteByID(Long id) {
		super.deleteById(id);
	}

	@Override
	protected Vet getSpecialCaseObject() {
		return SPECIAL_CASE_OBJECT;
	}

}
