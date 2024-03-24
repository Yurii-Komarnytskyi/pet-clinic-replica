package com.ykomarnytskyi2022.petclinic.model;

import java.time.LocalDate;
import java.util.Optional;

public class Pet extends BaseEntity {

	private Optional<PetType> petType = Optional.empty();
	private Owner owner;
	private String name;
	private LocalDate birthDay;

	public Optional<PetType> getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		try {
			this.petType = Optional.of(petType);
		} catch (NullPointerException e) {
			throw new RuntimeException("petType CANNOT be null");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

}
