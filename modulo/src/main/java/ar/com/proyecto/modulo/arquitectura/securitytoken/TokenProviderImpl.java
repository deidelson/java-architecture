package ar.com.proyecto.modulo.arquitectura.securitytoken;

import ar.com.proyecto.modulo.arquitectura.securitytoken.interfaces.TokenProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

import static java.util.Collections.emptyList;

@Service
public class TokenProviderImpl implements TokenProvider {

    @Value("${token.key}")
    private String singKey;

    @Value("${token.header.name}")
    public String tokenHeaderName;

    @Value("${token.prefix}")
    private String tokenPrefix;

    @Value("${token.live.time}")
    private int tokenLiveTime;

    @Override
    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + tokenLiveTime))
                .signWith(SignatureAlgorithm.HS512, singKey)
                .compact();
    }

    @Override
    public boolean validarToken(String token) {
            Jwts.parser()
                    .setSigningKey(singKey)
                    .parseClaimsJws(token.replace(tokenPrefix, ""));
            return true;
    }

    @Override
    public Authentication getAutentication(String token) {
        if (StringUtils.hasText(token)) {
            String user = Jwts.parser()
                    .setSigningKey(singKey)
                    .parseClaimsJws(token.replace(tokenPrefix, "")) //este metodo es el que valida
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

