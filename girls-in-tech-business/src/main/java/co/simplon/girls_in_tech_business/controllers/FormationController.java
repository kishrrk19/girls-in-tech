package co.simplon.girls_in_tech_business.controllers;

import java.util.HashSet;
import java.util.List;

import co.simplon.girls_in_tech_business.dtos.*;
import co.simplon.girls_in_tech_business.services.FormationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<HashSet<FormationView>> getAllFormations(){
		List<FormationView> list = service.getAllFormations();
		return ResponseEntity.ok(new HashSet<>(list));
	}
	
	// créer un endpoint pour récupérer tous les données d'une formation par id de formation
	@GetMapping("/{formationId}")
	public ResponseEntity<FormationDetail> getFormationAllInfo(@PathVariable Long formationId){
		FormationDetail formationDetail = service.getFormationAllInfo(formationId);
		return ResponseEntity.ok(formationDetail);
	}

	@PostMapping ("/search")
	public FormationTotalResult searchFormations(@Valid @RequestBody FormationSearch formationSearch,
														@RequestParam(defaultValue = "0") int page,
														@RequestParam(defaultValue = "10") int size){
		FormationTotalResult resultPage = service.searchFormation(formationSearch, page, size);
		return resultPage;
	}

	//For UPDATE
	@GetMapping("to-update/{formationId}")
	public ResponseEntity<FormationToUpdate> getFormationToUpdate(@Valid @PathVariable Long formationId){
		FormationToUpdate formationToUpdate = service.getFormationInfoToUpdate(formationId);
		return ResponseEntity.ok(formationToUpdate);
	}

	@PutMapping("/update/{formationId}")
	void updateFormation(@PathVariable("formationId") Long formationId, @Valid @RequestBody FormationUpdate inputs) {
		service.updateFormation(formationId, inputs);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteFormation(@PathVariable Long id){
		service.deleteFormation(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
