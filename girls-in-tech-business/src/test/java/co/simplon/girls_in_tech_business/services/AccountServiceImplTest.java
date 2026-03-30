package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.config.JwtProvider;
import co.simplon.girls_in_tech_business.dtos.AuthInfo;
import co.simplon.girls_in_tech_business.dtos.Login;
import co.simplon.girls_in_tech_business.entities.Account;
import co.simplon.girls_in_tech_business.entities.Role;
import co.simplon.girls_in_tech_business.repositories.AccountJPARepository;
import co.simplon.girls_in_tech_business.repositories.RoleJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class AccountServiceImplTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountJPARepository accountJPARepository;

    @Mock
    private RoleJPARepository roleJPARepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtProvider jwtProvider;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void signin_shouldCallJwtProviderCreate_whenUsernameExistsAndPasswordIsCorrect(){
        Login inputs = new Login("marie.dubois@com.com", "Bonjour1!");

        Role role =mock(Role.class);
        when(role.getAuthority()).thenReturn("ROLE_ELEVE");

        Account account= new Account();
        account.setUsername("marie.dubois@com.com");
        account.setPassword("encodedPassword");
        account.setFirstName("Marie");
        account.setLastName("Dubois");
        account.setRole(role);


        when(accountJPARepository.findByUsernameIgnoreCase("marie.dubois@com.com")).thenReturn(Optional.of(account));
        when(passwordEncoder.matches("Bonjour1!", "encodedPassword")).thenReturn(true);
        AuthInfo result = accountService.signin(inputs);

        verify(jwtProvider, times(1)).create("marie.dubois@com.com", role);
    }


}
