package br.com.miltankbank.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.miltankbank.model.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    
}
