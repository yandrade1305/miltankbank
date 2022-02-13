package br.com.miltankbank.exceptions.receita;

public class ListaReceitasVaziaPorDescricaoException extends RuntimeException{
    private final String mensagem;

    public ListaReceitasVaziaPorDescricaoException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
}
