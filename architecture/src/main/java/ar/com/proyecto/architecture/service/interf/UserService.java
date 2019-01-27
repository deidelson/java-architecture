package ar.com.proyecto.architecture.service.interf;

import ar.com.proyecto.architecture.model.dto.UserDTO;
import ar.com.proyecto.architecture.model.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User save(UserDTO user);

    List<UserDTO> findAll();


}
