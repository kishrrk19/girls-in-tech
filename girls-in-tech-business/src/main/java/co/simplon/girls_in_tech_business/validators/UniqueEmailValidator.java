package co.simplon.girls_in_tech_business.validators;

import co.simplon.girls_in_tech_business.services.AccountService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final AccountService service;

    public UniqueEmailValidator(AccountService service) {
        this.service = service;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context){
        if(email != null){
            return !service.emailExist(email);
        }
        return true;
    }
}
