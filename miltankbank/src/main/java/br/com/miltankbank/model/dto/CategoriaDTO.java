package br.com.miltankbank.model.dto;

import br.com.miltankbank.model.entity.Categoria;

public class CategoriaDTO {
    private Long idCategoria;
    private String descricaoCategoria;

    public CategoriaDTO(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.descricaoCategoria = categoria.getDescricaoCategoria();
    }

    public Long getIdCategoria() {
        return this.idCategoria;
    }

    public String getDescricaoCategoria() {
        return this.descricaoCategoria;
    }
}
