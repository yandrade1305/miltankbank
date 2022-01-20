package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.model.dto.DespesaDTO;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.service.acao.AcaoCadastroDespesa;
import br.com.miltankbank.service.executor.cadastro.ExecutorCadastroDespesa;

@Service
public class CadastroDespesaService {
    private final DetalhaDespesaService detalhaDespesaService;
    private List<AcaoCadastroDespesa> acoes = new ArrayList<>();
    private final ExecutorCadastroDespesa despesa;


    public CadastroDespesaService(DetalhaDespesaService detalhaDespesaService, List<AcaoCadastroDespesa> acoes, ExecutorCadastroDespesa despesa) {
        this.despesa = despesa;
        this.detalhaDespesaService = detalhaDespesaService;
       adicionaAcoes();
    }

    public DespesaDTO cadastrar(DespesaForm despesaForm){
        List<Despesa> listaDespesas = detalhaDespesaService.obterPorDescricao(despesaForm.getDescricaoDespesa());
        if (listaDespesas.isEmpty() == false) {
            throw new RuntimeException("Já existe uma receita cadastrada com descrição informada");
        }
        acoes.forEach(acao -> acao.executa(despesaForm));
        return detalhaDespesaService.obterPor(despesaForm.getIdDespesa());
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(despesa);
    }

    
}
