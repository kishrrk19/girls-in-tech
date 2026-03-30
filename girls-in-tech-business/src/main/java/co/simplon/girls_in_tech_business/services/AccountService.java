package co.simplon.girls_in_tech_business.services;

import co.simplon.girls_in_tech_business.dtos.AccountCreate;
import co.simplon.girls_in_tech_business.dtos.AuthInfo;
import co.simplon.girls_in_tech_business.dtos.Login;

public interface AccountService {

    void create(AccountCreate inputs);

    AuthInfo signin(Login inputs);

    boolean emailExist(String email);
}
