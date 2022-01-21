package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.model.dto.DespesaDTO;
import br.com.miltankbank.service.acao.AcaoCadastroDespesa;
import br.com.miltankbank.service.executor.altera.ExecutorAlteraDespesa;
import br.com.miltankbank.service.executor.altera.ExecutorValidacaoAlteraDespesa;

@Service
public class AlteraDespesaService {
    private final DetalhaDespesaService detalhaDespesaService;
    private final ExecutorAlteraDespesa despesa;
    private List<AcaoCadastroDespesa> acoes = new ArrayList<>();
    private final ExecutorValidacaoAlteraDespesa validacao;

    public AlteraDespesaService(DetalhaDespesaService detalhaDespesaService, ExecutorAlteraDespesa despesa,
            List<AcaoCadastroDespesa> acoes, ExecutorValidacaoAlteraDespesa validacao) {
        this.despesa = despesa;
        this.validacao = validacao;
        this.detalhaDespesaService = detalhaDespesaService;
        adicionaAcoes();
    }

    public DespesaDTO altera(DespesaForm despesaForm){
        acoes.forEach(acao -> acao.executa(despesaForm));
        return detalhaDespesaService.obterPor(despesaForm.getIdDespesa());
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(despesa);
        acoes.add(validacao);
    }

}
