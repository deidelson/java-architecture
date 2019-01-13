package ar.com.proyecto.architecture.arquitectura.model.dto;


public class RolDTO extends ArqDTO{

    private Long id;
    private String nombreRol;
    private String descripcion;

    public RolDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolDTO rolDTO = (RolDTO) o;

        return getNombreRol() != null ? getNombreRol().equals(rolDTO.getNombreRol()) : rolDTO.getNombreRol() == null;
    }

    @Override
    public int hashCode() {
        return getNombreRol() != null ? getNombreRol().hashCode() : 0;
    }
}
