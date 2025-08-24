package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.dtos.QuestionCreate;
import co.simplon.girls_in_tech_business.dtos.QuestionView;
import co.simplon.girls_in_tech_business.entities.Account;
import co.simplon.girls_in_tech_business.entities.Formation;
import co.simplon.girls_in_tech_business.entities.Question;
import co.simplon.girls_in_tech_business.repositories.AccountJPARepository;
import co.simplon.girls_in_tech_business.repositories.FormationJPARepository;
import co.simplon.girls_in_tech_business.repositories.QuestionJPARepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionService {

    private final QuestionJPARepository questions;

    private final AccountJPARepository accounts;

    private final FormationJPARepository formations;

    public QuestionService(QuestionJPARepository questions, AccountJPARepository accounts, FormationJPARepository formations){
        this.questions = questions;
        this.accounts = accounts;
        this.formations = formations;
    }

    public void create (QuestionCreate inputs){

        Account account = accounts.findById(inputs.userId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Formation formation = formations.findById(inputs.formationId())
                .orElseThrow(()-> new IllegalArgumentException("Formation not found"));

        Question question = new Question();
        question.setAccount(account);
        question.setFormation(formation);
        question.setTitle(inputs.title());
        question.setContent(inputs.content());
        question.setCreatedAt(LocalDateTime.now());
        questions.save(question);
    }

    public boolean isUniqueQuestion(QuestionCreate questionInput) {
        return !questions.existsByAccount_IdAndFormation_IdAndTitle(
                questionInput.userId(), questionInput.formationId(), questionInput.title()
        );
    }

    public List<QuestionView> getAllQuestionByFormation(Long formationId) {
        return questions.findAllByFormation_Id(formationId);
    }
}
