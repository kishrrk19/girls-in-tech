package co.simplon.girls_in_tech_business.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.services.FormationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/formation")
@CrossOrigin("*")
public class FormationController {
	private final FormationService service;
	
	public FormationController(FormationService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	ResponseEntity<Object> createFormation(@Valid @RequestBody FormationCreate inputs){
		service.create(inputs);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	

}
