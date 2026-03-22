package co.simplon.girls_in_tech_business.common;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public final class CurrentUserManagerUtils {
    private CurrentUserManagerUtils(){}

    public static String getAuthenticatedUser() throws BadCredentialsException{
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication !=null && authentication.getPrincipal() instanceof Jwt jwt){
            return jwt.getSubject();
        }else{
            throw new BadCredentialsException("User is not authenticated");
        }
    }

}
