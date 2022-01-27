package br.com.miltankbank.service;

import java.util.List;
import java.util.Optional;

import br.com.miltankbank.model.dto.ResumoDTO;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.entity.Receita;
import br.com.miltankbank.model.entity.Resumo;
import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.model.repository.ReceitaRepository;


public class ResumoService {
    // private final ReceitaRepository receitaRepository;
    // private final DespesaRepository despesaRepository;

    // public ResumoService(ReceitaRepository receitaRepository, DespesaRepository despesaRepository) {
    //     this.receitaRepository = receitaRepository;
    //     this.despesaRepository = despesaRepository;
    // }

    // public ResumoDTO obterPorMes(Long ano, Long mes) {
    //     // Optional<Resumo> optResumo = resumoRepository.findByAnoEMes(ano, mes);
    //     Long ano = Receita
    //     List<Receita> listaReceitasPorMesEAno = receitaRepository.findByMesEAno(ano, mes);
    //     List<Despesa> listaDespesaPorMesEAno = despesaRepository.findByMesEAno(ano, mes);

    //     LocalDate dataDespesaEventual = LocalDate.of(ano,mes,1);
    //     LocalDate dataInicio = dataDespesaEventual.withDayOfMonth(1);
    //     LocalDate dataFim = dataDespesaEventual.withDayOfMonth(dataDespesaEventual.lengthOfMonth());

    //     return receitaRepository.findByData(dataInicio, dataFim);
    //     if (!(listaDespesaPorMesEAno.isEmpty() && listaReceitasPorMesEAno.isEmpty())) {
    //        // ResumoDTO resumoDTO = new ResumoDTO(optResumo.get());
    //        // return resumoDTO;
    //     }
    //     return new ResumoDTO();
    // }
}
