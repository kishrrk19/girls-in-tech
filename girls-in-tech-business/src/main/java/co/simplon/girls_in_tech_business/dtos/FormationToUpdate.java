package co.simplon.girls_in_tech_business.dtos;

public record FormationToUpdate(Long formationId,
                                String formationName,
                                String schoolName,
                                String diplomaName,
                                String city,
                                String description,
                                String url) {
}
