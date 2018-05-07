package ar.com.proyecto.modulo.arquitectura.model.mapper;

import ar.com.proyecto.modulo.arquitectura.model.dto.RolDTO;
import ar.com.proyecto.modulo.arquitectura.model.dto.UserDTO;
import ar.com.proyecto.modulo.arquitectura.model.entity.Rol;
import ar.com.proyecto.modulo.arquitectura.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserMapper implements GenericMapper<User, UserDTO> {

    @Autowired RolMapper rolMapper;

    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsuario(dto.getUsuario());
        user.setContrasenia(dto.getContrasenia());
        user.setRoles(dto.getRoles() != null ? convertirARoles(dto.getRoles()) : null);
        user.getRoles();
        return user;
    }

    @Override
    public UserDTO toDTO(User entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(entity.getId() != null ? entity.getId() : null);
        userDTO.setContrasenia(entity.getContrasenia());
        userDTO.setUsuario(entity.getUsuario());
        userDTO.setRoles(! entity.getRoles().isEmpty() ? convertirARolDto(entity.getRoles()) : null);
        return userDTO;
    }

    private List<RolDTO> convertirARolDto(List<Rol>roles){
        List<RolDTO> ret = new ArrayList<>();
        roles.forEach(r -> ret.add(rolMapper.toDTO(r)));
        return ret;
    }

    private List<Rol>convertirARoles(List<RolDTO>roles){
        List<Rol> ret = new ArrayList<>();
        roles.forEach(r -> ret.add(rolMapper.toEntity(r)));
        return ret;
    }
}
