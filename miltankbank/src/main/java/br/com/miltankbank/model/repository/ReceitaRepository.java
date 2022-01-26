package br.com.miltankbank.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.miltankbank.model.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    Optional<Receita> findByDescricaoReceita(String descricaoReceita);
    @Query("select r from Receita r where r.descricaoReceita = :descricaoReceita")
    List<Receita> findAllByDescricaoReceita(String descricaoReceita);
}
