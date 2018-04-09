package ar.com.proyecto.modulo.persistencia.impl;

import ar.com.proyecto.modulo.model.entity.Persona;
import ar.com.proyecto.modulo.persistencia.interfaces.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PersonaDaoImpl implements PersonaDao{

    EntityManager entityManager;

    public PersonaDaoImpl(@Autowired EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Persona> findAll() {
        return entityManager.createQuery("SELECT p FROM Persona as p", Persona.class).getResultList();
    }
}
