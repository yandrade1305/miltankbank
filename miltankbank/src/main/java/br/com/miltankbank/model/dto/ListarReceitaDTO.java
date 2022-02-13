package br.com.miltankbank.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.miltankbank.model.entity.Receita;

public class ListarReceitaDTO {
    private Long idReceita;
    private String descricaoReceita;
    private BigDecimal valorReceita;
    private LocalDate dataReceita;

    public ListarReceitaDTO(Receita receita) {
        this.idReceita = receita.getIdReceita();
        this.descricaoReceita = receita.getDescricaoReceita();
        this.valorReceita = receita.getValorReceita();
        this.dataReceita = receita.getDataReceita();
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public String getDescricaoReceita() {
        return this.descricaoReceita;
    }

    public BigDecimal getValorReceita() {
        return this.valorReceita;
    }

    public LocalDate getDataReceita() {
        return this.dataReceita;
    }

}
