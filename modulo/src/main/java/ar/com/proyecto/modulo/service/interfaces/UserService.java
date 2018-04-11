package ar.com.proyecto.modulo.service.interfaces;

import ar.com.proyecto.modulo.arquitectura.model.ResponseDTO;
import ar.com.proyecto.modulo.model.dto.UserDTO;
import ar.com.proyecto.modulo.model.entity.User;

import java.util.List;

public interface UserService {

    public void save(UserDTO user);
    public List<UserDTO> findAll();

}
