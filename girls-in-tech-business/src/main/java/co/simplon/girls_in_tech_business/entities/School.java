package co.simplon.girls_in_tech_business.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name= "t_schools")
public class School extends AbstractEntity{
	
	@Column(name= "name")
	private String name;
	
//	@ManyToMany(mappedBy = "schools", cascade = CascadeType.PERSIST)
//    private Set<Formation> formations = new HashSet<>();
//	
	@ManyToOne(fetch = FetchType.EAGER)
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
