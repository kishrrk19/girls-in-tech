package co.simplon.girls_in_tech_business.dtos;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

public interface QuestionView{
    Long getId();

    @Value("#{target.account.id}")
    Long getAccountId();
    String getTitle();
    String getContent();
    LocalDateTime getCreatedAt();

    @Value("#{target.account.firstName}")
    String getAccountFirstName();
}
