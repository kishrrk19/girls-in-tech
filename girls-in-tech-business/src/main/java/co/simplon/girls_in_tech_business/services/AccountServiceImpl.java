package co.simplon.girls_in_tech_business.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
@Transactional(readOnly= true)
public class AccountServiceImpl implements AccountService{
	
	private final AccountJPARepository accounts;
	private final RoleJPARepository roles;
	private final PasswordEncoder encoder;
	private final JwtProvider jwtProvider;

	public AccountServiceImpl(AccountJPARepository accounts, RoleJPARepository roles, PasswordEncoder encoder,
							  JwtProvider jwtProvider) {
		this.accounts = accounts;
		this.roles = roles;
		this.encoder = encoder;
		this.jwtProvider = jwtProvider;
	}

	@Transactional
	@Override
	public void create(AccountCreate inputs) {

		Role role = roles.findById(inputs.roleId())
				.orElseThrow(()-> new IllegalArgumentException("No role associated"));
		
		String username = inputs.username();
		
		String passencode = encoder.encode(inputs.password());
		
		Account account = new Account();
		account.setUsername(username);
		account.setPassword(passencode);
		account.setRole(role);
		account.setFirstName(inputs.firstName());
		account.setLastName(inputs.lastName());
		
		accounts.save(account);
		
	}

	@Override
	public AuthInfo signin(Login inputs) {
		String inputsUsername = inputs.username();
		//verifie si un compte avec username de inputs exists ou pas et recuperer cet entite account
		Account entity = accounts.findByUsernameIgnoreCase(inputsUsername)
				.orElseThrow(() -> new BadCredentialsException(inputsUsername));
		
		//recuperer un set de roles de cet entite pour envoyer avec Token sous forme de AuthInfo DTO
//		Set<Role> roles = entity.getRoles();
//		Set<String> roleInfos = new HashSet<>();
//
//		for(Role role : roles) {
//			String rolename = role.getAuthority();
//			roleInfos.add(rolename);
//		}
		
		boolean compared = encoder.matches(inputs.password(), entity.getPassword());
		if(compared) {
			String tokenJWT = jwtProvider.create(inputsUsername, entity.getRole());
			
			AuthInfo info = new AuthInfo(tokenJWT, entity.getFirstName(), entity.getLastName(), entity.getRole().getAuthority());
			return info;
		}else {
			throw new BadCredentialsException(inputsUsername);
		}
		
	}

	@Override
	public boolean emailExist(String email) {
		return accounts.existsByUsernameIgnoreCase(email);
	}
}
