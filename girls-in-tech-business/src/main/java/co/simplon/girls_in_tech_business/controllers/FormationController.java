package co.simplon.girls_in_tech_business.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.dtos.FormationView;
import co.simplon.girls_in_tech_business.services.FormationService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/formation")
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
	
	@GetMapping("/formations/{formationId}")
	public ResponseEntity<List<FormationView>> getFormations(@PathVariable Long formationId){
		List<FormationView> formationsList = service.getFormationsList(formationId);
		return ResponseEntity.ok(formationsList);
	}

}
