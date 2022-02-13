package br.com.miltankbank.exceptions.despesa;

public class ListaDespesasVaziaPorDescricaoException extends RuntimeException{
    private final String mensagem;

    public ListaDespesasVaziaPorDescricaoException (String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }

}
