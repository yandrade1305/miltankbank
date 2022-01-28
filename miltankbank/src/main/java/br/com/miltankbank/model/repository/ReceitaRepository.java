package br.com.miltankbank.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.miltankbank.model.entity.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    Optional<Receita> findByDescricaoReceita(String descricaoReceita);
    
    @Query("select r from Receita r where r.descricaoReceita = :descricaoReceita")
    List<Receita> findAllByDescricaoReceita(String descricaoReceita);
    
    @Query("select r from Receita r where extract (year from r.dataReceita) = :ano and extract (month from r.dataReceita) = :mes")
    List<Receita> findAllByMes(@Param("ano") Integer ano, @Param("mes")  Integer mes);
}
