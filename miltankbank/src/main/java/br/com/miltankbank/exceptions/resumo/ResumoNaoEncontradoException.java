package br.com.miltankbank.exceptions.resumo;

public class ResumoNaoEncontradoException extends RuntimeException{
    private final String mensagem;

    public ResumoNaoEncontradoException (String mensagem){
        super(mensagem);
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }
    
}
