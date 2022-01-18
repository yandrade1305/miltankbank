package br.com.miltankbank.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.model.dto.ReceitaDTO;
import br.com.miltankbank.service.CadastroReceitaService;

@RestController
@RequestMapping(path = "/receita")
public class ReceitaController {
    
    private final CadastroReceitaService cadastroReceitaService;

    public ReceitaController(CadastroReceitaService cadastroReceitaService) {
        this.cadastroReceitaService = cadastroReceitaService;
    }

    @PostMapping
    public ResponseEntity<ReceitaDTO> cadastrarReceita(@RequestBody ReceitaForm receitaForm){
        return ResponseEntity.created(URI.create("")).body(cadastroReceitaService.cadastrar(receitaForm));
    }
}
