package br.com.miltankbank.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.miltankbank.form.ReceitaForm;

@Entity
@Table(name = "RECEITA", schema = "MILTANKBANK")
public class Receita {
    @Id
    @SequenceGenerator(name = "MILTANKBANK.ID_RECEITA_SEQ", sequenceName = "MILTANKBANK.ID_RECEITA_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "MILTANKBANK.ID_RECEITA_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_RECEITA")
    private Long idReceita;
    @Column(name = "DESCRICAO_RECEITA")
    private String descricaoReceita;
    @Column(name = "VALOR_RECEITA")
    private BigDecimal valorReceita;
    @Column(name = "DATA_RECEITA")
    private LocalDate dataReceita;

    public Receita () {}

    public Receita (String descricaoReceita, BigDecimal valorReceita, LocalDate dataReceita) {
        this.descricaoReceita = descricaoReceita;
        this.valorReceita = valorReceita;
        this.dataReceita = dataReceita;
    }

    public Receita (ReceitaForm receitaForm){
        this.descricaoReceita = receitaForm.getDescricaoReceita();
        this.valorReceita = receitaForm.getValorReceita();
        this.dataReceita = receitaForm.getDataReceita();
    }

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

    public void setDescricaoReceita(String descricaoReceita) {
        this.descricaoReceita = descricaoReceita;
    }

    public void setValorReceita(BigDecimal valorReceita) {
        this.valorReceita = valorReceita;
    }

    public void setDataReceita(LocalDate dataReceita) {
        this.dataReceita = dataReceita;
    }
}
