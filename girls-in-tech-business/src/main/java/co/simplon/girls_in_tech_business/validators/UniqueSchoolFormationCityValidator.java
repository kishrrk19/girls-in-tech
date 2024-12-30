package co.simplon.girls_in_tech_business.validators;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.dtos.FormationUpdate;
import co.simplon.girls_in_tech_business.services.FormationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueSchoolFormationCityValidator implements ConstraintValidator<UniqueSchoolFormationCity, Object> {

	private final FormationService service;
	
	public UniqueSchoolFormationCityValidator(FormationService service) {
		this.service = service;
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println("Validator is called");
		if(value == null) {
			return true;
		}
		
		if(value instanceof FormationCreate) {
			FormationCreate formationCreate = (FormationCreate) value;
			return service.isUniqueCombination(formationCreate.formationName(), formationCreate.schoolName(), formationCreate.city());
		}
		if(value instanceof FormationUpdate) {
			FormationUpdate formationUpdate = (FormationUpdate) value;
			return service.isUniqueCombination(formationUpdate.formationName(), formationUpdate.schoolName(), formationUpdate.city());
		}
		return false;
	}
}
