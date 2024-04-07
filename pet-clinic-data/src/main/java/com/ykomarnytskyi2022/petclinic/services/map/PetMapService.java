package com.ykomarnytskyi2022.petclinic.services.map;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Pet;
import com.ykomarnytskyi2022.petclinic.services.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService{
	
	static final Pet SPECIAL_CASE_OBJECT;
	static {
		SPECIAL_CASE_OBJECT = new Pet();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setBirthDate(LocalDate.now());
		SPECIAL_CASE_OBJECT.setOwner(OwnerMapService.SPECIAL_CASE_OBJECT);
		SPECIAL_CASE_OBJECT.setPetType(PetTypeMapService.SPECIAL_CASE_OBJECT);
	}

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet pet) {
		return super.save(pet);
	}

	@Override
	public void delete(Pet pet) {
		super.delete(pet);
	}

	@Override
	public void deleteByID(Long id) {
		super.deleteById(id);
	}

	@Override
	protected Pet getSpecialCaseObject() {
		return SPECIAL_CASE_OBJECT;
	}

}
