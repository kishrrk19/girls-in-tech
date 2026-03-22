package co.simplon.girls_in_tech_business.dtos;

public record FormationView(
		Long formationId,
		String formationName,
		String schoolName,
		String diplomaName,
		String city,
		String description,
		String url) {
}
