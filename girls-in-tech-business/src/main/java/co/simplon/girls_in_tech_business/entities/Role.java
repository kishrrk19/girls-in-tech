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
	
	@Column(name = "default_role")
	private boolean isDefault;
	
	public Role() {
		this.authority= null;
		this.isDefault = false;
	}
	
	public Role(String authority, Boolean isDefault) {
		Objects.requireNonNull(authority);
		Objects.requireNonNull(isDefault);
		this.authority= authority;
		this.isDefault= isDefault;
	}

	public String getAuthority() {
		return authority;
	}

	public boolean isDefault() {
		return isDefault;
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
		return "Role [authority=" + authority + ", isDefault=" + isDefault + "]";
	}
	
	
}
