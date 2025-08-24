package co.simplon.girls_in_tech_business.dtos;

import java.time.LocalDateTime;

public record QuestionView(
        Long formationId,
        Long accountId,
        String title,
        String content,
        LocalDateTime createdAt
) {
}
