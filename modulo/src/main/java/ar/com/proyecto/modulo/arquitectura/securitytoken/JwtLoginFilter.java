package ar.com.proyecto.modulo.arquitectura.securitytoken;

import ar.com.proyecto.modulo.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.modulo.arquitectura.securitytoken.interfaces.TokenProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;


public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    TokenProvider tokenProvider;

    @Value("${token.headerName}")
    private String headerName;

    @Value("${token.prefix}")
    private String prefix;

    public JwtLoginFilter(String loginUrl , AuthenticationManager authManager){
        super(new AntPathRequestMatcher(loginUrl));
        setAuthenticationManager(authManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        InputStream body = httpServletRequest.getInputStream();

        // Asumimos que el body tendrá el siguiente JSON  {"username":"ask", "password":"123"}
        // Realizamos un mapeo a nuestra clase User para tener ahi los datos
        UserDTO user = new ObjectMapper().readValue(body, UserDTO.class);


        // Finalmente autenticamos
        // Spring comparará el user/password recibidos
        // contra el que definimos en la clase SecurityConfig (user detatails)
        return getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsuario(),
                        user.getContrasenia(),
                        Collections.emptyList()
                )
        );
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        System.out.println(auth.getName());
        String token = tokenProvider.generarToken(auth.getName());

        res.addHeader(headerName, prefix +" "+token);
    }
}
