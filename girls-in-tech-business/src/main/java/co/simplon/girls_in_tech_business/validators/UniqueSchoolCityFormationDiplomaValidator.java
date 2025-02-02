package co.simplon.girls_in_tech_business.validators;

import co.simplon.girls_in_tech_business.dtos.FormationCreate;
import co.simplon.girls_in_tech_business.services.FormationService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueSchoolCityFormationDiplomaValidator implements ConstraintValidator<UniqueSchoolCityFormationDiploma, Object> {

	private final FormationService service;
	
	public UniqueSchoolCityFormationDiplomaValidator(FormationService service) {
		this.service = service;
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		System.out.println("Validator is called");
		
		if(value == null) {
			return true;//because @NotNull is already do this job
		}
		
		if(value instanceof FormationCreate) {
			FormationCreate formationCreate = (FormationCreate) value;
			return service.isUniqueCombination(formationCreate.formationName(), formationCreate.schoolName(), formationCreate.diplomaName(), formationCreate.city());
		}
		
		return false;
	}
}
