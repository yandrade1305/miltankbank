package br.com.miltankbank.model.dto;

import java.math.BigDecimal;

import br.com.miltankbank.model.entity.Resumo;

public class ResumoDTO {
    private BigDecimal valorTotalReceita;
    private BigDecimal valorTotalDespesa;
    private BigDecimal saldoFinal;
    private BigDecimal valorTotalGastoEmAlimentacao;
    private BigDecimal valorTotalGastoEmSaude;
    private BigDecimal valorTotalGastoEmMoradia;
    private BigDecimal valorTotalGastoEmTransporte;
    private BigDecimal valorTotalGastoEmEducacao;
    private BigDecimal valorTotalGastoEmLazer;
    private BigDecimal valorTotalGastoEmImprevistos;
    private BigDecimal valorTotalGastoEmOutras;



    // public ResumoDTO(Resumo resumo) {
    //     this.valorTotalReceita = resumo.getValorTotalReceita();
    //     this.valorTotalDespesa = resumo.getValorTotalDespesa();
    //     this.saldoFinal = resumo.getSaldoFinal();
    //     this.valorTotalGastoEmAlimentacao
    //     this.valorTotalGastoEmSaude
    //     this.valorTotalGastoEmMoradia
    //     this.valorTotalGastoEmTransporte
    //     this.valorTotalGastoEmEducacao
    //     this.valorTotalGastoEmLazer
    //     this.valorTotalGastoEmImprevistos
    //     this.valorTotalGastoEmOutras
    // }

    public ResumoDTO() {
    }

    public boolean getAno() {
        return false;
    }

    public boolean getMes() {
        return false;
    }

}
