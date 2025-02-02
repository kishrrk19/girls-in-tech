package co.simplon.girls_in_tech_business.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.dtos.FormationUpdate;
import co.simplon.girls_in_tech_business.dtos.FormationView;
import co.simplon.girls_in_tech_business.entities.City;
import co.simplon.girls_in_tech_business.entities.Formation;
import co.simplon.girls_in_tech_business.entities.Have;
import co.simplon.girls_in_tech_business.entities.School;
import co.simplon.girls_in_tech_business.repositories.CityJPARepository;
import co.simplon.girls_in_tech_business.repositories.FormationJPARepository;
import co.simplon.girls_in_tech_business.repositories.HaveJPARepository;
import co.simplon.girls_in_tech_business.repositories.SchoolJPARepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class FormationService {
	
	private final FormationJPARepository formations;
	private final SchoolJPARepository schools;
	private final CityJPARepository cities;
	private final HaveJPARepository haves;
	
	public FormationService(FormationJPARepository formations, SchoolJPARepository schools, CityJPARepository cities, HaveJPARepository haves) {
		this.formations = formations;
		this.schools = schools;
		this.cities = cities;
		this.haves = haves;
	}

	@Transactional
	public void create(@Valid FormationCreate inputs) {
		
		//City
		String inputCity = inputs.city();
		inputCity= inputCity.trim();
		if(inputCity == null || inputCity.isEmpty()) {
			//exception
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
		//school.setCity(city);
		
		String inputFormation = inputs.formationName();
		inputFormation = inputFormation.trim();
		if(inputFormation == null || inputFormation.isEmpty()) {
			//creer custom exception
			//throw new LanguageTechnologyInvalidNameException("Language technology name cannot be empty.");
		}
		
		Formation formation = formations.findByNameIgnoreCase(inputFormation);
		if(formation == null) { // create
			formation = new Formation();
			formation.setName(inputs.formationName());
			formation.getSchools().add(school); // Add school to formation
	        formations.save(formation); // Save formation with the new school
	    } else {
	        // Formation already exists, add school if not already associated
	        if (!formation.getSchools().contains(school)) {
	            formation.getSchools().add(school);
	            formations.save(formation); // Save only formation
	        }
	        };
		
		
//		formation.getSchools().add(school);
//		formations.save(formation);
//		
//		school.getFormations().add(formation);
//		schools.save(school);
		
	}

	public boolean isUniqueCombination(String formationName,String schoolName, String cityName) {
		
		City city = cities.findByName(cityName);
        School school = schools.findByNameAndCity(schoolName, city);
        Formation formation = formations.findByName(formationName);

        // 学校が存在し、町も一致している場合に、学科との組み合わせを確認
        if (school != null && formation != null) {
            return !schools.existsByIdAndFormations_Id(school.getId(), formation.getId());
        }
        return true;
    }

//	public FormationView getOneFormation(Long autoId) {
//		FormationView oneFormation;
//		oneFormation = 
//		
//		return null;
//	}

	public List<FormationView> getFormationsList(Long formationId) {
		return formations.findFormationListByFormationId(formationId);
	}

	public FormationView getOneFormation(Long associateId) {
		return haves.findFormationViewByHaveId(associateId);
	}

	public void updateFormation(Long associateId, @Valid FormationUpdate inputs) {
		Have oneFormation = haves.findById(associateId)
				.orElseThrow(() -> new EntityNotFoundException("Have not found with id " + associateId));
		
		Formation formation = formations.findByName(inputs.formationName());
		if (formation == null) {
			formation = new Formation();
			formation.setName(inputs.formationName());
			formation = formations.save(formation);
			}
		        

		School school = schools.findByNameIgnoreCase(inputs.schoolName());
		if (school == null) {
			school = new School();
			school.setName(inputs.schoolName());
			school = schools.save(school);
		}

		City city = cities.findByName(inputs.city());
		if (city == null) {
			city = new City();
			city.setName(inputs.city());
			city = cities.save(city);
		}
		    // School の City を確認してマッチしない場合例外をスロー
		if (!school.getCity().equals(city)) {
		    school.setCity(city);
		    schools.save(school);
		}
		    
		oneFormation.setFormation(formation);
		oneFormation.setSchool(school);
		
		haves.save(oneFormation);
		
	}

	public void deleteFormation(Long id) {
		haves.deleteById(id);
		
	}

}
