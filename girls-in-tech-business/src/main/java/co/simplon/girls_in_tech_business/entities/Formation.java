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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name= "t_formations")
public class Formation extends AbstractEntity{
	
	@Column(name= "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	
	@ManyToOne
	@JoinColumn(name = "diploma_id")
	private Diploma diploma;
	
	
//	@ManyToMany
//    @JoinTable(
//        name = "t_have",
//        joinColumns = @JoinColumn(name = "have_formation_id"),
//        inverseJoinColumns = @JoinColumn(name = "have_school_id")
//    )
//    private Set<School> schools = new HashSet<>();

	public Formation() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Diploma getDiploma() {
		return diploma;
	}

	public void setDiploma(Diploma diploma) {
		this.diploma = diploma;
	}

	@Override
	public String toString() {
		return "Formation [name=" + name + ", school=" + school + "]";
	}

	;
	
	

}
