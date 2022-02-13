package br.com.miltankbank.exceptions.despesa;

public class DespesaDuplicadaException extends RuntimeException{
    private final String mensagem;

    public DespesaDuplicadaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
}
