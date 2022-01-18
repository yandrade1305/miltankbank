package br.com.miltankbank.service.executor.cadastro;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorCadastroDespesa;

@Service
public class ExecutorCadastroDespesa extends AbstractExecutorCadastroDespesa {
    public ExecutorCadastroDespesa(DespesaRepository despesaRepository) {
        super(despesaRepository);
    }
}
