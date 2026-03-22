package co.simplon.girls_in_tech_business.repositories;

import co.simplon.girls_in_tech_business.dtos.AnswerView;
import co.simplon.girls_in_tech_business.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface AnswerJPARepository extends JpaRepository<Answer, Long> {

    List<AnswerView> findAllByQuestion_Formation_Id(Long formationId);

    List<AnswerView> findAllByQuestion_Id(Long questionId);
}
