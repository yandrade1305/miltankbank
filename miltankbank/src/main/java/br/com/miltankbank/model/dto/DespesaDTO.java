package br.com.miltankbank.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.miltankbank.model.entity.Categoria;
import br.com.miltankbank.model.entity.Despesa;

public class DespesaDTO {
    private Long idDespesa;
    private String descricaoDespesa;
    private BigDecimal valorDespesa;
    private LocalDate dataDespesa;
    private CategoriaDTO categoriaDTO;

    public DespesaDTO() {}

    public DespesaDTO(Despesa despesa) {
        this.idDespesa = despesa.getIdDespesa();
        this.descricaoDespesa = despesa.getDescricaoDespesa();
        this.valorDespesa = despesa.getValorDespesa();
        this.dataDespesa = despesa.getDataDespesa();
    }

    public DespesaDTO(Despesa despesa, Categoria categoria) {
        this(despesa);
        this.categoriaDTO = new CategoriaDTO(categoria);
    }

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
}
