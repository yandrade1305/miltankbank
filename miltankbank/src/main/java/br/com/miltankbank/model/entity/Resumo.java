package br.com.miltankbank.model.entity;

import java.math.BigDecimal;

public class Resumo {
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


    public BigDecimal getValorTotalReceita() {
        return this.valorTotalReceita;
    }


    public BigDecimal getValorTotalDespesa() {
        return this.valorTotalDespesa;
    }

    public BigDecimal getSaldoFinal() {
        return this.saldoFinal;
    }

    public BigDecimal getValorTotalGastoEmAlimentacao() {
        return this.valorTotalGastoEmAlimentacao;
    } 

    public BigDecimal getValorTotalGastoEmSaude() {
        return this.valorTotalGastoEmSaude;
    }

    public BigDecimal getValorTotalGastoEmMoradia() {
        return this.valorTotalGastoEmMoradia;
    }

    public BigDecimal getValorTotalGastoEmTransporte() {
        return this.valorTotalGastoEmTransporte;
    }

    public BigDecimal getValorTotalGastoEmEducacao() {
        return this.valorTotalGastoEmEducacao;
    }

    public BigDecimal getValorTotalGastoEmLazer() {
        return this.valorTotalGastoEmLazer;
    }

    public BigDecimal getValorTotalGastoEmImprevistos() {
        return this.valorTotalGastoEmImprevistos;
    }

    public BigDecimal getValorTotaGastoEmlOutras() {
        return this.valorTotalGastoEmOutras;
    }
}
