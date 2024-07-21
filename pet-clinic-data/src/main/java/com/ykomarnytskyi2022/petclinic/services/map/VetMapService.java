package com.ykomarnytskyi2022.petclinic.services.map;

import java.util.Collections;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.ykomarnytskyi2022.petclinic.model.Speciality;
import com.ykomarnytskyi2022.petclinic.model.Vet;
import com.ykomarnytskyi2022.petclinic.services.SpecialityService;
import com.ykomarnytskyi2022.petclinic.services.VetService;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private final SpecialityService specialityService;
	static final Vet SPECIAL_CASE_OBJECT;
	static {
		SPECIAL_CASE_OBJECT = new Vet();
		SPECIAL_CASE_OBJECT.setId(Long.valueOf(-1));
		SPECIAL_CASE_OBJECT.setFirstName("specialCaseObject thus no name");
		SPECIAL_CASE_OBJECT.setLastName("specialCaseObject thus no surname");
		SPECIAL_CASE_OBJECT.setSpecialities(Collections.emptySet());
	}

	public VetMapService(SpecialityService specialityService) {
		this.specialityService = specialityService;
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
		
		if(vet.getSpecialities().size() > 0) {
			vet.getSpecialities().forEach(speciality -> {
				if(speciality.getId() == null) {
					Speciality savedSpeciality = specialityService.save(speciality);
					speciality.setId(savedSpeciality.getId());
				}
			});
		}
		
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
