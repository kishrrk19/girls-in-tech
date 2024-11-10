package co.simplon.girls_in_tech_business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.girls_in_tech_business.entities.City;

@Repository
public interface CityJPARepository extends JpaRepository<City, Long>{

	City findByName(String cityName);

	City findByNameIgnoreCase(String inputCity);

}
