package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.exceptions.ReceitaDuplicadaException;
import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.model.dto.ReceitaDTO;
import br.com.miltankbank.service.acao.AcaoCadastroReceita;
import br.com.miltankbank.service.executor.cadastro.ExecutorCadastroReceita;
import br.com.miltankbank.service.executor.cadastro.ExecutorValidacaoCadastroReceita;

@Service
public class CadastroReceitaService {
    private final DetalhaReceitaService detalhaReceitaService;
    private List<AcaoCadastroReceita> acoes = new ArrayList<>();
    private final ExecutorCadastroReceita receita;
    private final ExecutorValidacaoCadastroReceita validacao;

    public CadastroReceitaService(DetalhaReceitaService detalhaReceitaService, List<AcaoCadastroReceita> acoes,
            ExecutorCadastroReceita receita, ExecutorValidacaoCadastroReceita validacao) {
        this.receita = receita;
        this.validacao = validacao;
        this.detalhaReceitaService = detalhaReceitaService;
        adicionaAcoes();
    }

    public ReceitaDTO cadastrar(ReceitaForm receitaForm) throws ReceitaDuplicadaException {
        acoes.forEach(acao -> acao.executa(receitaForm));
        return detalhaReceitaService.obterPor(receitaForm.getIdReceita());
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(validacao);
        acoes.add(receita);
    }

}
