package com.ykomarnytskyi2022.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ykomarnytskyi2022.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
