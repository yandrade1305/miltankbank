package br.com.miltankbank.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
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

    private static final String cadastroReceita = "{"
        + "\"descricaoReceita\": \"Ganhei da campeã Cynthia\","
        + "\"valorReceita\": \"13200\","
        + "\"dataReceita\": \"2022-12-26\""
    + "}";

    public static final String cadastroDespesa ="{"
    + "\"descricaoDespesa\": \"Max Potion\","
    + "\"valorDespesa\": \"1200\","
    + "\"dataDespesa\": \"2022-12-26\","
    + "\"categoriaDTO\":{"
        + "\"idCategoria\":\"2\","
        + "\"descricaoCategoria\":\"Saúde\""
        +"}"
    +"}";

    private static final String excluiReceita = "{"
        + "\"descricaoReceita\": \"Ganhei da campeã Cynthia\","
        + "\"valorReceita\": \"13200\","
        + "\"dataReceita\": \"2022-12-26\""
    + "}";

    public static final String excluiDespesa ="{"
    + "\"descricaoDespesa\": \"Max Potion\","
    + "\"valorDespesa\": \"1200\","
    + "\"dataDespesa\": \"2022-12-26\","
    + "\"categoriaDTO\":{"
        + "\"idCategoria\":\"2\","
        + "\"descricaoCategoria\":\"Saúde\""
        +"}"
    +"}";

    public static final String resumo = "{"
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
        mockMvc.perform(MockMvcRequestBuilders
        .post("/receita")
        .content(cadastroReceita)
        .header("Authorization", "Bearer " + token.getToken())
        .contentType(MediaType.APPLICATION_JSON));
        mockMvc.perform(MockMvcRequestBuilders
        .post("/despesa")
        .content(cadastroDespesa)
        .header("Authorization", "Bearer " + token.getToken())
        .contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Rollback(false)
    public void deveObterResumoNoMes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/resumo/2022/12")
                .content(resumo)
                .header("Authorization", "Bearer " + token.getToken())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @AfterAll
    public void finalizar() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
            .delete("/receita/1")
            .content(excluiReceita)
            .header("Authorization", "Bearer " + token.getToken())
            .contentType(MediaType.APPLICATION_JSON));
            mockMvc.perform(MockMvcRequestBuilders
            .delete("/despesa/1")
            .content(excluiDespesa)
            .header("Authorization", "Bearer " + token.getToken())
            .contentType(MediaType.APPLICATION_JSON));

    }
}
