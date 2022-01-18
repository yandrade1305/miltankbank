package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.model.dto.ReceitaDTO;
import br.com.miltankbank.service.executor.cadastro.ExecutorCadastroReceita;

@Service
public class CadastroReceitaService {
    private final DetalhaReceitaService detalhaReceitaService;
    private List<AcaoCadastroReceita> acoes = new ArrayList<>();
    private final ExecutorCadastroReceita receita;

    public CadastroReceitaService(DetalhaReceitaService detalhaReceitaService, List<AcaoCadastroReceita> acoes, ExecutorCadastroReceita receita) {
        this.receita = receita;
        this.detalhaReceitaService = detalhaReceitaService;
        adicionaAcoes();
    }

    public ReceitaDTO cadastrar(ReceitaForm receitaForm){
        acoes.forEach(acao -> acao.executa(receitaForm));
        return detalhaReceitaService.obterPor(receitaForm.getIdReceita());
    }

    private void adicionaAcoes() {
        acoes.clear();
        acoes.add(receita);
    }

}
