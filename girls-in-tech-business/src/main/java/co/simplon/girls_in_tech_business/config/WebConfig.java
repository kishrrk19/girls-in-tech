package co.simplon.girls_in_tech_business.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebConfig {
	
	@Value("${co.simplon.girls_in_tech.toursBCrypt}")
	private int tours;
	
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
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		return http.cors(Customizer.withDefaults()).csrf((csrf)-> csrf.disable())
				.authorizeHttpRequests((req)-> req
						.requestMatchers(HttpMethod.POST,"/account/creer-compte").anonymous()
						.requestMatchers(HttpMethod.POST, "/formation/create").permitAll() 
	                    .requestMatchers(HttpMethod.GET, "/formation/formations/*").permitAll() 
						.anyRequest().authenticated()// 他は全部認証が必要
						)
				.build();
				
	}

}
