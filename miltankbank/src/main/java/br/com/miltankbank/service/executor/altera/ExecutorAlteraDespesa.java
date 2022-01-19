package br.com.miltankbank.service.executor.altera;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorCadastroDespesa;

@Service
public class ExecutorAlteraDespesa extends AbstractExecutorCadastroDespesa {
    public ExecutorAlteraDespesa(DespesaRepository despesaRepository) {
        super(despesaRepository);
    }

}
