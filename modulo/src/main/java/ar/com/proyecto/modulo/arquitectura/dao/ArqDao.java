package ar.com.proyecto.modulo.arquitectura.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 *Esta annotation es para que no se rompa por intentar implementar algo no concreto, esta clase es solo para extender de ella
 */
@NoRepositoryBean
public interface ArqDao<T, ID extends Serializable> extends JpaRepository<T,ID> {
}
