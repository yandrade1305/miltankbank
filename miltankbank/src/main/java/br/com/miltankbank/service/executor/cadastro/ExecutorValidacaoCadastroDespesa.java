package br.com.miltankbank.service.executor.cadastro;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.service.executor.abstracts.AbstractExecutorValidacaoCadastroDespesa;

@Service
public class ExecutorValidacaoCadastroDespesa extends AbstractExecutorValidacaoCadastroDespesa{
    public ExecutorValidacaoCadastroDespesa(DespesaRepository despesaRepository) {
        super(despesaRepository);
    }

    
}
