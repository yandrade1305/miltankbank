package br.com.miltankbank.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.miltankbank.model.entity.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

    Optional<Despesa> findByDescricaoDespesa(String descricaoDespesa);
    
    @Query("select d from Despesa d where d.descricaoDespesa = :descricaoDespesa")
    List<Despesa> findAllByDescricaoDespesaPesquisada(@Param("descricaoDespesa") String descricaoDespesa);
    
    @Query("select d from Despesa d where extract (year from d.dataDespesa) = :ano and extract (month from d.dataDespesa) = :mes")
    List<Despesa> findAllByMes(@Param("ano") Integer ano, @Param("mes")  Integer mes);
}
