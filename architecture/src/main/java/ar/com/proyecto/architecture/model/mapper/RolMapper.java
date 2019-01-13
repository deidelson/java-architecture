package ar.com.proyecto.architecture.model.mapper;

import ar.com.proyecto.architecture.model.dto.RolDTO;
import ar.com.proyecto.architecture.model.entity.Rol;
import org.springframework.stereotype.Service;

@Service
public class RolMapper implements GenericMapper<Rol, RolDTO> {

    @Override
    public Rol toEntity(RolDTO dto) {
        Rol rol = new Rol();
        rol.setDescripcion(dto.getDescripcion());
        rol.setId(dto.getId());
        rol.setNombreRol(dto.getNombreRol());
        return rol;
    }

    @Override
    public RolDTO toDTO(Rol entity) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setDescripcion(entity.getDescripcion());
        rolDTO.setId(entity.getId());
        rolDTO.setNombreRol(entity.getNombreRol());
        return rolDTO;
    }
}
