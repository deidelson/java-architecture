package ar.com.proyecto.architecture.arquitectura.model.dto;

import ar.com.proyecto.architecture.arquitectura.model.entity.Rol;
import ar.com.proyecto.architecture.arquitectura.model.entity.User;

import java.util.List;

public class UserDTO extends ArqDTO{

    private Long id;
    private String usuario;
    private String contrasenia;
    private List<RolDTO> roles;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<RolDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<RolDTO> roles) {
        this.roles = roles;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDTO{");
        sb.append("id=").append(id);
        sb.append(", usuario='").append(usuario).append('\'');
        sb.append(", contrasenia='").append(contrasenia).append('\'');
        sb.append(", roles=").append(roles);
        sb.append('}');
        return sb.toString();
    }
}
