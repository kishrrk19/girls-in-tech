package co.simplon.girls_in_tech_business.dtos;

import co.simplon.girls_in_tech_business.validators.UniqueEmail;
import jakarta.validation.constraints.*;

public record AccountCreate(
		@NotBlank @Email @UniqueEmail String username,
		@NotBlank @Pattern( regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}$") String password,
		@NotBlank @Size(max = 60 ) String firstName,
		@NotBlank @Size(max = 100) String lastName,
		@NotNull Long roleId) {

	@Override
	public String toString() {
		return "AccountCreate [username=" + username + ", password=[PROTECTED] ]";
	}
	
	

}
