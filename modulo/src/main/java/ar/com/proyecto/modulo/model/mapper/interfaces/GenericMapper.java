package ar.com.proyecto.modulo.model.mapper.interfaces;

import java.io.Serializable;

public interface GenericMapper<T,E extends Serializable> {

    public T toEntity(E dto);
    public E toDTO(T entity);
}
