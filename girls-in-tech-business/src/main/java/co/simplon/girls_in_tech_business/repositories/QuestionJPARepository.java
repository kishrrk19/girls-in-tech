package co.simplon.girls_in_tech_business.repositories;

import co.simplon.girls_in_tech_business.dtos.QuestionView;
import co.simplon.girls_in_tech_business.entities.Question;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionJPARepository extends JpaRepository<Question, Long> {
    boolean existsByAccount_UsernameAndFormation_IdAndTitle(@NotBlank String username, @NotBlank Long formationId, @NotBlank String title);

    List<QuestionView> findAllByFormation_Id(Long formationId);

    //List<QuestionView> findAllByQuestion_Formation_Id(Long formationId);
}
