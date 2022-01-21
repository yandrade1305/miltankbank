package br.com.miltankbank.exceptions;

public class ReceitaDuplicadaException extends RuntimeException{
    private final String mensagem;

    public ReceitaDuplicadaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
