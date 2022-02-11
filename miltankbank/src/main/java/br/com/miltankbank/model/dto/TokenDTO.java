package br.com.miltankbank.model.dto;

public class TokenDTO {

    private String token;
    private String tipo;

    public String getToken() {
        return this.token;
    }

    public String getTipo() {
        return this.tipo;
    }

    public TokenDTO(String token, String tipo) {
        this.token = token;
        this.tipo = tipo;
    }

    public TokenDTO () {}
}
