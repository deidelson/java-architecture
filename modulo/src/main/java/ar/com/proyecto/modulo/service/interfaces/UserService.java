package ar.com.proyecto.modulo.service.interfaces;

import ar.com.proyecto.modulo.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    public void save(UserDTO user);
    public List<UserDTO> findAll();

}
