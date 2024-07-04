package com.ykomarnytskyi2022.petclinic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_type")
public class PetType extends BaseEntity {

	@Column(name = "name")
	private String name;
	
	public PetType(){
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
