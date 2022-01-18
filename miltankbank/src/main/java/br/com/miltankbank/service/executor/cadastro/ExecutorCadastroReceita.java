package br.com.miltankbank.service.executor.cadastro;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.ReceitaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorCadastroReceita;

@Service
public class ExecutorCadastroReceita extends AbstractExecutorCadastroReceita{
    public ExecutorCadastroReceita(ReceitaRepository receitaRepository) {
        super(receitaRepository);
    }
    
}
