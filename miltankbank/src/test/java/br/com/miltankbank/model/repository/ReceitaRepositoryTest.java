package br.com.miltankbank.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import br.com.miltankbank.model.entity.Receita;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class ReceitaRepositoryTest {

    @Autowired
    private ReceitaRepository receitaRepository;
    private Receita receita;


    @Test
    @Rollback(false)
    @Order(1)
    public void deveRealizarCadastroReceita(){
        Receita receitaSalva = receitaRepository.save(receita);
        assertNotNull(receitaSalva);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void deveAlterarReceita(){
        receitaRepository.save(receita);
        receita.setDescricaoReceita("Ganhei da campeã Cynthia");
        receita.setValorReceita(BigDecimal.valueOf(13200L));
        receita.setDataReceita(LocalDate.of(2021, 12, 26));
        Receita receitaAlteradaSalva = receitaRepository.save(receita);
        assertNotNull(receitaAlteradaSalva);
        assertEquals("Ganhei da campeã Cynthia", receitaAlteradaSalva.getDescricaoReceita());
        assertEquals(BigDecimal.valueOf(13200L), receitaAlteradaSalva.getValorReceita());
        assertEquals(LocalDate.of(2021, 12, 26), receitaAlteradaSalva.getDataReceita());
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveExcluirReceita(){
        receitaRepository.save(receita);
        receitaRepository.delete(receita);
        Optional<Receita> receitaExcluida = receitaRepository.findById(1L);
        assertFalse(receitaExcluida.isPresent());
    }


    @Test
    @BeforeAll
    public void iniciar(){
        receita = new Receita("Ganhei do campeão Steven Stone", BigDecimal.valueOf(11600L), LocalDate.of(2022, 05, 13));
    }
    
    @Test
    @AfterAll
    @Rollback(false)
    public void finalizar(){
        receitaRepository.deleteAll();
    }
}
