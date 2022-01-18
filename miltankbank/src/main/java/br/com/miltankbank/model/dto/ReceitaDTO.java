package br.com.miltankbank.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.miltankbank.model.entity.Receita;

public class ReceitaDTO {
    private Long idReceita;
    private String descricaoReceita;
    private BigDecimal valorReceita;
    private LocalDate dataReceita;

    public ReceitaDTO() {}

    public ReceitaDTO(Receita receita) {
        this.idReceita = receita.getIdReceita();
        this.descricaoReceita = receita.getDescricaoReceita();
        this.valorReceita = receita.getValorReceita();
        this.dataReceita = receita.getDataReceita();
    }
}
