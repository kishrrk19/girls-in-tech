package co.simplon.girls_in_tech_business.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name= "t_formations")
public class Formation extends AbstractEntity{
	
	@Column(name= "name")
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	private School school;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diploma_id")
	private Diploma diploma;

	@Column(name="description")
	private String description;

	@Column(name="url")
	private String url;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    ;
	
	

}
