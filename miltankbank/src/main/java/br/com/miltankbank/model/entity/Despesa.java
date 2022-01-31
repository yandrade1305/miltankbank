package br.com.miltankbank.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.miltankbank.form.DespesaForm;

@Entity
@Table(name = "DESPESA", schema = "MILTANKBANK")
public class Despesa {
    @Id
    @SequenceGenerator(name = "MILTANKBANK.ID_DESPESA_SEQ", sequenceName = "MILTANKBANK.ID_DESPESA_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "MILTANKBANK.ID_DESPESA_SEQ", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_DESPESA")
    private Long idDespesa;
    @Column(name = "DESCRICAO_DESPESA")
    private String descricaoDespesa;
    @Column(name = "VALOR_DESPESA")
    private BigDecimal valorDespesa;
    @Column(name = "DATA_DESPESA")
    private LocalDate dataDespesa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA", insertable=false, updatable=false)
    private Categoria categoria;
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    public Despesa () {}

    public Despesa (String descricaoDespesa, BigDecimal valorDespesa, LocalDate dataDespesa, Long idCategoria) {
        this.descricaoDespesa = descricaoDespesa;
        this.valorDespesa = valorDespesa;
        this.dataDespesa = dataDespesa;
        this.idCategoria = idCategoria;
    }

    public Despesa (DespesaForm despesa){
        this.idDespesa = despesa.getIdDespesa();
        this.descricaoDespesa = despesa.getDescricaoDespesa();
        this.valorDespesa = despesa.getValorDespesa();
        this.dataDespesa = despesa.getDataDespesa();
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

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
    }

    public void setValorDespesa(BigDecimal valorDespesa) {
        this.valorDespesa = valorDespesa;
    }
    
    public void setDataDespesa(LocalDate dataDespesa) {
        this.dataDespesa = dataDespesa;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
