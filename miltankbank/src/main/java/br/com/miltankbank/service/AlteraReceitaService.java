package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.model.dto.ReceitaDTO;
import br.com.miltankbank.service.acao.AcaoCadastroReceita;
import br.com.miltankbank.service.executor.altera.ExecutorAlteraReceita;

@Service
public class AlteraReceitaService {
    private final DetalhaReceitaService detalhaReceitaService;
    private final ExecutorAlteraReceita receita;
    private List<AcaoCadastroReceita> acoes = new ArrayList<>();

    public AlteraReceitaService(DetalhaReceitaService detalhaReceitaService, ExecutorAlteraReceita receita,
            List<AcaoCadastroReceita> acoes) {
        this.receita = receita;
        this.detalhaReceitaService = detalhaReceitaService;
        adicionaAcoes();
    }

    public ReceitaDTO altera(ReceitaForm receitaForm) {
        return detalhaReceitaService.obterPor(receitaForm.getIdReceita());
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(receita);
    }

}
