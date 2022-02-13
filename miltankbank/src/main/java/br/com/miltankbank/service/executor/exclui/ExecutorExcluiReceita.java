package br.com.miltankbank.service.executor.exclui;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.miltankbank.exceptions.receita.ReceitaExcluidaException;
import br.com.miltankbank.model.entity.Receita;
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
        Optional<Receita> optReceita = receitaRepository.findById(idReceita);
        if (optReceita.isPresent()) {
            receitaRepository.deleteById(idReceita);    
        }
        throw new ReceitaExcluidaException("A receita de id: "  + idReceita + " já foi excluída anteriormente");
    }
}
