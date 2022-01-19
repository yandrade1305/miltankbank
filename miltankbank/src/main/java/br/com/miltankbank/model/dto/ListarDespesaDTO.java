package br.com.miltankbank.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.miltankbank.model.entity.Despesa;

public class ListarDespesaDTO {
    private String descricaoDespesa;
    private BigDecimal valorDespesa;
    private LocalDate dataDespesa;

    public ListarDespesaDTO(Despesa despesa) {
        this.descricaoDespesa = despesa.getDescricaoDespesa();
        this.valorDespesa = despesa.getValorDespesa();
        this.dataDespesa = despesa.getDataDespesa();
    }
}
