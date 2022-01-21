package br.com.miltankbank.service.executor.altera;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.ReceitaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorValidacaoCadastroReceita;

@Service
public class ExecutorValidacaoAlteraReceita extends AbstractExecutorValidacaoCadastroReceita{
    public ExecutorValidacaoAlteraReceita(ReceitaRepository receitaRepository) {
        super(receitaRepository);
    }
    
}
