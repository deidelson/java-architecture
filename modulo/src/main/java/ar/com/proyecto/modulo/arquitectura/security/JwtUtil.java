package ar.com.proyecto.modulo.arquitectura.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


import static java.util.Collections.*;

public class JwtUtil {

    private static final String SING_KEY = "eqwedasqwdasWEDSa";
    public static final String TOKEN_HEADER = "Authorization";
    //solo para poner algun prefix custom
    private static final String TOKEN_PREFIX = "";

    // Método para crear el JWT y enviarlo al cliente en el header de la respuesta
    static void addAuthentication(HttpServletResponse res, String username) {

        String token = Jwts.builder()
                //aca se pone lo que se va a encriptar en el token
                .setSubject(username+" "+"valor hardcodeado")

                //aca se pone el tiempo de vida del token, en este caso una hora
                .setExpiration(new Date(System.currentTimeMillis() + 600000))

                // Encriptamos el token con la key custom y eligiendo un algoritmo
                .signWith(SignatureAlgorithm.HS512, SING_KEY)
                .compact();

        //agregamos al encabezado el token
        res.addHeader(TOKEN_HEADER, TOKEN_PREFIX+" "+token);
    }

    // Método para validar el token enviado por el cliente
    static Authentication getAuthentication(HttpServletRequest request) {

        // Obtenemos el token que viene en el encabezado de la peticion
        String token = request.getHeader(TOKEN_HEADER);

        // si hay un token presente, entonces lo validamos
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(SING_KEY)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")) //este metodo es el que valida
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
