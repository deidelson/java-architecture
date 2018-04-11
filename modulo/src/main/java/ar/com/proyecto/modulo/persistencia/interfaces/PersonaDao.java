package ar.com.proyecto.modulo.persistencia.interfaces;

import ar.com.proyecto.modulo.arquitectura.dao.ArqDao;
import ar.com.proyecto.modulo.model.entity.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaDao extends ArqDao<Persona, Long> {

    public List<Persona> findAll();

    @Query("select p from Persona p where p.nombre like %?1%")
    public List<Persona> findByNombre(String nombre);
}
