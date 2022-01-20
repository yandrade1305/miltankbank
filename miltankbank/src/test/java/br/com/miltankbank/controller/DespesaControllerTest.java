package br.com.miltankbank.controller;

import org.junit.jupiter.api.Test;
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
public class DespesaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static final String cadastro = "{"
        + "\"descricaoDespesa\": \"Hyper Potion\","
        + "\"valorDespesa\": \"1200\","
        + "\"dataDespesa\": \"2022-12-25\""
    + "}";

    @Test
    @Rollback(false)
    public void deveCadastrarDespesa() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/despesas")
            .content(cadastro)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated());

    }
}