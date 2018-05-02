package ar.com.proyecto.modulo.arquitectura.service.interf;

import ar.com.proyecto.modulo.arquitectura.model.dto.ResponseDTO;
import ar.com.proyecto.modulo.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    public User save(UserDTO user);
    public List<UserDTO> findAll();

    ResponseDTO<UserDTO> login(UserDTO user);
}
