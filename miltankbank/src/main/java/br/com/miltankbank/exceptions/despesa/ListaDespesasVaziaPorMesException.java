package br.com.miltankbank.exceptions.despesa;

public class ListaDespesasVaziaPorMesException extends RuntimeException{
    private final String mensagem;

    public ListaDespesasVaziaPorMesException (String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }

}
