package co.simplon.girls_in_tech_business.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "t_have")
public class Have {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_have")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "have_formation_id")
	private Formation formation;
	
	@ManyToOne
	@JoinColumn(name= "have_school_id")
	private School school;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "Have [id=" + id + ", formation=" + formation + ", school=" + school + "]";
	}
	
	

	
}
