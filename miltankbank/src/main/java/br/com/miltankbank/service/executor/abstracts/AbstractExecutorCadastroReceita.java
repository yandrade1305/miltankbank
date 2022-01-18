package br.com.miltankbank.service.executor.abstracts;

import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.model.entity.Receita;
import br.com.miltankbank.model.repository.ReceitaRepository;
import br.com.miltankbank.service.AcaoCadastroReceita;

public class AbstractExecutorCadastroReceita implements AcaoCadastroReceita{

    private final ReceitaRepository receitaRepository;

    public AbstractExecutorCadastroReceita(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    public void executa(ReceitaForm receitaForm) {
        Receita receita = new Receita(receitaForm);
        receitaRepository.save(receita);
        receitaForm.setIdReceita(receita.getIdReceita());
    }
}
