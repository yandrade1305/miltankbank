package br.com.miltankbank.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.miltankbank.model.entity.Receita;

public class ListarReceitaDTO {
    private String descricaoReceita;
    private BigDecimal valorReceita;
    private LocalDate dataReceita;

    public ListarReceitaDTO(Receita receita) {
        this.descricaoReceita = receita.getDescricaoReceita();
        this.valorReceita = receita.getValorReceita();
        this.dataReceita = receita.getDataReceita();
    }
}
