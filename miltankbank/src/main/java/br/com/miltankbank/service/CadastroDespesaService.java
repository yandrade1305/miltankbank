package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.model.dto.DespesaDTO;
import br.com.miltankbank.service.acao.AcaoCadastroDespesa;
import br.com.miltankbank.service.executor.cadastro.ExecutorCadastroDespesa;
import br.com.miltankbank.service.executor.cadastro.ExecutorValidacaoCadastroDespesa;

@Service
public class CadastroDespesaService {
    private final DetalhaDespesaService detalhaDespesaService;
    private List<AcaoCadastroDespesa> acoes = new ArrayList<>();
    private final ExecutorCadastroDespesa despesa;
    private final ExecutorValidacaoCadastroDespesa validacao;

    public CadastroDespesaService(DetalhaDespesaService detalhaDespesaService, List<AcaoCadastroDespesa> acoes,
            ExecutorCadastroDespesa despesa, ExecutorValidacaoCadastroDespesa validacao) {
        this.despesa = despesa;
        this.validacao = validacao;
        this.detalhaDespesaService = detalhaDespesaService;
        adicionaAcoes();
    }

    public DespesaDTO cadastrar(DespesaForm despesaForm) {
        acoes.forEach(acao -> acao.executa(despesaForm));
        return detalhaDespesaService.obterPor(despesaForm.getIdDespesa());
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(validacao);
        acoes.add(despesa);
    }

}
