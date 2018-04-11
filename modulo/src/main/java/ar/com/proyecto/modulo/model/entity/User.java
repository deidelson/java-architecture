package ar.com.proyecto.modulo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "NICK")
    private String usuario;

    @Column(name = "PASS")
    private String contrasenia;

    public User() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getUsuario() != null ? getUsuario().equals(user.getUsuario()) : user.getUsuario() == null;
    }

    @Override
    public int hashCode() {
        return getUsuario() != null ? getUsuario().hashCode() : 0;
    }
}
