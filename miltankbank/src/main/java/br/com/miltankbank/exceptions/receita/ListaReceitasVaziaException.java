package br.com.miltankbank.exceptions.receita;

public class ListaReceitasVaziaException extends RuntimeException{
    private final String mensagem;

    public ListaReceitasVaziaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
}
