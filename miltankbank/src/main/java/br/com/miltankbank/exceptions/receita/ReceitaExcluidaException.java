package br.com.miltankbank.exceptions.receita;

public class ReceitaExcluidaException extends RuntimeException{
    private final String mensagem;

    public ReceitaExcluidaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
}
