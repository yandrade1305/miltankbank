package br.com.miltankbank.form;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReceitaForm {
    private Long idReceita;
    private String descricaoReceita;
    private BigDecimal valorReceita;
    private LocalDate dataReceita;

    public Long getIdReceita() {
        return this.idReceita;
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

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

}
