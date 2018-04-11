package ar.com.proyecto.modulo.model.dto;

import ar.com.proyecto.modulo.arquitectura.model.ArqDTO;
import ar.com.proyecto.modulo.model.entity.User;

public class UserDTO extends ArqDTO{

    private String usuario;
    private String contrasenia;

    public UserDTO() {
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
