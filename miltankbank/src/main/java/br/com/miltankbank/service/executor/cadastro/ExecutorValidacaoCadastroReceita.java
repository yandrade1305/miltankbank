package br.com.miltankbank.service.executor.cadastro;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.ReceitaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorValidacaoCadastroReceita;

@Service
public class ExecutorValidacaoCadastroReceita extends AbstractExecutorValidacaoCadastroReceita {
    public ExecutorValidacaoCadastroReceita(ReceitaRepository receitaRepository) {
        super(receitaRepository);
    }

}
