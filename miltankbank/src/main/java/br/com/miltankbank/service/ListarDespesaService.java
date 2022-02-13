package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.exceptions.despesa.ListaDespesasVaziaException;
import br.com.miltankbank.exceptions.despesa.ListaDespesasVaziaPorDescricaoException;
import br.com.miltankbank.exceptions.despesa.ListaDespesasVaziaPorMesException;
import br.com.miltankbank.model.dto.ListarDespesaDTO;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.repository.DespesaRepository;

@Service
public class ListarDespesaService {
    private final DespesaRepository despesa;

    public ListarDespesaService(DespesaRepository despesa) {
        this.despesa = despesa;
    }

    public List<ListarDespesaDTO> listarDespesas(){
        List<ListarDespesaDTO> listaDespesaDTOs = new ArrayList<>();
        List<Despesa> listaDespesas = despesa.findAll();
        listaDespesas.forEach(despesa -> listaDespesaDTOs.add(new ListarDespesaDTO(despesa)));
        if (listaDespesaDTOs.isEmpty()) {
            throw new ListaDespesasVaziaException("Não existe despesas cadastradas");
        }
        return listaDespesaDTOs;
    }

    public List<ListarDespesaDTO> listarDespesasPesquisadas(String descricaoDespesa){
        List<ListarDespesaDTO> listaDespesaPesquisadasDTOs = new ArrayList<>();
        despesa.findAllByDescricaoDespesaPesquisada(descricaoDespesa).forEach(despesa -> listaDespesaPesquisadasDTOs.add(new ListarDespesaDTO(despesa)));
        if (listaDespesaPesquisadasDTOs.isEmpty()) {
            throw new ListaDespesasVaziaPorDescricaoException("Não existe despesas para a descrição: " + descricaoDespesa);
        }
        return listaDespesaPesquisadasDTOs;
    }

    public  List<ListarDespesaDTO> listarDespesasPorMes(Integer ano, Integer mes) {
        List<ListarDespesaDTO> listaDespesaPorMes = new ArrayList<>();
        despesa.findAllByMes(ano,mes).forEach(despesa -> listaDespesaPorMes.add(new ListarDespesaDTO(despesa)));
        if (listaDespesaPorMes.isEmpty()) {
            throw new ListaDespesasVaziaPorMesException("Não existe despesas para o mês " + mes + " do ano de " + ano);
        }
        return listaDespesaPorMes;
    }


}
