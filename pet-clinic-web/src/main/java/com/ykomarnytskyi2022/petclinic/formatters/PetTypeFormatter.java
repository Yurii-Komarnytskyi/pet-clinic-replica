package com.ykomarnytskyi2022.petclinic.formatters;

import java.text.ParseException;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.ykomarnytskyi2022.petclinic.model.PetType;
import com.ykomarnytskyi2022.petclinic.services.PetTypeService;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

	private final PetTypeService petTypeService;

	@Autowired
	public PetTypeFormatter(PetTypeService petTypeService) {
		this.petTypeService = petTypeService;
	}

	@Override
	public String print(PetType petType, Locale locale) {
		return petType.getName();
	}

	@Override
	public PetType parse(String text, Locale locale) throws ParseException {
		Set<PetType> foundPetTupes = petTypeService.findAll();
		for (PetType petType : foundPetTupes) {
			if (petType.getName().equals(text)) {
				return petType;
			}
		}
		throw new ParseException("petType AIN'T found".concat(text), 0);
	}

}
	