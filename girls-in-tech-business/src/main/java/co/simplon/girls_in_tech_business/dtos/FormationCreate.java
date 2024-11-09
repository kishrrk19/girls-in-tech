package co.simplon.girls_in_tech_business.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record FormationCreate(
		@NotBlank @Size(max=200) String formationName,
		@NotBlank @Size(max=200) String schoolName,
		@NotBlank @Size(max=50) String city 
		) {
}
