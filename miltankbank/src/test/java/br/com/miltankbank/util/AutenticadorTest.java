package br.com.miltankbank.util;

import java.net.URI;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.miltankbank.model.dto.TokenDTO;

public class AutenticadorTest {

    public TokenDTO autentica(MockMvc mockMvc) throws Exception {

        URI uri = new URI("/auth");

        String json = "{"
                + "       \"nomeUsuario\": \"ashKetchum\","
                + "       \"senha\": \"Pikachu@123\""
                + " }";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post(uri)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .status()
                        .is(200))
                .andReturn();

        TokenDTO tokenDto = new ObjectMapper().readValue(result.getResponse().getContentAsString(), TokenDTO.class);
        return tokenDto;
    }
}
