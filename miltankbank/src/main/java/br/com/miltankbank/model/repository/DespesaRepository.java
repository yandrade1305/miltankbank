package br.com.miltankbank.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.miltankbank.model.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
    Optional<Despesa> findByDescricaoDespesa(String descricaoDespesa);
}
