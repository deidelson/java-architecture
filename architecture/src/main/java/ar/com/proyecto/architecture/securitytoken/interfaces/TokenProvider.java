package ar.com.proyecto.architecture.securitytoken.interfaces;

import org.springframework.security.core.Authentication;

public interface TokenProvider {

    String generateToken(String username);
    boolean validateToken(String token);
    Authentication getAutentication(String token);
}
