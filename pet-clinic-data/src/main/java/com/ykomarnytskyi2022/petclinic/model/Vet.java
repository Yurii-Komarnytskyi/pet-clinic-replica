package com.ykomarnytskyi2022.petclinic.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Vet extends Person {

	private Optional<Set<Speciality>> specialities = Optional.of(new HashSet<>());

	public Optional<Set<Speciality>> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		try {
			this.specialities = Optional.of(specialities);
		} catch (NullPointerException e) {
			throw new RuntimeException("specialities CANNOT be null");
		}
	}
	
	
}
