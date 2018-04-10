package ar.com.proyecto.modulo.model.mapper;

import ar.com.proyecto.modulo.model.dto.PersonaDTO;
import ar.com.proyecto.modulo.model.entity.Persona;
import ar.com.proyecto.modulo.model.mapper.interfaces.GenericMapper;
import org.springframework.stereotype.Service;

@Service
public class PersonaMapper implements GenericMapper<Persona, PersonaDTO> {


    @Override
    public Persona toEntity(PersonaDTO dto) {
       Persona p = new Persona();
       p.setId(dto.getId());
       p.setNombre(dto.getNombre());
       return p;
    }

    @Override
    public PersonaDTO toDTO(Persona entity) {
        PersonaDTO p = new PersonaDTO();
        p.setId(entity.getId());
        p.setNombre(entity.getNombre());
        return p;
    }
}
