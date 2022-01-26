package br.com.miltankbank.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.miltankbank.model.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

    Optional<Despesa> findByDescricaoDespesa(String descricaoDespesa);
    @Query(value = "select d from miltankbank.Despesa d where descricao_despesa =:descricaoDespesa", nativeQuery = true)
    List<Despesa> findAllByDescricaoDespesaPesquisada(@Param("descricaoDespesa") String descricaoDespesa);
}
