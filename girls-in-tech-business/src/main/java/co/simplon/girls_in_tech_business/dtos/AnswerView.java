package co.simplon.girls_in_tech_business.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record AnswerView(
        Long questionId,
        Long accountId,
        String content,
        LocalDateTime createdAt
) {
}
