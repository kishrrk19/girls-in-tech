package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.dtos.AnswerCreate;
import co.simplon.girls_in_tech_business.dtos.AnswerView;
import co.simplon.girls_in_tech_business.entities.Account;
import co.simplon.girls_in_tech_business.entities.Answer;
import co.simplon.girls_in_tech_business.entities.Question;
import co.simplon.girls_in_tech_business.repositories.AccountJPARepository;
import co.simplon.girls_in_tech_business.repositories.AnswerJPARepository;
import co.simplon.girls_in_tech_business.repositories.QuestionJPARepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService{

    private final AnswerJPARepository answers;
    private final QuestionJPARepository questions;
    private final AccountJPARepository accounts;

    public AnswerServiceImpl(AnswerJPARepository answers, QuestionJPARepository questions, AccountJPARepository accounts) {
        this.answers = answers;
        this.questions = questions;
        this.accounts = accounts;
    }

    @Transactional
    @Override
    public void create(AnswerCreate answerInputs){
        Question question = questions.findById(answerInputs.questionId())
                .orElseThrow(()-> new IllegalArgumentException("Question Not found"));

        Account account = accounts.findById(answerInputs.answeredAccountId())
                .orElseThrow(()-> new IllegalArgumentException("Account Not found"));

        Answer answer = new Answer();
        answer.setAccount(account);
        answer.setQuestion(question);
        answer.setContent(answerInputs.content());
        answer.setCreatedAt(LocalDateTime.now());

        answers.save(answer);
    }

    @Override
    public List<AnswerView> getAllAnswersByQuestion(Long questionId) {
        return answers.findAllByQuestion_Id(questionId)
                .stream()
                .map(answer -> new AnswerView(answer.questionId(), answer.accountId(), answer.content(), answer.createdAt()))
                .collect(Collectors.toList());
    }
}
