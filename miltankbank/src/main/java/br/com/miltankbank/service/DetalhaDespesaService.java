package br.com.miltankbank.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.dto.DespesaDTO;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.repository.DespesaRepository;

@Service
public class DetalhaDespesaService {
    private final DespesaRepository despesaRepository;

    public DetalhaDespesaService(DespesaRepository despesaRepository){
        this.despesaRepository = despesaRepository;
    }

    public DespesaDTO obterPor(Long idDespesa){
        Optional<Despesa> optDespesa = despesaRepository.findById(idDespesa);
        if (optDespesa.isPresent()) {
            DespesaDTO despesaDTO = new DespesaDTO(optDespesa.get());
            return despesaDTO;
        }
        return new DespesaDTO();
    }
}
