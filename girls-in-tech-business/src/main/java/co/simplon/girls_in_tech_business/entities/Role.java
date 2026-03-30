package co.simplon.girls_in_tech_business.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_roles")
public class Role extends AbstractEntity {

	@Column(name = "authority")
	private String authority;

	
	public Role() {
	}

	public String getAuthority() {
		return authority;
	}


	@Override
	public int hashCode() {
		return Objects.hash(authority);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		return authority.equals(other.authority);
	}

	@Override
	public String toString() {
		return "Role [authority=" + authority  + "]";
	}
	
	
}
