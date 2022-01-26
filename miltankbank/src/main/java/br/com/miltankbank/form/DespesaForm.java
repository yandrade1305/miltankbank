package br.com.miltankbank.form;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DespesaForm {
    private Long idDespesa;
    private String descricaoDespesa;
    private BigDecimal valorDespesa;
    private LocalDate dataDespesa;
    private CategoriaForm categoria;

    public Long getIdDespesa() {
        return this.idDespesa;
    }

    public String getDescricaoDespesa() {
        return this.descricaoDespesa;
    }

    public BigDecimal getValorDespesa() {
        return this.valorDespesa;
    }

    public LocalDate getDataDespesa() {
        return this.dataDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public CategoriaForm getCategoria() {
        return categoria;
    }
}
