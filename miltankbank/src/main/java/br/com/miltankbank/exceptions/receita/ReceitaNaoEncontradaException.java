package br.com.miltankbank.exceptions.receita;

public class ReceitaNaoEncontradaException extends RuntimeException{
    private final String mensagem;

    public ReceitaNaoEncontradaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
}
