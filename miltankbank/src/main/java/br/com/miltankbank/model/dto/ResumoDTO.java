package br.com.miltankbank.model.dto;

import java.math.BigDecimal;

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



    public ResumoDTO(BigDecimal valorTotalReceita,
    BigDecimal valorTotalDespesa,
    BigDecimal saldoFinal,
    BigDecimal valorTotalGastoEmAlimentacao,
    BigDecimal valorTotalGastoEmSaude,
    BigDecimal valorTotalGastoEmMoradia,
    BigDecimal valorTotalGastoEmTransporte,
    BigDecimal valorTotalGastoEmEducacao,
    BigDecimal valorTotalGastoEmLazer,
    BigDecimal valorTotalGastoEmImprevistos,
    BigDecimal valorTotalGastoEmOutras) {
        this.valorTotalReceita = valorTotalReceita;
        this.valorTotalDespesa = valorTotalDespesa;
        this.saldoFinal = saldoFinal;
        this.valorTotalGastoEmAlimentacao = valorTotalGastoEmAlimentacao;
        this.valorTotalGastoEmSaude = valorTotalGastoEmSaude;
        this.valorTotalGastoEmMoradia = valorTotalGastoEmMoradia;
        this.valorTotalGastoEmTransporte = valorTotalGastoEmTransporte;
        this.valorTotalGastoEmEducacao = valorTotalGastoEmEducacao;
        this.valorTotalGastoEmLazer = valorTotalGastoEmLazer;
        this.valorTotalGastoEmImprevistos = valorTotalGastoEmImprevistos;
        this.valorTotalGastoEmOutras = valorTotalGastoEmOutras;
    }
    
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

    public BigDecimal getValorTotalGastoEmOutras() {
        return this.valorTotalGastoEmOutras;
    }



}
