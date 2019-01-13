package ar.com.proyecto.architecture.arquitectura.securitytoken.interfaces;

import org.springframework.security.core.Authentication;

public interface TokenProvider {

    String generarToken(String username);
    boolean validarToken(String token);
    Authentication getAutentication(String token);
}
