package ar.com.proyecto.modulo.persistencia.impl;

import ar.com.proyecto.modulo.model.entity.Persona;
import ar.com.proyecto.modulo.persistencia.interfaces.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Todo esto es para poder agregar metodos custom a la implementacion que nos brinda Spring,
 * Implementamos la interface que extiende de CrudRepository ( en este caso persona), luego extendemos
 * de alguna implementacion de la misma (yo uso SimpleJpaRepository pero existen otras) y por ultimo inyecto el
 * em para cuando lo necesite, esto es solo necesario para cosas custom que no pudan hacerse con @Query en la interfaz
 */

public class PersonaDaoImpl extends SimpleJpaRepository<Persona, Long> implements PersonaDao{

    private EntityManager entityManager;

    public PersonaDaoImpl(@Autowired EntityManager entityManager) {
        super(Persona.class, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Query("select p from Persona p where p.nombre like %?1%")
    public List<Persona> findByNombre(String nombre) {
        return null;
    }
}
