package br.com.miltankbank.controller;

import org.junit.jupiter.api.BeforeAll;
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

import br.com.miltankbank.model.dto.TokenDTO;
import br.com.miltankbank.util.AutenticadorTest;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class ResumoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private TokenDTO token;

    public static final String valorReceitas = "{"
            + "\"valorTotalReceita\": \"0\","
            + "\"valorTotalDespesa\": \"0\","
            + "\"saldoFinal\": \"0\","
            + "\"valorTotalGastoEmAlimentacao\": \"0\","
            + "\"valorTotalGastoEmSaude\": \"0\","
            + "\"valorTotalGastoEmMoradia\": \"0\","
            + "\"valorTotalGastoEmTransporte\": \"0\","
            + "\"valorTotalGastoEmEducacao\": \"0\","
            + "\"valorTotalGastoEmLazer\": \"0\","
            + "\"valorTotalGastoEmImprevistos\": \"0\","
            + "\"valorTotalGastoEmOutras\": \"0\""
            + "}";

    @BeforeAll
    public void setup() throws Exception{
        token = new AutenticadorTest().autentica(mockMvc);
    }

    @Test
    @Rollback(false)
    @Order(1)
    public void deveObterResumoNoMes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/resumo/2022/05")
                .content(valorReceitas)
                .header("Authorization", "Bearer " + token.getToken())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
