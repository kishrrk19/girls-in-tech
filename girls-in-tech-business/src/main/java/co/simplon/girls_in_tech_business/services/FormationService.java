package co.simplon.girls_in_tech_business.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.dtos.FormationUpdate;
import co.simplon.girls_in_tech_business.dtos.FormationView;
import co.simplon.girls_in_tech_business.entities.City;
import co.simplon.girls_in_tech_business.entities.Diploma;
import co.simplon.girls_in_tech_business.entities.Formation;
import co.simplon.girls_in_tech_business.entities.School;
import co.simplon.girls_in_tech_business.repositories.CityJPARepository;
import co.simplon.girls_in_tech_business.repositories.DiplomaJPARepository;
import co.simplon.girls_in_tech_business.repositories.FormationJPARepository;
import co.simplon.girls_in_tech_business.repositories.SchoolJPARepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class FormationService {
	
	private final FormationJPARepository formations;
	private final SchoolJPARepository schools;
	private final CityJPARepository cities;
	private final DiplomaJPARepository diplomas;
	
	public FormationService(FormationJPARepository formations, SchoolJPARepository schools, CityJPARepository cities, DiplomaJPARepository diplomas) {
		this.formations = formations;
		this.schools = schools;
		this.cities = cities;
		this.diplomas = diplomas;
	}

	@Transactional
	public void create(@Valid FormationCreate inputs) {
		
		//City
		String inputCity = inputs.city();
		inputCity= inputCity.trim();
		if(inputCity == null || inputCity.isEmpty()) {
			//TODO: exception
		}
		City city = cities.findByNameIgnoreCase(inputCity);
		if(city == null) {
			city = new City();
			city.setName(inputs.city());	
			cities.save(city);
		}
		
		
		String inputSchool = inputs.schoolName();
		inputSchool = inputSchool.trim();
		if(inputSchool == null || inputSchool.isEmpty()) {
			//exception
		}
		School school = schools.findByNameIgnoreCase(inputSchool);
		if(school == null) {
			school = new School();
			school.setName(inputs.schoolName());
			school.setCity(city);
	        schools.save(school); 
		}
		
		String inputDiploma = inputs.diplomaName();
		inputDiploma = inputDiploma.trim();
		if(inputDiploma == null || inputDiploma.isEmpty()) {
			// exception todo
		}
		Diploma diploma = diplomas.findByNameIgnoreCase(inputDiploma);
		if(diploma == null) {
			diploma = new Diploma();
			diploma.setName(inputDiploma);
			diplomas.save(diploma);
		}

		
		String inputFormation = inputs.formationName();
		inputFormation = inputFormation.trim();
		if(inputFormation == null || inputFormation.isEmpty()) {
			//creer custom exception
			//throw new LanguageTechnologyInvalidNameException("Language technology name cannot be empty.");
		}
		Formation formation = formations.findByNameAndSchool(inputFormation, school);
		if(formation == null) { // create
			formation = new Formation();
			formation.setName(inputs.formationName());
			formation.setSchool(school);
			formation.setDiploma(diploma);
				formations.save(formation); // Save formation with the new school
	        } else {// すでにformationがある場合、saveすらしていないので、データベースにアクセスすらしていない。なのでエラーも発生しえない。
	    	// Formation with the same name and school already exists
	        if (!formation.getDiploma().equals(diploma)) {
	        	throw new DataIntegrityViolationException("A Formation with the same name already exists for this school but with a different diploma.");
	        }else{
	        	throw new DataIntegrityViolationException("This formation is already registerd.");
	        }
	        
	        };
		
	}

	public boolean isUniqueCombination(String formationName,String schoolName, String diplomaName, String city) {
		
        School school = schools.findByNameIgnoreCase(schoolName);
        if(school != null && !school.getCity().getName().equalsIgnoreCase(city)) {
        	return false;//when city is different compare to the already defined city
        }
        
        Formation formation = formations.findByNameAndSchool(formationName, school);
        return formation == null || !(formation.getSchool().equals(school) && 
        		formation.getDiploma().getName().equalsIgnoreCase(diplomaName));
    }
	

//	public FormationView getOneFormation(Long autoId) {
//		FormationView oneFormation;
//		oneFormation = 
//		
//		return null;
//	}

//	public List<FormationView> getFormationsList(Long formationId) {
//		return formations.findFormationListByFormationId(formationId);
//	}

//	public FormationView getOneFormation(Long associateId) {
//		return haves.findFormationViewByHaveId(associateId);
//	}
//
//	public void updateFormation(Long associateId, @Valid FormationUpdate inputs) {
//		Have oneFormation = haves.findById(associateId)
//				.orElseThrow(() -> new EntityNotFoundException("Have not found with id " + associateId));
//		
//		Formation formation = formations.findByName(inputs.formationName());
//		if (formation == null) {
//			formation = new Formation();
//			formation.setName(inputs.formationName());
//			formation = formations.save(formation);
//			}
//		        
//
//		School school = schools.findByNameIgnoreCase(inputs.schoolName());
//		if (school == null) {
//			school = new School();
//			school.setName(inputs.schoolName());
//			school = schools.save(school);
//		}
//
//		City city = cities.findByName(inputs.city());
//		if (city == null) {
//			city = new City();
//			city.setName(inputs.city());
//			city = cities.save(city);
//		}
//		    // School の City を確認してマッチしない場合例外をスロー
//		if (!school.getCity().equals(city)) {
//		    school.setCity(city);
//		    schools.save(school);
//		}
//		    
//		oneFormation.setFormation(formation);
//		oneFormation.setSchool(school);
//		
//		haves.save(oneFormation);
//		
//	}
//
//	public void deleteFormation(Long id) {
//		haves.deleteById(id);
//		
//	}

}
