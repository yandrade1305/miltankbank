package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.dto.ListarReceitaDTO;
import br.com.miltankbank.model.repository.ReceitaRepository;

@Service
public class ListarReceitaService {
    private final ReceitaRepository receita;

    public ListarReceitaService(ReceitaRepository receita) {
        this.receita = receita;
    }

    public List<ListarReceitaDTO> listarReceitas(){
        List<ListarReceitaDTO> listaReceitaDTOs = new ArrayList<>();
        receita.findAll().forEach(receita -> listaReceitaDTOs.add(new ListarReceitaDTO(receita)));
        return listaReceitaDTOs;
    }

}
