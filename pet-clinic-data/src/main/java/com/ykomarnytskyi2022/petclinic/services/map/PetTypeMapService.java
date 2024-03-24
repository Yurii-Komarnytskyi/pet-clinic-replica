package com.ykomarnytskyi2022.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.PetType;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
	
	static final PetType SPECIAL_CASE_OBJECT;
	static {
		SPECIAL_CASE_OBJECT = new PetType();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setName("No pet type, SPECIAL_CASE_OBJECT");
	}

	@Override
	public Set<PetType> findAll() {
		return super.findAll();
	}
	
	@Override
	public PetType findById(Long id) {
		return super.findById(id);
	}

	@Override
	public PetType save(PetType object) {
		return super.save(object);
	}

	@Override
	public void delete(PetType object) {
		super.delete(object);
	}

	@Override
	public void deleteByID(Long id) {
		super.deleteById(id);
	}

	@Override
	protected PetType getSpecialCaseObject() {
		return SPECIAL_CASE_OBJECT;
	}

}
