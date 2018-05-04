package ar.com.proyecto.modulo.arquitectura.service.interf;

import ar.com.proyecto.modulo.arquitectura.model.dto.ResponseDTO;
import ar.com.proyecto.modulo.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(UserDTO user);

    List<UserDTO> findAll();

    ResponseDTO<UserDTO> login(UserDTO user);

    ResponseDTO<UserDetails> loginSec(UserDTO user);

}
