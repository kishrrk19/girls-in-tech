package co.simplon.girls_in_tech_business.validators;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.services.FormationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueSchoolFormationCityValidator implements ConstraintValidator<UniqueSchoolFormationCity, FormationCreate> {

	private final FormationService service;
	
	public UniqueSchoolFormationCityValidator(FormationService service) {
		this.service = service;
	}
	
	@Override
	public boolean isValid(FormationCreate value, ConstraintValidatorContext context) {
		System.out.println("Validator is called");
		if(value == null) {
			return true;
		}
		
		return service.isUniqueCombination(value.formationName(), value.schoolName(), value.city());
	}
}
