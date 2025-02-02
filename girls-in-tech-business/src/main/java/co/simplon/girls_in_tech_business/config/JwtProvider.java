package co.simplon.girls_in_tech_business.config;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Set;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.JWTCreator.Builder;

import co.simplon.girls_in_tech_business.entities.Role;

public class JwtProvider {

	private final Algorithm algorithm;
	
	private final int expirationMinutes;
	private final String issuer;
	
	JwtProvider(Algorithm algorithm, int expirationMinutes, String issuer){
		this.algorithm= algorithm;
		this.expirationMinutes= expirationMinutes;
		this.issuer= issuer;
	}
	
	public String create(String subject, Set<Role> roles) {
		Instant issuedAt = Instant.now();
		
		ArrayList<String> rolesList = new ArrayList<>();
		roles.forEach(role -> {
			String authority = role.getAuthority();
			rolesList.add(authority);
		});
		
		String[] rolesArray = rolesList.toArray(new String[0]);
		
		Builder builder = JWT.create().withIssuedAt(issuedAt).withSubject(subject)
				.withExpiresAt(OffsetDateTime.now().plusMinutes(expirationMinutes).toInstant())
				.withIssuer(issuer).withArrayClaim("roles", rolesArray);
				
		return builder.sign(algorithm);
	}
}
