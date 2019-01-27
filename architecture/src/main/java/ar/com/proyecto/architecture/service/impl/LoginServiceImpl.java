package ar.com.proyecto.architecture.service.impl;

import ar.com.proyecto.architecture.model.dto.LoginDTO;
import ar.com.proyecto.architecture.model.dto.UserDTO;
import ar.com.proyecto.architecture.securitytoken.interfaces.TokenProvider;
import ar.com.proyecto.architecture.service.interf.LoginService;
import ar.com.proyecto.architecture.service.interf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService {

    private TokenProvider tokenProvider;
    private UserService userService;

    @Value("${token.headerName}")
    private String headerName;

    @Value("${token.prefix}")
    private String prefix;

    public LoginServiceImpl(@Autowired TokenProvider tokenProvider, @Autowired UserService userService) {
        this.tokenProvider = tokenProvider;
        this.userService = userService;
    }

    public LoginDTO authenticate(LoginDTO usuario) {
        UserDetails user = this.userService.loadUserByUsername(usuario.getUsuario());
        if (user == null)
            throw new IllegalArgumentException("Invalid user");
        else if (!usuario.getContrasenia().equals(user.getPassword()))
            throw new IllegalArgumentException("Invalid password");
        LoginDTO ret = new LoginDTO();
        String token = this.tokenProvider.generateToken(user.getUsername());
        ret.setToken(token);
        ret.setUsuario(user.getUsername());
        return ret;

    }

}
