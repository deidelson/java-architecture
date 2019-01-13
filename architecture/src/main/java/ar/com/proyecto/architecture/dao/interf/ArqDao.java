package ar.com.proyecto.architecture.dao.interf;

import ar.com.proyecto.architecture.model.entity.ArqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 *Esta annotation es para que no se rompa por intentar implementar algo no concreto, esta clase es solo para extender de ella
 */
@NoRepositoryBean
public interface ArqDao<T extends ArqEntity, ID extends Serializable> extends JpaRepository<T,ID> {
}
