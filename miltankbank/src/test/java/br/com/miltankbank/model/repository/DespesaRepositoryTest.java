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

import br.com.miltankbank.model.entity.Categoria;
import br.com.miltankbank.model.entity.Despesa;


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class DespesaRepositoryTest {

    @Autowired
    private DespesaRepository despesaRepository;
    private Despesa despesa;


    @Test
    @Rollback(false)
    @Order(1)
    public void deveRealizarCadastroDespesa(){
        Despesa despesaSalva = despesaRepository.save(despesa);
        assertNotNull(despesaSalva);
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void deveAlterarDespesa(){
        despesaRepository.save(despesa);
        despesa.setDescricaoDespesa("Hyper Potion");
        despesa.setValorDespesa(BigDecimal.valueOf(1200L));
        despesa.setDataDespesa(LocalDate.of(2021, 12, 25));
        despesa.setCategoria(new Categoria());
        despesa.getCategoria().setIdCategoria(2L);
        Despesa despesaAlteradaSalva = despesaRepository.save(despesa);
        assertNotNull(despesaAlteradaSalva);
        assertEquals("Hyper Potion", despesaAlteradaSalva.getDescricaoDespesa());
        assertEquals(BigDecimal.valueOf(1200L), despesaAlteradaSalva.getValorDespesa());
        assertEquals(LocalDate.of(2021, 12, 25), despesaAlteradaSalva.getDataDespesa());
        assertEquals(2L, despesaAlteradaSalva.getCategoria().getIdCategoria());
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveExcluirDespesa(){
        despesaRepository.save(despesa);
        despesaRepository.delete(despesa);
        Optional<Despesa> despesaExcluida = despesaRepository.findById(1L);
        assertFalse(despesaExcluida.isPresent());
    }


    @Test
    @BeforeAll
    public void iniciar(){
        despesa = new Despesa("Rare Candy", BigDecimal.valueOf(2400L), LocalDate.of(2022, 04, 26), 6L);
    }
    
    @Test
    @AfterAll
    @Rollback(false)
    public void finalizar(){
        despesaRepository.deleteAll();
    }
}
