package co.simplon.girls_in_tech_business.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniqueSchoolCityFormationDiplomaValidator.class)
public @interface UniqueSchoolCityFormationDiploma {

	String message() default "##########UniqueSchoolCityFormationDiplomaValidator########## The combination of School, Formation, Diploma and City must be unique.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
