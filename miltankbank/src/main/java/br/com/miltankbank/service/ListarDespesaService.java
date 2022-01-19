package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.dto.ListarDespesaDTO;
import br.com.miltankbank.model.repository.DespesaRepository;

@Service
public class ListarDespesaService {
    private final DespesaRepository despesa;

    public ListarDespesaService(DespesaRepository despesa) {
        this.despesa = despesa;
    }

    public List<ListarDespesaDTO> listarDespesas(){
        List<ListarDespesaDTO> listaDespesaDTOs = new ArrayList<>();
        despesa.findAll().forEach(despesa -> listaDespesaDTOs.add(new ListarDespesaDTO(despesa)));
        return listaDespesaDTOs;
    }

}
