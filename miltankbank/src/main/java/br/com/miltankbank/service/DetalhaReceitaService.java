package br.com.miltankbank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.dto.ReceitaDTO;
import br.com.miltankbank.model.entity.Receita;
import br.com.miltankbank.model.repository.ReceitaRepository;

@Service
public class DetalhaReceitaService {
    private final ReceitaRepository receitaRepository;

    public DetalhaReceitaService(ReceitaRepository receitaRepository) {
        this.receitaRepository = receitaRepository;
    }

    public ReceitaDTO obterPor(Long idReceita){
        Optional<Receita> optReceita = receitaRepository.findById(idReceita);
        if (optReceita.isPresent()) {
            ReceitaDTO receitaDTO = new ReceitaDTO(optReceita.get());
            return receitaDTO;
        }
        return new ReceitaDTO();
    }

    public List<Receita> obterPorDescricao(String descricaoReceita) {
        return receitaRepository.findByDescricaoReceita(descricaoReceita);
    }
}
