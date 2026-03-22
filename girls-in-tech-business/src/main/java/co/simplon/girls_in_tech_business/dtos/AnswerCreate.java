package co.simplon.girls_in_tech_business.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AnswerCreate(
        @NotNull Long questionId,
        @NotNull Long answeredAccountId,
        @NotBlank String content
) {
}
