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
	private Optional<Set<Pet>> pets = Optional.of(new HashSet<Pet>());
	

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

	public Optional<Set<Pet>> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		try {
			this.pets = Optional.of(pets);			
		} catch (NullPointerException e) {
			throw new RuntimeException("Set of pets CANNOT be null");
		}
	}

}
