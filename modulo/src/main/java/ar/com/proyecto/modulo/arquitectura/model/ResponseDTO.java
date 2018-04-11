package ar.com.proyecto.modulo.arquitectura.model;

public class ResponseDTO extends ArqDTO {

    public String response;

    public ResponseDTO() {
    }

    public ResponseDTO(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
