package br.com.miltankbank.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.miltankbank.form.CategoriaForm;

@Entity
@Table(name = "CATEGORIA", schema = "MILTANKBANK")
public class Categoria {
    @Id
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;
    @Column(name = "DESCRICAO_CATEGORIA")
    private String descricaoCategoria;

    public Long getIdCategoria() {
        return this.idCategoria;
    }

    public String getDescricaoCategoria() {
        return this.descricaoCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    public Categoria() {}

    public Categoria(Long idCategoria, String descricaoCategoria) {
        this.idCategoria = idCategoria;
        this.descricaoCategoria = descricaoCategoria;
    }

    public Categoria (CategoriaForm categoria){
        this.idCategoria = categoria.getIdCategoria();
        this.descricaoCategoria= categoria.getDescricaoCategoria();
    }

}
