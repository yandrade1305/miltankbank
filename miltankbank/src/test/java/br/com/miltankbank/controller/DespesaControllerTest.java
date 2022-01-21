package br.com.miltankbank.controller;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class DespesaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String cadastro = "{"
        + "\"descricaoDespesa\": \"Hyper Potion\","
        + "\"valorDespesa\": \"1200\","
        + "\"dataDespesa\": \"2022-12-26\""
    + "}";

    private static final String altera = "{"
        + "\"idDespesa\": \"1\","
        + "\"descricaoDespesa\": \"Rare Candy\","
        + "\"valorDespesa\": \"1200\","
        + "\"dataDespesa\": \"2021-12-25\""
    + "}";

    private static final String detalha = "{"
        + "\"idDespesa\": \"1\","
        + "\"descricaoDespesa\": \"Rare Candy\","
        + "\"valorDespesa\": \"1200\","
        + "\"dataDespesa\": \"2021-12-25\""
    + "}";

    private static final String lista = "["
            + "{"
                + "\"descricaoDespesa\": \"Hyper Potion\","
                + "\"valorDespesa\": \"1200\","
                + "\"dataDespesa\": \"2022-12-26\""
            + "}"
        + "]";

    private static final String exclui = "1";

    @Test
    @Rollback(false)
    @Order(1)
    public void deveCadastrarDespesa() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/despesas")
            .content(cadastro)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    @Rollback(false)
    @Order(2)
    public void naoDeveCadastrarDespesa() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/despesas")
            .content(cadastro)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveAlterarDespesa() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .put("/despesas/1")
            .content(altera)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void naoDeveAlterarDespesa() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .put("/despesas/1")
            .content(altera)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void deveDetalharDespesas() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .get("/despesas/1")
            .content(detalha)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void deveListarDespesas() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .get("/despesas/")
            .content(lista)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void deveExcluirDespesas() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .delete("/despesas/1")
            .content(exclui)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }    
}