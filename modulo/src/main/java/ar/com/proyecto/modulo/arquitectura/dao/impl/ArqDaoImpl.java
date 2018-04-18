package ar.com.proyecto.modulo.arquitectura.dao.impl;

import ar.com.proyecto.modulo.arquitectura.dao.interf.ArqDao;
import ar.com.proyecto.modulo.arquitectura.model.entity.ArqEntity;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public abstract class ArqDaoImpl <T extends ArqEntity, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements ArqDao<T, ID> {

    private EntityManager entityManager;

    public ArqDaoImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public <S extends T> S save(S entity){
        if(entity.hasDetachedEntities())
            return getEntityManager().merge(entity);
        else
            getEntityManager().persist(entity);
        return entity;
    }
}
