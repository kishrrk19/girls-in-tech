package co.simplon.girls_in_tech_business.dtos;

import co.simplon.girls_in_tech_business.validators.UniqueSchoolFormationCity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@UniqueSchoolFormationCity
public record FormationUpdate(
		@NotBlank @Size(max= 200) String formationName,
		@NotBlank @Size(max= 200) String schoolName,
		@NotBlank @Size(max= 50) String city) {

}
