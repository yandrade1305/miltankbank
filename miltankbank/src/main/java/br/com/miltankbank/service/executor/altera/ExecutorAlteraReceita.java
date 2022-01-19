package br.com.miltankbank.service.executor.altera;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.ReceitaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorCadastroReceita;

@Service
public class ExecutorAlteraReceita extends AbstractExecutorCadastroReceita{
    public ExecutorAlteraReceita(ReceitaRepository receitaRepository) {
        super(receitaRepository);
    }
}
