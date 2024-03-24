package com.ykomarnytskyi2022.petclinic.services.map;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.support.ReflectivePropertyAccessor.OptimalPropertyAccessor;
import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Owner;
import com.ykomarnytskyi2022.petclinic.services.OwnerService;
import com.ykomarnytskyi2022.petclinic.services.PetService;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;
	static final Owner SPECIAL_CASE_OBJECT;
	static {
		SPECIAL_CASE_OBJECT = new Owner();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setName("specialCaseObject thus no name");
		SPECIAL_CASE_OBJECT.setSurname("specialCaseObject thus no surname");
		SPECIAL_CASE_OBJECT.setCity("specialCaseObject thus no city");
		SPECIAL_CASE_OBJECT.setAddress("specialCaseObject thus no address");
		SPECIAL_CASE_OBJECT.setTelephone("specialCaseObject thus no telephone");
		SPECIAL_CASE_OBJECT.setPets(Collections.emptySet());	
	}

	@Autowired
	public OwnerMapService(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner owner) {
		return super.save(owner);
	}

	@Override
	public void delete(Owner owner) {
		super.delete(owner);
	}

	@Override
	public void deleteByID(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return super.map.entrySet().stream().filter(e -> e.getValue().getSurname() == lastName).map(e -> e.getValue())
				.findFirst().get();
	}

	@Override
	protected Owner getSpecialCaseObject() {
		return SPECIAL_CASE_OBJECT;
	}

}
