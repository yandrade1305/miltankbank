package br.com.miltankbank.exceptions.despesa;

public class DespesaExcluidaException extends RuntimeException{

    private final String mensagem;

    public DespesaExcluidaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
}
