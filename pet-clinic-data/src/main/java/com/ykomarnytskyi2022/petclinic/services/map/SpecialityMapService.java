package com.ykomarnytskyi2022.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Speciality;
import com.ykomarnytskyi2022.petclinic.services.SpecialitiesService;

@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality, Long> implements SpecialitiesService {

	static final Speciality SPECIAL_CASE_OBJECT;
	static {
		SPECIAL_CASE_OBJECT = new Speciality();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setSpecialityDescription("Zero speciality, SPECIAL_CASE_OBJECT");
	}

	@Override
	public Set<Speciality> findAll() {
		return super.findAll();
	}

	@Override
	public Speciality findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Speciality save(Speciality object) {
		return super.save(object);
	}

	@Override
	public void delete(Speciality object) {
		super.delete(object);
	}

	@Override
	public void deleteByID(Long id) {
		super.deleteById(id);
	}

	@Override
	protected Speciality getSpecialCaseObject() {
		return SPECIAL_CASE_OBJECT;
	}

}
