package co.simplon.girls_in_tech_business.repositories;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.simplon.girls_in_tech_business.dtos.FormationDetail;
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
	
	@Query("SELECT new co.simplon.girls_in_tech_business.dtos.FormationView(f.id, f.name, s.name, d.name, c.name) " +
			"FROM Formation f " +
			"JOIN f.school s " +
			"JOIN s.city c " +
			"JOIN f.diploma d")
	List<FormationView> findAllFormations();

	Formation findByNameAndSchool(String inputFormation, School school);

	@Query("SELECT new co.simplon.girls_in_tech_business.dtos.FormationDetail(f.id, f.name, s.name, d.name, c.name) " +
			"FROM Formation f " +
			"JOIN f.school s " +
			"JOIN s.city c " +
			"JOIN f.diploma d " +
			"WHERE f.id = :formationId")
	FormationDetail findFormationDetail(Long formationId);
	
	

}
