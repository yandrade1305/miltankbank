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

    public List<ListarDespesaDTO> listarDespesasPesquisadas(String descricaoDespesa){
        List<ListarDespesaDTO> listaDespesaPesquisadasDTOs = new ArrayList<>();
        despesa.findAllByDescricaoDespesaPesquisada(descricaoDespesa).forEach(despesa -> listaDespesaPesquisadasDTOs.add(new ListarDespesaDTO(despesa)));
        return listaDespesaPesquisadasDTOs;
    }

    public  List<ListarDespesaDTO> listarDespesasPorMes(Integer ano, Integer mes) {
        List<ListarDespesaDTO> listaDespesaPorMes = new ArrayList<>();
        despesa.findAllByMes(ano,mes).forEach(despesa -> listaDespesaPorMes.add(new ListarDespesaDTO(despesa)));
        return listaDespesaPorMes;
    }


}
