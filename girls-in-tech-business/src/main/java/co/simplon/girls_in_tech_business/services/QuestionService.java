package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.dtos.QuestionCreate;
import co.simplon.girls_in_tech_business.dtos.QuestionView;

import java.util.List;

public interface QuestionService {

    void create (QuestionCreate inputs);

    boolean isUniqueQuestion(QuestionCreate questionInput);

    List<QuestionView> getAllQuestionByFormation(Long formationId);
}
