package br.com.miltankbank.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.miltankbank.model.entity.Despesa;

public class DespesaDTO {
    private Long idDespesa;
    private String descricaoDespesa;
    private BigDecimal valorDespesa;
    private LocalDate dataDespesa;

    public DespesaDTO() {}

    public DespesaDTO(Despesa despesa) {
        this.idDespesa = despesa.getIdDespesa();
        this.descricaoDespesa = despesa.getDescricaoDespesa();
        this.valorDespesa = despesa.getValorDespesa();
        this.dataDespesa = despesa.getDataDespesa();
    }
}
