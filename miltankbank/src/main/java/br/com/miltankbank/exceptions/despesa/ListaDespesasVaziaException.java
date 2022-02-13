package br.com.miltankbank.exceptions.despesa;

public class ListaDespesasVaziaException extends RuntimeException{

    private final String mensagem;

    public ListaDespesasVaziaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
}
