package co.simplon.girls_in_tech_business.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "t_accounts")
public class Account extends AbstractEntity{

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "t_associate",
			joinColumns = @JoinColumn (name = "associate_account_id"),
			inverseJoinColumns = @JoinColumn(name = "associate_role_id") //inverseJoinColumnsは、その中間テーブルで「相手のエンティティ（Role）の情報が入るカラム」を指定するためのもの。
			)
	private Set<Role> roles ;

	public Account() {
	}
	
	public Account(String username, String password, Set<Role> roles) {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);
		Objects.requireNonNull(roles);
		
		this.username= username;
		this.password= password;
		this.roles = new HashSet<>();
		for (Role role : roles) {
			addRole(role);
		}
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
	
	public Set<Role> getRoles() {
		return Collections.unmodifiableSet(roles);
	}

	public void addRole(Role role) {
		Objects.requireNonNull(role);
		roles.add(role);
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
	
}
