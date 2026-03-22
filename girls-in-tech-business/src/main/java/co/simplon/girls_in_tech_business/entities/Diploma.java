package co.simplon.girls_in_tech_business.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_diplomas")
public class Diploma extends AbstractEntity{
	
	@Column(name="name")
	private String name;
	
	public Diploma() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Diploma [name=" + name + "]";
	}
	
	

}
