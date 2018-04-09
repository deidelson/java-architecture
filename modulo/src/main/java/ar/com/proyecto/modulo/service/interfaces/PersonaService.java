package ar.com.proyecto.modulo.service.interfaces;

import ar.com.proyecto.modulo.model.entity.Persona;

import java.util.List;

public interface PersonaService {

    public List<Persona> findAll();

    public void save(Persona p);

    public void delete(Persona p);

    public void update(Persona p);

    public Persona findById(Persona p);

    public List<Persona> findByNombre(String nombre);
}
