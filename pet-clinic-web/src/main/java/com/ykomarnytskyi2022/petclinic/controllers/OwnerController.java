package com.ykomarnytskyi2022.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

	@RequestMapping({"/owners" , "/owners/index", "/owners/index.html"})
	public String lostOwners() {
		return "owners/index";
	}
}
