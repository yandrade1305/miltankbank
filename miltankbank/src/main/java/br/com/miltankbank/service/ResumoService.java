package br.com.miltankbank.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.miltankbank.model.dto.ResumoDTO;
import br.com.miltankbank.model.entity.Despesa;
import br.com.miltankbank.model.entity.Receita;
import br.com.miltankbank.model.repository.DespesaRepository;
import br.com.miltankbank.model.repository.ReceitaRepository;

@Service
public class ResumoService {
    private final ReceitaRepository receitaRepository;
    private final DespesaRepository despesaRepository;

    public ResumoService(ReceitaRepository receitaRepository, DespesaRepository despesaRepository) {
        this.receitaRepository = receitaRepository;
        this.despesaRepository = despesaRepository;
    }

    public ResumoDTO obterPorMes(Integer ano, Integer mes) {
        List<Receita> listaReceitasPorMesEAno = receitaRepository.findAllByMes(ano, mes);
        List<Despesa> listaDespesaPorMesEAno = despesaRepository.findAllByMes(ano, mes);
        BigDecimal valorTotalDespesa = BigDecimal.ZERO;
        BigDecimal valorTotalReceita = BigDecimal.ZERO;
        BigDecimal saldoFinal = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmAlimentacao = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmSaude = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmMoradia = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmTransporte = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmEducacao = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmLazer = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmImprevistos = BigDecimal.ZERO;
        BigDecimal valorTotalGastoEmOutras = BigDecimal.ZERO;
        for (Despesa despesa : listaDespesaPorMesEAno) {
            valorTotalDespesa = valorTotalDespesa.add(despesa.getValorDespesa());
            if (despesa.getCategoria().getDescricaoCategoria().equals("Alimentação")) {
                valorTotalGastoEmAlimentacao = valorTotalGastoEmAlimentacao.add(despesa.getValorDespesa());
            }
            if (despesa.getCategoria().getDescricaoCategoria().equals("Saúde")) {
                valorTotalGastoEmSaude = valorTotalGastoEmSaude.add(despesa.getValorDespesa());
            }
            if (despesa.getCategoria().getDescricaoCategoria().equals("Moradia")) {
                valorTotalGastoEmMoradia = valorTotalGastoEmMoradia.add(despesa.getValorDespesa());
            }
            if (despesa.getCategoria().getDescricaoCategoria().equals("Transporte")) {
                valorTotalGastoEmTransporte = valorTotalGastoEmTransporte.add(despesa.getValorDespesa());
            }
            if (despesa.getCategoria().getDescricaoCategoria().equals("Educação")) {
                valorTotalGastoEmEducacao = valorTotalGastoEmEducacao.add(despesa.getValorDespesa());
            }
            if (despesa.getCategoria().getDescricaoCategoria().equals("Lazer")) {
                valorTotalGastoEmLazer = valorTotalGastoEmLazer.add(despesa.getValorDespesa());
            }
            if (despesa.getCategoria().getDescricaoCategoria().equals("Imprevistos")) {
                valorTotalGastoEmImprevistos = valorTotalGastoEmImprevistos.add(despesa.getValorDespesa());
            }
            if (despesa.getCategoria().getDescricaoCategoria().equals("Outras")) {
                valorTotalGastoEmOutras = valorTotalGastoEmOutras.add(despesa.getValorDespesa());
            }
        }
        for (Receita receita : listaReceitasPorMesEAno) {
            valorTotalReceita.add(receita.getValorReceita());
        }
        saldoFinal = valorTotalReceita.subtract(valorTotalDespesa);
        return new ResumoDTO(valorTotalReceita, valorTotalDespesa, saldoFinal, valorTotalGastoEmAlimentacao,
                valorTotalGastoEmSaude, valorTotalGastoEmMoradia,
                valorTotalGastoEmTransporte, valorTotalGastoEmEducacao, valorTotalGastoEmLazer,
                valorTotalGastoEmImprevistos, valorTotalGastoEmOutras);
    }
}
