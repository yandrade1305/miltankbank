package br.com.miltankbank.service.executor.altera;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorValidacaoCadastroDespesa;

@Service
public class ExecutorValidacaoAlteraDespesa extends AbstractExecutorValidacaoCadastroDespesa{
    public ExecutorValidacaoAlteraDespesa(DespesaRepository despesaRepository) {
        super(despesaRepository);
    }
}
