package co.simplon.girls_in_tech_business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.girls_in_tech_business.entities.City;
import co.simplon.girls_in_tech_business.entities.School;

@Repository
public interface SchoolJPARepository extends JpaRepository<School, Long>{

	School findByNameAndCity(String schoolName, City city);

	boolean existsByIdAndFormations_Id(Long id, Long id2);

	School findByNameIgnoreCase(String inputSchool);

}
