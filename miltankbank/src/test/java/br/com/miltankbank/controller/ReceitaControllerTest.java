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
public class ReceitaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static final String cadastro = "{"
        + "\"descricaoReceita\": \"Ganhei da campeã Cynthia\","
        + "\"valorReceita\": \"13200\","
        + "\"dataReceita\": \"2022-12-26\""
    + "}";

    private static final String altera = "{"
        + "\"idReceita\": \"1\","
        + "\"descricaoReceita\": \"Ganhei da campeão Steven Stone\","
        + "\"valorReceita\": \"11600\","
        + "\"dataReceita\": \"2021-12-25\""
    + "}";

    private static final String detalha = "{"
        + "\"idReceita\": \"1\","
        + "\"descricaoReceita\": \"Ganhei da campeão Steven Stone\","
        + "\"valorReceita\": \"11600\","
        + "\"dataReceita\": \"2021-12-25\""
    + "}";

    private static final String lista = "["
        + "{"
            + "\"descricaoReceita\": \"Ganhei da campeã Cynthia\","
            + "\"valorReceita\": \"13200\","
            + "\"dataReceita\": \"2022-12-26\""
        + "}"
    + "]";

    private static final String exclui = "1";

    @Test
    @Rollback(false)
    @Order(1)
    public void deveCadastrarReceita() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/receitas")
            .content(cadastro)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated());

    }
    
    @Test
    @Rollback(false)
    @Order(2)
    public void naoDeveCadastrarReceita() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/receitas")
            .content(cadastro)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @Rollback(false)
    @Order(3)
    public void deveAlterarReceita() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .put("/receitas/1")
            .content(altera)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Rollback(false)
    @Order(4)
    public void naoDeveAlterarReceita() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .put("/receitas/1")
            .content(altera)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @Rollback(false)
    @Order(5)
    public void deveDetalharReceitas() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .get("/receitas/1")
            .content(detalha)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void deveListarReceitas() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .get("/receitas/")
            .content(lista)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @Rollback(false)
    @Order(6)
    public void deveExcluirReceitas() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .delete("/receitas/1")
            .content(exclui)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }    
}
