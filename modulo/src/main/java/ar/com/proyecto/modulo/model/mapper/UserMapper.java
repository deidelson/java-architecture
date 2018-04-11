package ar.com.proyecto.modulo.model.mapper;

import ar.com.proyecto.modulo.arquitectura.model.GenericMapper;
import ar.com.proyecto.modulo.model.dto.UserDTO;
import ar.com.proyecto.modulo.model.entity.User;
import org.springframework.stereotype.Service;


@Service
public class UserMapper implements GenericMapper<User, UserDTO> {
    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsuario(dto.getUsuario());
        user.setContrasenia(dto.getContrasenia());
        return user;
    }

    @Override
    public UserDTO toDTO(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setContrasenia(entity.getContrasenia());
        userDTO.setUsuario(entity.getUsuario());
        return userDTO;
    }
}
