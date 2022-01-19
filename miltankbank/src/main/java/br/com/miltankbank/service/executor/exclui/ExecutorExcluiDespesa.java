package br.com.miltankbank.service.executor.exclui;

import org.springframework.stereotype.Service;

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
        despesaRepository.deleteById(idDespesa);
    }

}
