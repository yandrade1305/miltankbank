package br.com.miltankbank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.exceptions.receita.ListaReceitasVaziaException;
import br.com.miltankbank.exceptions.receita.ListaReceitasVaziaPorDescricaoException;
import br.com.miltankbank.exceptions.receita.ListaReceitasVaziaPorMesException;
import br.com.miltankbank.model.dto.ListarReceitaDTO;
import br.com.miltankbank.model.entity.Receita;
import br.com.miltankbank.model.repository.ReceitaRepository;

@Service
public class ListarReceitaService {
    private final ReceitaRepository receita;

    public ListarReceitaService(ReceitaRepository receita) {
        this.receita = receita;
    }

    public List<ListarReceitaDTO> listarReceitas(){
        List<ListarReceitaDTO> listaReceitaDTOs = new ArrayList<>();
        List<Receita> listaReceitas = receita.findAll();
        listaReceitas.forEach(receita -> listaReceitaDTOs.add(new ListarReceitaDTO(receita)));
        if (listaReceitaDTOs.isEmpty()) {
            throw new ListaReceitasVaziaException("Não existe receitas cadastradas");
        }
        return listaReceitaDTOs;
    }

    public List<ListarReceitaDTO> listarReceitasPesquisadas(String descricaoReceita){
        List<ListarReceitaDTO> listaReceitasPesquisadasDTOs = new ArrayList<>();
        receita.findAllByDescricaoReceita(descricaoReceita).forEach(receita -> listaReceitasPesquisadasDTOs.add(new ListarReceitaDTO(receita)));
        if (listaReceitasPesquisadasDTOs.isEmpty()) {
            throw new ListaReceitasVaziaPorDescricaoException("Não existe receitas para a descrição: " + descricaoReceita);
        }
        return listaReceitasPesquisadasDTOs;
    }

    public List<ListarReceitaDTO> listarReceitasPorMes(Integer ano, Integer mes){
        List<ListarReceitaDTO> listaReceitasPorMes = new ArrayList<>();
        receita.findAllByMes(ano, mes).forEach(receita -> listaReceitasPorMes.add(new ListarReceitaDTO(receita)));
        if (listaReceitasPorMes.isEmpty()) {
            throw new ListaReceitasVaziaPorMesException("Não existe receitas para o mês " + mes + " do ano de " + ano);
        }
        return listaReceitasPorMes;
    }


}
