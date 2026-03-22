package co.simplon.girls_in_tech_business.validators;

import co.simplon.girls_in_tech_business.dtos.QuestionCreate;
import co.simplon.girls_in_tech_business.services.QuestionService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueQuestionValidator implements ConstraintValidator<UniqueQuestion, QuestionCreate> {

    private final QuestionService service;

    public UniqueQuestionValidator(QuestionService service) {
        this.service = service;
    }

    @Override
    public boolean isValid(QuestionCreate questionInput, ConstraintValidatorContext context){
        return service.isUniqueQuestion(questionInput);
    }
}
