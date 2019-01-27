package ar.com.proyecto.architecture.service.interf;

import ar.com.proyecto.architecture.model.dto.LoginDTO;
import ar.com.proyecto.architecture.model.dto.UserDTO;

public interface LoginService {
    public LoginDTO authenticate(LoginDTO usuario);
}
