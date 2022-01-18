package br.com.miltankbank.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.model.dto.DespesaDTO;
import br.com.miltankbank.service.CadastroDespesaService;

@RestController
@RequestMapping(path = "/despesa")
public class DespesaController {
    private final CadastroDespesaService cadastroDespesaService;

    public DespesaController(CadastroDespesaService cadastroDespesaService) {
        this.cadastroDespesaService = cadastroDespesaService;
    }

    @PostMapping
    public ResponseEntity<DespesaDTO> cadastrarDespesa(@RequestBody DespesaForm despesaForm){
        return ResponseEntity.created(URI.create("")).body(cadastroDespesaService.cadastrar(despesaForm));
    }
}
