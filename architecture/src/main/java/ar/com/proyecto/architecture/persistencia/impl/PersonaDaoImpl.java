package ar.com.proyecto.architecture.persistencia.impl;

import ar.com.proyecto.architecture.arquitectura.dao.impl.ArqDaoImpl;
import ar.com.proyecto.architecture.model.entity.Persona;
import ar.com.proyecto.architecture.persistencia.interfaces.PersonaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Todo esto es para poder agregar metodos custom a la implementacion que nos brinda Spring,
 * Implementamos la interface que extiende de CrudRepository ( en este caso persona), luego extendemos
 * de alguna implementacion de la misma (yo uso SimpleJpaRepository pero existen otras), tambien inyecto el em,
 * un problema es que si hacemos esto no funcionan los @Query de las interfaces, hay que implementar todos los metodos "no custom"
 */
@Repository
public class PersonaDaoImpl extends ArqDaoImpl<Persona, Long> implements PersonaDao{


    public PersonaDaoImpl(@Autowired EntityManager entityManager) {
        super(Persona.class, entityManager);

    }

    @Override
    public List<Persona> findByNombre(String nombre) {
        return (List<Persona>) getEntityManager()
                .createQuery("select p from Persona p where p.nombre LIKE  CONCAT('%',:nombre,'%')")
                .setParameter("nombre", nombre)
                .getResultList();
    }


}
