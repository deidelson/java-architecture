package ar.com.proyecto.modulo.service.interfaces;

import ar.com.proyecto.modulo.model.dto.PersonaDTO;
import ar.com.proyecto.modulo.model.entity.Persona;

import java.util.List;

public interface PersonaService {

    public List<PersonaDTO> findAll();

    public void saveUpdate(PersonaDTO p);

    public void delete(PersonaDTO p);

    public PersonaDTO findById(PersonaDTO p);

    public List<PersonaDTO> findByNombre(String nombre);
}
