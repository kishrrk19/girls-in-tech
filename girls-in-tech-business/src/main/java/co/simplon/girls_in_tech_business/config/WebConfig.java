package co.simplon.girls_in_tech_business.config;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {
	
	@Value("${co.simplon.girls_in_tech.toursBCrypt}")
	private int tours;
	
	@Value("${co.simplon.girls_in_tech.secretJWT}")
	private String secret;
	
	@Value("${co.simplon.girls_in_tech.expirationMinutes}")
	private int expirationMinutes;
	
	@Value("${co.simplon.girls_in_tech.issuer}")
	private String issuer;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		
		@Value("${co.simplon.girls_in_tech.cors}")
		private String origins;
		
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
			.allowedMethods("POST", "GET", "PATCH", "PUT", "DELETE")
			.allowedOrigins(origins);
		}
	};
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(tours);
	}
	
	@Bean
	JwtProvider jwtProvider() {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		return new JwtProvider(algorithm,expirationMinutes, issuer);
	}
	
	@Bean
	JwtDecoder jwtDecoder() {
		SecretKey secretKey = new SecretKeySpec(secret.getBytes(),"HMACSHA256");
		
		OAuth2TokenValidator<Jwt> validators = JwtValidators.createDefaultWithIssuer(issuer);
		
		NimbusJwtDecoder decoder = NimbusJwtDecoder.withSecretKey(secretKey)
				.macAlgorithm(MacAlgorithm.HS256)
				.build();
		
		decoder.setJwtValidator(validators);
		
		return decoder;
		
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http.cors(Customizer.withDefaults()).csrf((csrf)-> csrf.disable())
				.authorizeHttpRequests((req)-> req
						.requestMatchers(HttpMethod.POST,"/account/creer-compte", "/account/login").anonymous()
						.requestMatchers(HttpMethod.POST, "/formation/create").permitAll()
						.requestMatchers(HttpMethod.PUT, "/formation/update/*").permitAll()
	                    .requestMatchers(HttpMethod.GET,  "/formation/*", "/formation/formations/*").permitAll() 
						.anyRequest().authenticated()// 他は全部認証が必要
						)
				.oauth2ResourceServer((srv)-> srv.jwt(Customizer.withDefaults()))
				.build();
				
	}

}
