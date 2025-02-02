package co.simplon.girls_in_tech_business.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.girls_in_tech_business.dtos.FormationView;
import co.simplon.girls_in_tech_business.entities.Formation;
import co.simplon.girls_in_tech_business.entities.School;

@Repository
public interface FormationJPARepository extends JpaRepository<Formation, Long> {

	Formation findByName(String formationName);

	Formation findByNameIgnoreCase(String inputFormation);

//	@Query("""
//		    SELECT new co.simplon.girls_in_tech_business.dtos.FormationView(f.name, s.name, c.name)
//		    FROM Formation f
//		    JOIN f.schools s
//		    JOIN s.city c
//		    WHERE f.id = :formationId
//		""")
//	List<FormationView> findFormationListByFormationId(Long formationId);

	Formation findByNameAndSchool(String inputFormation, School school);
	
	

}
