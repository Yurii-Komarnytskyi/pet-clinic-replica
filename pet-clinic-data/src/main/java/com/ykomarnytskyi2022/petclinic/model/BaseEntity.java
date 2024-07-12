package com.ykomarnytskyi2022.petclinic.model;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public BaseEntity(Long id) {
		this.id = id;
	}
	
	public BaseEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isNew() {
		return this.id == null;
	}
}
