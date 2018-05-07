package ar.com.proyecto.modulo.arquitectura.model.mapper;

import java.io.Serializable;

public interface GenericMapper<T,E extends Serializable> {

    public T toEntity(E dto);
    public E toDTO(T entity);
}
