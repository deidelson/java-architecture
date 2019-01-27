package ar.com.proyecto.architecture.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE_NAME", updatable = false, insertable = false)
    private String nombreRol;

    @Column(name = "DESCRIPCION", updatable = false, insertable = false)
    private String descripcion;

    public Rol() {
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


}
