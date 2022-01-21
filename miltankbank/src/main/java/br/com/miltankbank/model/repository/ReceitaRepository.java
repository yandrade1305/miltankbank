package br.com.miltankbank.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.miltankbank.model.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    Optional<Receita> findByDescricaoReceita(String descricaoReceita);
}
