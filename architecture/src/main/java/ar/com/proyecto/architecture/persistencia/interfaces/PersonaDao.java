package ar.com.proyecto.architecture.persistencia.interfaces;

import ar.com.proyecto.architecture.arquitectura.dao.interf.ArqDao;
import ar.com.proyecto.architecture.model.entity.Persona;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PersonaDao extends ArqDao<Persona, Long> {

    public List<Persona> findAll();

    @Query("select p from Persona p where p.nombre like %?1%")
    public List<Persona> findByNombre(String nombre);


}