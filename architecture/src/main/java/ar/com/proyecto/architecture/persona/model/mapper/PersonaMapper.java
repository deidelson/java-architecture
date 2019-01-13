package ar.com.proyecto.architecture.persona.model.mapper;

import ar.com.proyecto.architecture.persona.model.dto.PersonaDTO;
import ar.com.proyecto.architecture.persona.model.entity.Persona;
import ar.com.proyecto.architecture.model.mapper.GenericMapper;
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
