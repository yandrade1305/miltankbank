package br.com.miltankbank.service.executor.abstracts;

import java.time.LocalDate;
import java.util.Optional;

import br.com.miltankbank.exceptions.receita.ReceitaDuplicadaException;
import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.model.entity.Receita;
import br.com.miltankbank.model.repository.ReceitaRepository;
import br.com.miltankbank.service.acao.AcaoCadastroReceita;

public abstract class AbstractExecutorValidacaoCadastroReceita implements AcaoCadastroReceita{
    private final ReceitaRepository receitaRepository;

    public AbstractExecutorValidacaoCadastroReceita(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    public void executa(ReceitaForm form) {
        Optional<Receita> optReceita = receitaRepository.findByDescricaoReceita(form.getDescricaoReceita());
        if (optReceita.isPresent()) {
            if (form.getDataReceita().getMonth().equals(optReceita.get().getDataReceita().getMonth())) {
                throw new ReceitaDuplicadaException("Não pode ter duas receitas com a mesma descrição no mesmo mês");
            }
            LocalDate dataAtual = LocalDate.now();
            LocalDate dataReceita = optReceita.get().getDataReceita();
            if (dataAtual.getMonthValue() == dataReceita.getMonthValue()) {
                throw new ReceitaDuplicadaException("Não pode ter duas receitas com a mesma descrição no mesmo mês");
            }
        }

    }
    
}
