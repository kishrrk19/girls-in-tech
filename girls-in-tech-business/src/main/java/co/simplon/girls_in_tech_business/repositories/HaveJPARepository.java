package co.simplon.girls_in_tech_business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.simplon.girls_in_tech_business.dtos.FormationView;
import co.simplon.girls_in_tech_business.entities.Have;

public interface HaveJPARepository extends JpaRepository<Have, Long> {

	@Query("""
			SELECT new co.simplon.girls_in_tech_business.dtos.FormationView(f.name, s.name, s.city.name)
	           FROM Have h
	           JOIN h.formation f
	           JOIN h.school s
	           WHERE h.id = :haveId
	           """)
	    FormationView findFormationViewByHaveId(Long haveId);
}
