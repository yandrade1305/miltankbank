package br.com.miltankbank.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AutenticacaoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private static final String loginESenhaValido = "{"
        + "       \"nomeUsuario\": \"ashKetchum\","
        + "       \"senha\": \"Pikachu@123\""
    + " }";

    private static final String loginESenhaInvalido = "{"
        + "       \"nomeUsuario\": \"garyOak\","
        + "       \"senha\": \"Eevee@123\""
    + " }";

    @Test
    public void deveRealizarLoginEGerarToken() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/auth")
            .content(loginESenhaValido)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void naoDeveRealizarLoginEGerarToken() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .post("/auth")
            .content(loginESenhaInvalido)
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


}
