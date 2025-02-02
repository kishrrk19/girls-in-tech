package co.simplon.girls_in_tech_business.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.girls_in_tech_business.entities.Account;

@Repository
public interface AccountJPARepository extends JpaRepository<Account,Long>{

	Optional<Account> findByUsernameIgnoreCase(String inputsUsername);

	
}
