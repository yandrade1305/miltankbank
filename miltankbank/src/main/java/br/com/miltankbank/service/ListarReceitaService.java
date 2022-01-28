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

    public List<ListarReceitaDTO> listarReceitasPesquisadas(String descricaoReceita){
        List<ListarReceitaDTO> listaReceitasPesquisadasDTOs = new ArrayList<>();
        receita.findAllByDescricaoReceita(descricaoReceita).forEach(receita -> listaReceitasPesquisadasDTOs.add(new ListarReceitaDTO(receita)));
        return listaReceitasPesquisadasDTOs;
    }

    public List<ListarReceitaDTO> listarReceitasPorMes(Integer ano, Integer mes){
        List<ListarReceitaDTO> listaReceitasPesquisadasDTOs = new ArrayList<>();
        receita.findAllByMes(ano, mes).forEach(receita -> listaReceitasPesquisadasDTOs.add(new ListarReceitaDTO(receita)));
        return listaReceitasPesquisadasDTOs;
    }


}
