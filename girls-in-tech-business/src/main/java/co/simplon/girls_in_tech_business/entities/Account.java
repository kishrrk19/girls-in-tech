package co.simplon.girls_in_tech_business.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "t_accounts")
public class Account extends AbstractEntity{

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	@Column(name="first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "role_id")
	private Role role ;

	public Account() {
	}
	
	public Account(String username, String password, Role role) {
		
		this.username= username;
		this.password= password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this== obj) {
			return true;
		}
		if(!(obj instanceof Account)) {
			return false;
		}
		
		Account other = (Account) obj;
		return username.equals(other.username);
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", password=PROTECTED roles = LAZY_LOADED]";
	}

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
