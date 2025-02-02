package co.simplon.girls_in_tech_business.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.girls_in_tech_business.entities.Role;

public interface RoleJPARepository extends JpaRepository<Role, Long>{

	Set<Role> findByIsDefaultTrue();

}
