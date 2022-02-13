package br.com.miltankbank.service.executor.exclui;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.miltankbank.exceptions.despesa.DespesaExcluidaException;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.service.acao.AcaoExcluiDespesa;

@Service
public class ExecutorExcluiDespesa implements AcaoExcluiDespesa {

    private final DespesaRepository despesaRepository;

    public ExecutorExcluiDespesa(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    @Override
    public void executa(Long idDespesa) {
        Optional<Despesa> optDespesa = despesaRepository.findById(idDespesa);
        if (optDespesa.isPresent()) {
            despesaRepository.deleteById(idDespesa);
        }
        throw new DespesaExcluidaException("A despesa de id: "  + idDespesa + " já foi excluída anteriormente");
    }

}
