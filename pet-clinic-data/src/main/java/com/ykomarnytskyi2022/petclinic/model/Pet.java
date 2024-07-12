package com.ykomarnytskyi2022.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();
	
	
	
	
	public Pet(Long id, PetType petType, Owner owner, String name, LocalDate birthDate, Set<Visit> visits) {
		super(id);
		this.petType = petType;
		this.owner = owner;
		this.name = name;
		this.birthDate = birthDate;
		
		if(visits == null  || visits.size() > 0) {
			this.visits = visits;			
		}
	}


	public Pet() {
	}


	public Set<Visit> getVisits() {
		return visits;
	}

	public void setVisits(Set<Visit> visits) {
		this.visits.addAll(visits);
	}

	

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		try {
			this.petType = Optional.ofNullable(petType).get();
		} catch (NullPointerException e) {
			throw new RuntimeException("petType field CANNOT be null on Pet");
		}
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
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


}
