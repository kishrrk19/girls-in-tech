package co.simplon.girls_in_tech_business.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "t_schools")
public class School extends AbstractEntity{
	
	@Column(name= "name")
	String name;
	
//	@ManyToMany(mappedBy = "schools", cascade = CascadeType.PERSIST)
//    private Set<Formation> formations = new HashSet<>();
//	
	@ManyToOne
    @JoinColumn(name = "city_id", nullable = false)  // city_idでCityと紐付け
    private City city;

	public School() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "School [name=" + name + ", city=" + city + "]";
	}

}
