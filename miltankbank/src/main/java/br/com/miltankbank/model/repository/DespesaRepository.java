package br.com.miltankbank.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.miltankbank.model.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{
    List<Despesa> findByDescricaoDespesa(String descricaoDespesa);
}
