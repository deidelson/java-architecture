package ar.com.proyecto.my.expenses.model.mapper;

import ar.com.proyecto.architecture.model.mapper.GenericMapper;
import ar.com.proyecto.my.expenses.model.dto.PersonaDTO;
import ar.com.proyecto.my.expenses.model.entity.Persona;
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
