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
public class ReceitaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static final String cadastro = "{"
        + "\"descricaoReceita\": \"Ganhei da campeã Cynthia\","
        + "\"valorReceita\": \"13200\","
        + "\"dataReceita\": \"2022-12-26\""
    + "}";

    @Test
    @Rollback(false)
    public void deveCadastrarReceita() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/receitas")
            .content(cadastro)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isCreated());

    }
}
