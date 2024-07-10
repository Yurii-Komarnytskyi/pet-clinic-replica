package com.ykomarnytskyi2022.petclinic.model;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "owners")
public class Owner extends Person {

	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "telephone")
	private String telephone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
	
	public Owner() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<Pet> getPets() {
		return Optional.ofNullable(pets).get();
	}

	public void setPets(Set<Pet> pets) {
		try {
			this.pets.addAll(Optional.ofNullable(pets).get());			
		} catch (NullPointerException e) {
			throw new RuntimeException("Set of pets CANNOT be null on Owner");
		}
	}
	
	public Pet getPet(String name) {
		return getPet(name, false);
	}

	public Pet getPet(String petName, boolean newIgnored) {
		String petNameLowercased = petName.toLowerCase();
		for (Pet pet : pets) {
			if(!newIgnored || !pet.isNew()) {
				String compNameLowercased = pet.getName().toLowerCase();
				if(petNameLowercased.equals(compNameLowercased)) {
					 return pet;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Owner [getName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getId()=" + getId() + "]";
	}

	

}
