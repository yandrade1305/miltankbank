package br.com.miltankbank.exceptions.receita;

public class ListaReceitasVaziaPorMesException extends RuntimeException{
    private final String mensagem;

    public ListaReceitasVaziaPorMesException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
}
