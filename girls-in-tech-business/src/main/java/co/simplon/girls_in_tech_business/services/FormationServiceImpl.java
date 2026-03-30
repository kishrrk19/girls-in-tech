package co.simplon.girls_in_tech_business.services;

import java.util.List;

import co.simplon.girls_in_tech_business.dtos.*;
import co.simplon.girls_in_tech_business.repositories.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import co.simplon.girls_in_tech_business.entities.City;
import co.simplon.girls_in_tech_business.entities.Diploma;
import co.simplon.girls_in_tech_business.entities.Formation;
import co.simplon.girls_in_tech_business.entities.School;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FormationServiceImpl implements FormationService{
	
	private final FormationJPARepository formations;
	private final SchoolJPARepository schools;
	private final CityJPARepository cities;
	private final DiplomaJPARepository diplomas;
	
	public FormationServiceImpl(FormationJPARepository formations, SchoolJPARepository schools, CityJPARepository cities, DiplomaJPARepository diplomas) {
		this.formations = formations;
		this.schools = schools;
		this.cities = cities;
		this.diplomas = diplomas;
	}

	@Override
	@Transactional
	public void create(FormationCreate inputs) {
		
		//City
		String inputCity = inputs.city();
		inputCity= inputCity.trim();
		City city = cities.findByNameIgnoreCase(inputCity);
		if(city == null) {
			city = new City();
			city.setName(inputs.city());	
			cities.save(city);
		}
		
		//School
		String inputSchool = inputs.schoolName();
		inputSchool = inputSchool.trim();
		School school = schools.findByNameIgnoreCase(inputSchool);
		if(school == null) {
			school = new School();
			school.setName(inputs.schoolName());
			school.setCity(city);
	        schools.save(school); 
		}

		//Diploma
		String inputDiploma = inputs.diplomaName();
		inputDiploma = inputDiploma.trim();
		Diploma diploma = diplomas.findByNameIgnoreCase(inputDiploma);
		if(diploma == null) {
			diploma = new Diploma();
			diploma.setName(inputDiploma);
			diplomas.save(diploma);
		}

		//Formation
		String inputFormation = inputs.formationName();
		inputFormation = inputFormation.trim();

		Formation formation = formations.findByNameAndSchool(inputFormation, school);
		if(formation == null) { // create
			formation = new Formation();
			formation.setName(inputs.formationName());
			formation.setSchool(school);
			formation.setDiploma(diploma);
			formation.setDescription((inputs.description() == null || inputs.description().isBlank()) ? null : inputs.description());
			formation.setUrl((inputs.url() == null || inputs.url().isBlank()) ? null : inputs.url());
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

	@Override
	public boolean isUniqueCombination(String formationName,String schoolName, String diplomaName, String city) {
		
        School school = schools.findByNameIgnoreCase(schoolName);
        if(school != null && !school.getCity().getName().equalsIgnoreCase(city)) {
        	return false;//when city is different compare to the already defined city
        }
        
        Formation formation = formations.findByNameAndSchool(formationName, school);
        return formation == null || !(formation.getSchool().equals(school) && 
        		formation.getDiploma().getName().equalsIgnoreCase(diplomaName));
    }

	@Override
	public List<FormationView> getAllFormations() {
		return formations.findAllFormations();
	}

	@Override
	public FormationDetail getFormationAllInfo(Long formationId) {
		return formations.findFormationDetail(formationId);
	}

	@Override
    public FormationTotalResult searchFormation(FormationSearch formationSearch, int page, int size) {
		Specification<Formation> spec = Specification
				.where(FormationSpecification.formationNameContains(formationSearch.formationName()))
				.and(FormationSpecification.schoolNameContains(formationSearch.schoolName()))
				.and(FormationSpecification.diplomaNameContains(formationSearch.diplomaName()))
				.and(FormationSpecification.cityNameContains(formationSearch.city()));
		Pageable pageable = PageRequest.of(page, size);
		Page<Formation> results = formations.findAll(spec, pageable);
		Page<FormationSearchResult> resultsList= results.map(FormationSearchResult::new);
		List<FormationSearchResult> data = resultsList.getContent();
		Long totalElements = results.getTotalElements();
		int currentPage = results.getNumber();
		int pageSize = results.getSize();

		return new FormationTotalResult(data, totalElements, currentPage, pageSize);
    }

	@Override
	public FormationToUpdate getFormationInfoToUpdate(Long formationId) {
		return formations.findFormationToUpdate(formationId);
	}

	@Override
	@Transactional
	public void updateFormation(Long formationId, FormationUpdate inputs) {
		Formation formationToUpdate = formations.findById(formationId)
				.orElseThrow(() -> new EntityNotFoundException("Have not found with id " + formationId));

		formationToUpdate.setName(inputs.formationName());
		formationToUpdate.setUrl(
				(inputs.url() == null || inputs.url().isBlank()) ? null : inputs.url()
		);
		formationToUpdate.setDescription(
				(inputs.description() == null || inputs.description().isBlank()) ? null : inputs.description()
		);

		Diploma diploma = diplomas.findByNameIgnoreCase(inputs.diplomaName());
		if(diploma == null){
			diploma = new Diploma();
			diploma.setName(inputs.diplomaName());
			diploma = diplomas.save(diploma);
		}
		City city = cities.findByName(inputs.city());
		if (city == null) {
			city = new City();
			city.setName(inputs.city());
			city = cities.save(city);
		}

		School school = schools.findByNameIgnoreCaseAndCityId(inputs.schoolName(), city.getId());
		if (school == null) {
			school = new School();
			school.setName(inputs.schoolName());
			school.setCity(city);
			school = schools.save(school);
		}

		    // School の City を確認してマッチしない場合例外をスロー
		if (!school.getCity().equals(city)) {
		    school.setCity(city);
		    schools.save(school);
		}

		formationToUpdate.setSchool(school);
		formationToUpdate.setDiploma(diploma);
		formationToUpdate.setSchool(school);

		formations.save(formationToUpdate);

	}

	@Override
	@Transactional
	public void deleteFormation(Long id) {
		formations.deleteById(id);
	}

}
