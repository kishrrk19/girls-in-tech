package co.simplon.girls_in_tech_business.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = UniqueQuestionValidator.class)
public @interface UniqueQuestion {

    String message() default "##########UniqueQuestionValidator########## The combination of User, Formation and Title must be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
