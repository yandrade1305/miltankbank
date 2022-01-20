package br.com.miltankbank.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.miltankbank.model.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    List<Receita> findByDescricaoReceita(String descricaoReceita);
}
