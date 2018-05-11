package ar.com.proyecto.modulo.arquitectura.securitytoken;

import ar.com.proyecto.modulo.arquitectura.securitytoken.interfaces.TokenProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;

import java.util.Date;

import static java.util.Collections.emptyList;

public class TokenProviderImpl implements TokenProvider {

    @Value("${token.key}")
    private String key;

    @Value("${token.headerName}")
    private String headerName;

    @Value("${token.prefix}")
    private String prefix;

    @Value("${token.liveTime}")
    private int liveTime;

    @Override
    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + liveTime))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    @Override
    public boolean validarToken(String token) {
            Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token.replace(prefix, ""));
            return true;
    }

    @Override
    public Authentication getAutentication(String token) {
        if (StringUtils.hasText(token)) {
            String user = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token.replace(prefix, "")) //este metodo es el que valida
                    .getBody()
                    .getSubject();

            // Recordamos que para las demás peticiones que no sean /login
            // no requerimos una autenticacion por username/password
            // por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin password

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
        }
        return null;
    }

}

