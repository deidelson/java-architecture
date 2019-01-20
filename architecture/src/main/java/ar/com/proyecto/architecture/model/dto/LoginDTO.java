package ar.com.proyecto.architecture.model.dto;

public class LoginDTO {

    private String token;
    private String usuario;
    private String contrasenia;

    public LoginDTO() {
    }

    public String getToken() {
        return token;
    }

    public LoginDTO setToken(String token) {
        this.token = token;
        return this;
    }

    public String getUsuario() {
        return usuario;
    }

    public LoginDTO setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public LoginDTO setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
        return this;
    }
}
