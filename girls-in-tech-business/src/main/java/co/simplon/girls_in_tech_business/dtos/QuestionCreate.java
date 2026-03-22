package co.simplon.girls_in_tech_business.dtos;

import co.simplon.girls_in_tech_business.validators.UniqueQuestion;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@UniqueQuestion
public record QuestionCreate (
        @NotNull Long formationId,
        @NotBlank String title,
        @NotBlank String content
) {
}
