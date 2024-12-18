package co.simplon.girls_in_tech_business.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;


import co.simplon.girls_in_tech_business.dtos.AccountCreate;
import co.simplon.girls_in_tech_business.entities.Account;
import co.simplon.girls_in_tech_business.repositories.AccountJPARepository;

@Service
@Transactional(readOnly= true)
public class AccountService {
	
	private final AccountJPARepository accounts;
	private final PasswordEncoder encoder;

	
	public AccountService(AccountJPARepository accounts, PasswordEncoder encoder) {
		this.accounts = accounts;
		this.encoder = encoder;
	}

	@Transactional
	public void create(AccountCreate inputs) {
		
		Account account = new Account();
		account.setUsername(inputs.username());
		
		String passencode = encoder.encode(inputs.password());
		
		account.setPassword(passencode);
		
		accounts.save(account);
		
	}
	

}
