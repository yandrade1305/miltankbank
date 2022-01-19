package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.service.acao.AcaoExcluiReceita;
import br.com.miltankbank.service.executor.exclui.ExecutorExcluiReceita;

@Service
public class ExcluiReceitaService {
    private final ExecutorExcluiReceita receita;
    private List<AcaoExcluiReceita> acoes = new ArrayList<>();

    public ExcluiReceitaService(ExecutorExcluiReceita receita, List<AcaoExcluiReceita> acoes) {
        this.receita = receita;
        adicionaAcoes();
    }

    public Long excluir(Long idReceita){
        acoes.forEach(acao -> acao.executa(idReceita));
        return idReceita;
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(receita);
    }
    


}
