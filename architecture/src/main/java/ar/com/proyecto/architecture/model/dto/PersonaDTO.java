package ar.com.proyecto.architecture.model.dto;

import ar.com.proyecto.architecture.arquitectura.model.dto.ArqDTO;


public class PersonaDTO extends ArqDTO {
    private Long id;
    private String nombre;

    public PersonaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonaDTO that = (PersonaDTO) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        return getNombre() != null ? getNombre().equals(that.getNombre()) : that.getNombre() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        return result;
    }
}
