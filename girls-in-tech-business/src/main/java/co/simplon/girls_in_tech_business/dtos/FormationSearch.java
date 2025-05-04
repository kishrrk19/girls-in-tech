package co.simplon.girls_in_tech_business.dtos;

import jakarta.validation.constraints.Size;

public record FormationSearch(
        @Size(max=200) String formationName,
        @Size(max=200) String schoolName,
        @Size(max=200) String diplomaName,
        @Size(max=50) String city
) {
}
