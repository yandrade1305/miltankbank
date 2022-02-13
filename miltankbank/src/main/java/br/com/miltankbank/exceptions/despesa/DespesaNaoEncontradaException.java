package br.com.miltankbank.exceptions.despesa;

public class DespesaNaoEncontradaException extends RuntimeException{

    private final String mensagem;

    public DespesaNaoEncontradaException(String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }

}
