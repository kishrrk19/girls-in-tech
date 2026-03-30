package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.dtos.AnswerCreate;
import co.simplon.girls_in_tech_business.dtos.AnswerView;

import java.util.List;

public interface AnswerService {

    void create(AnswerCreate answerInputs);

    List<AnswerView> getAllAnswersByQuestion(Long questionId);
}
