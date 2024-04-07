package com.ykomarnytskyi2022.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ykomarnytskyi2022.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
