package co.simplon.girls_in_tech_business.dtos;

import java.util.Set;

public record AuthInfo(String token, Set<String> roles) {

}
