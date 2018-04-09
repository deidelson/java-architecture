package ar.com.proyecto.modulo.persistencia.interfaces;

import ar.com.proyecto.modulo.model.entity.Persona;

import java.util.List;

public interface PersonaDao {

    public List<Persona> findAll();
}
