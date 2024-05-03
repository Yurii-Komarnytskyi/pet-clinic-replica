package com.ykomarnytskyi2022.petclinic.services.map;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Pet;
import com.ykomarnytskyi2022.petclinic.model.Visit;
import com.ykomarnytskyi2022.petclinic.services.VisitService;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
	
	static final Visit SPECIAL_CASE_OBJECT;
	
	static {
		SPECIAL_CASE_OBJECT = new Visit();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setDescription("No description, SPECIAL_CASE_OBJECT");
		SPECIAL_CASE_OBJECT.setDate(LocalDate.now());
		SPECIAL_CASE_OBJECT.setPet(PetMapService.SPECIAL_CASE_OBJECT);
		
	}
	
	@Override
	protected Visit getSpecialCaseObject() {
		return null;
	}
	
	@Override
	public Set<Visit> findAll(){
		return super.findAll();
	}

	@Override
	public Visit findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Visit save(Visit object) {
		return super.save(object);
	}

	@Override
	public void delete(Visit object) {
		super.delete(object);
	}

	@Override
	public void deleteByID(Long id) {
		super.deleteById(id);
	}

}
