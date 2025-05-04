package co.simplon.girls_in_tech_business.dtos;

import co.simplon.girls_in_tech_business.entities.Formation;
import jakarta.validation.constraints.Size;

public record FormationSearchResult(
        Long id,
        String formationName,
        String schoolName,
        String diplomaName,
        String city
) {
    public FormationSearchResult(Formation result) {
        this(
                result.getId(),
                result.getName(),
                result.getSchool().getName(),
                result.getDiploma().getName(),
                result.getSchool().getCity().getName()
        );
    }
}
