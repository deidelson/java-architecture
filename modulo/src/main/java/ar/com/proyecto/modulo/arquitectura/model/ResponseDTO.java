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

    public static class ResponseDTOBuilder<T>{
        private T objeto;
        public String response;

        private ResponseDTOBuilder<T> setObjeto(T objeto){
            this.objeto=objeto;
            return this;
        }

        private ResponseDTOBuilder<T> setResponse(String respuesta){
            this.response = respuesta;
            return this;
        }

        private ResponseDTO<T> build(){
            ResponseDTO<T> responseDTO = new ResponseDTO<>();
            responseDTO.setObjeto(this.objeto);
            responseDTO.setResponse(this.response);
            return responseDTO;
        }
    }
}
