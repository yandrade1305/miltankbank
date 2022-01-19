package br.com.miltankbank.service.executor.exclui;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.repository.ReceitaRepository;
import br.com.miltankbank.service.acao.AcaoExcluiReceita;

@Service
public class ExecutorExcluiReceita implements AcaoExcluiReceita {

    private final ReceitaRepository receitaRepository;

    public ExecutorExcluiReceita(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    @Override
    public void executa(Long idReceita) {
        receitaRepository.deleteById(idReceita);
    }
}
