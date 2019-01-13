package ar.com.proyecto.architecture.model.entity;

import ar.com.proyecto.architecture.arquitectura.model.entity.ArqEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PERSONA")
public class Persona extends ArqEntity{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    public Persona() {
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

        Persona persona = (Persona) o;

        if (getId() != null ? !getId().equals(persona.getId()) : persona.getId() != null) return false;
        return getNombre() != null ? getNombre().equals(persona.getNombre()) : persona.getNombre() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getNombre() != null ? getNombre().hashCode() : 0);
        return result;
    }


}
