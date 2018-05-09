package ar.com.proyecto.modulo.arquitectura.securitytoken;

import ar.com.proyecto.modulo.arquitectura.securitytoken.interfaces.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Service
public class JwtCustomFilter extends GenericFilterBean {

    @Autowired
    private TokenProvider tokenProvider;

    @Value("${token.header.name}")
    private String tokenHeader;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        String token = httpServletRequest.getHeader(tokenHeader);
        if(tokenProvider.validarToken(token)){
            Authentication authentication = this.tokenProvider.getAutentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }
}
