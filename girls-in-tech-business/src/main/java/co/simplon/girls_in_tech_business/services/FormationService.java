package co.simplon.girls_in_tech_business.services;

import org.springframework.stereotype.Service;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.entities.City;
import co.simplon.girls_in_tech_business.entities.Formation;
import co.simplon.girls_in_tech_business.entities.School;
import co.simplon.girls_in_tech_business.repositories.CityJPARepository;
import co.simplon.girls_in_tech_business.repositories.FormationJPARepository;
import co.simplon.girls_in_tech_business.repositories.SchoolJPARepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class FormationService {
	
	private final FormationJPARepository formations;
	private final SchoolJPARepository schools;
	private final CityJPARepository cities;
	
	public FormationService(FormationJPARepository formations, SchoolJPARepository schools, CityJPARepository cities) {
		this.formations = formations;
		this.schools = schools;
		this.cities = cities;
	}

	@Transactional
	public void create(@Valid FormationCreate inputs) {
		Formation formation = new Formation();
		formation.setName(inputs.formationName());
		formations.save(formation);
		
		School school = new School();
		school.setName(inputs.schoolName());
		schools.save(school);
		
		City city = new City();
		city.setName(inputs.city());
		cities.save(city);
		
		
		
	}

}
