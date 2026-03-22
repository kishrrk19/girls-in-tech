package co.simplon.girls_in_tech_business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.girls_in_tech_business.entities.Diploma;

public interface DiplomaJPARepository extends JpaRepository<Diploma, Long> {

	Diploma findByNameIgnoreCase(String inputDiploma);

}
