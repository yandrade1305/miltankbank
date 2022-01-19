package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.service.acao.AcaoExcluiDespesa;
import br.com.miltankbank.service.executor.exclui.ExecutorExcluiDespesa;

@Service
public class ExcluiDespesaService {
    private final ExecutorExcluiDespesa despesa;
    private List<AcaoExcluiDespesa> acoes = new ArrayList<>();


    public ExcluiDespesaService(ExecutorExcluiDespesa despesa, List<AcaoExcluiDespesa> acoes) {
        this.despesa = despesa;
        adicionaAcoes();
    }

    public Long excluir(Long idDespesa){
        acoes.forEach(acao -> acao.executa(idDespesa));
        return idDespesa;
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(despesa);
    }

}
