package com.ykomarnytskyi2022.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "specialities")
public class Speciality extends BaseEntity {
	
	@Column(name = "specialityDescription")
	private String specialityDescription;
	
	public Speciality() {
	}

	public String getSpecialityDescription() {
		return specialityDescription;
	}

	public void setSpecialityDescription(String specialityDescription) {
		this.specialityDescription = specialityDescription;
	}

	
}
