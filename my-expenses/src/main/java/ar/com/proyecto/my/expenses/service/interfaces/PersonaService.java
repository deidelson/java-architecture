package ar.com.proyecto.my.expenses.service.interfaces;

import ar.com.proyecto.my.expenses.model.dto.PersonaDTO;
import ar.com.proyecto.my.expenses.model.entity.Persona;
import ar.com.proyecto.my.expenses.model.mapper.PersonaMapper;
import ar.com.proyecto.my.expenses.persistence.interfaces.PersonaDao;
import java.util.List;

public interface PersonaService {

    public List<PersonaDTO> findAll();

    public PersonaDTO saveUpdate(PersonaDTO p);

    public void delete(PersonaDTO p);

    public PersonaDTO findById(PersonaDTO p);

    public List<PersonaDTO> findByNombre(String nombre);
}
