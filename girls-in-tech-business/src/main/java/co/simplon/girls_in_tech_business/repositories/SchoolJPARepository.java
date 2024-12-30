package co.simplon.girls_in_tech_business.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.girls_in_tech_business.entities.City;
import co.simplon.girls_in_tech_business.entities.Have;
import co.simplon.girls_in_tech_business.entities.School;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Repository
public interface SchoolJPARepository extends JpaRepository<School, Long>{

	School findByNameAndCity(String schoolName, City city);

	boolean existsByIdAndFormations_Id(Long id, Long id2);

	School findByNameIgnoreCase(String inputSchool);

	Optional<Have> findByName(@NotBlank @Size(max = 200) String schoolName);

}
