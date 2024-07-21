package com.ykomarnytskyi2022.petclinic.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "veterinarians")
public class Vet extends Person {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name ="vet_id"), inverseJoinColumns = @JoinColumn(name ="speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();
	
	public Vet() {
	}

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(Set<Speciality> specialities) {
		try {
			this.specialities.addAll(Optional.ofNullable(specialities).get());			
		} catch (NullPointerException e) {
			throw new RuntimeException("Set of specialities CANNOT be null on Vet");
		}
	}




	
	
}
