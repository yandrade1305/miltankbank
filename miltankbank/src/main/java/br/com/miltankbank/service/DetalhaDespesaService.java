package br.com.miltankbank.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.miltankbank.exceptions.despesa.DespesaNaoEncontradaException;
import br.com.miltankbank.model.dto.DespesaDTO;
import br.com.miltankbank.model.entity.Categoria;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.repository.CategoriaRepository;
import br.com.miltankbank.model.repository.DespesaRepository;

@Service
public class DetalhaDespesaService {
    private final DespesaRepository despesaRepository;
    private final CategoriaRepository categoriaRepository;


    public DetalhaDespesaService(DespesaRepository despesaRepository, CategoriaRepository categoriaRepository) {
        this.despesaRepository = despesaRepository;
        this.categoriaRepository = categoriaRepository;
    }
    

    public DespesaDTO obterPor(Long idDespesa){
        Optional<Despesa> optDespesa = despesaRepository.findById(idDespesa);
        if (optDespesa.isPresent()) {
            Optional<Categoria> optCategoria = categoriaRepository.findById(optDespesa.get().getIdCategoria());
            DespesaDTO despesaDTO = new DespesaDTO(optDespesa.get(),optCategoria.get());
            return despesaDTO;
        }
        throw new DespesaNaoEncontradaException("Despesa não foi encontrada para o id: " + idDespesa);
    }
}
