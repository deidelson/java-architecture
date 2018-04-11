package ar.com.proyecto.modulo.arquitectura.model;

public class ResponseDTO<T> extends ArqDTO {

    private T objeto;
    public String response;

    public ResponseDTO() {
    }

    public ResponseDTO(String response, T objeto) {
        this.response = response;
        this.objeto = objeto;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }
}
