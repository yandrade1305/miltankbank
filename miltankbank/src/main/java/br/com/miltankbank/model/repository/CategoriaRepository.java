package br.com.miltankbank.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.miltankbank.model.entity.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
    
}
