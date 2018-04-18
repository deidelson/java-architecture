package ar.com.proyecto.modulo.arquitectura.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
public class User extends ArqEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NICK")
    private String usuario;

    @Column(name = "PASS")
    private String contrasenia;

    @ManyToMany(targetEntity = Rol.class, cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "ID_USER", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ID_ROLE", referencedColumnName = "ID"))
    private List<Rol> roles;

    public User() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getUsuario() != null ? getUsuario().equals(user.getUsuario()) : user.getUsuario() == null;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        return getUsuario() != null ? getUsuario().hashCode() : 0;
    }

    @Override
    public boolean hasDetachedEntities() {
        Boolean ret = false;
        ret = ret || this.getId() != null;
        return ret || this.getRoles().stream().anyMatch( r -> r.getId() == null);
    }
}
