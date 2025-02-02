package co.simplon.girls_in_tech_business.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "t_cities")
public class City extends AbstractEntity{
	
	@Column(name="name")
	String name;
	
	@OneToMany(mappedBy = "city")
    private Set<School> schools = new HashSet<>();

	public City() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", schools=" + schools + "]";
	}

}
