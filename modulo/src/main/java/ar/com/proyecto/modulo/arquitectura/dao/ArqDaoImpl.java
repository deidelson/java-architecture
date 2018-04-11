package ar.com.proyecto.modulo.arquitectura.dao;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public abstract class ArqDaoImpl <T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements ArqDao<T, ID> {

    private EntityManager entityManager;

    public ArqDaoImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
