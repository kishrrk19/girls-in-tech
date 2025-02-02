package co.simplon.girls_in_tech_business.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name= "t_formations")
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formation")
	private Long id;
	
	@Column(name= "formation_name")
	String name;
	
	@ManyToMany
    @JoinTable(
        name = "t_have",
        joinColumns = @JoinColumn(name = "have_formation_id"),
        inverseJoinColumns = @JoinColumn(name = "have_school_id")
    )
    private Set<School> schools = new HashSet<>();

	public Formation() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Formation [id=" + id + ", name=" + name + ", schools=" + schools + "]";
	};
	
	

}
