package co.simplon.girls_in_tech_business.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import co.simplon.girls_in_tech_business.config.JwtProvider;
import co.simplon.girls_in_tech_business.dtos.AccountCreate;
import co.simplon.girls_in_tech_business.dtos.AuthInfo;
import co.simplon.girls_in_tech_business.dtos.Login;
import co.simplon.girls_in_tech_business.entities.Account;
import co.simplon.girls_in_tech_business.entities.Role;
import co.simplon.girls_in_tech_business.repositories.AccountJPARepository;
import co.simplon.girls_in_tech_business.repositories.RoleJPARepository;
import jakarta.validation.Valid;

@Service
@Transactional(readOnly= true)
public class AccountService {
	
	private final AccountJPARepository accounts;
	private final RoleJPARepository roles;
	private final PasswordEncoder encoder;
	private final JwtProvider jwtProvider;

	public AccountService(AccountJPARepository accounts, RoleJPARepository roles, PasswordEncoder encoder,
			JwtProvider jwtProvider) {
		this.accounts = accounts;
		this.roles = roles;
		this.encoder = encoder;
		this.jwtProvider = jwtProvider;
	}

	@Transactional
	public void create(AccountCreate inputs) {
		
		Set<Role> role = roles.findByIsDefaultTrue();
		
		String username = inputs.username();
		
		String passencode = encoder.encode(inputs.password());
		
		Account account = new Account(username, passencode, role);
		
		accounts.save(account);
		
	}

	public AuthInfo signin(Login inputs) {
		String inputsUsername = inputs.username();
		//verifie si un compte avec username de inputs exists ou pas et recuperer cet entite account
		Account entity = accounts.findByUsernameIgnoreCase(inputsUsername)
				.orElseThrow(() -> new BadCredentialsException(inputsUsername));
		
		//recuperer un set de roles de cet entite pour envoyer avec Token sous forme de AuthInfo DTO
		Set<Role> roles = entity.getRoles();
		Set<String> roleInfos = new HashSet<>();
		
		for(Role role : roles) {
			String rolename = role.getAuthority();
			roleInfos.add(rolename);
		}
		
		boolean compared = encoder.matches(inputs.password(), entity.getPassword());
		if(compared) {
			String tokenJWT = jwtProvider.create(inputsUsername, entity.getRoles());
			
			AuthInfo info = new AuthInfo(tokenJWT, roleInfos);
			return info;
		}else {
			throw new BadCredentialsException(inputsUsername);
		}
		
	}
	

}
