package ar.com.proyecto.architecture.persona.service.interfaces;

import ar.com.proyecto.architecture.persona.model.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {

    public List<PersonaDTO> findAll();

    public PersonaDTO saveUpdate(PersonaDTO p);

    public void delete(PersonaDTO p);

    public PersonaDTO findById(PersonaDTO p);

    public List<PersonaDTO> findByNombre(String nombre);
}
