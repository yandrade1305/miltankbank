package br.com.miltankbank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.model.dto.ResumoDTO;
import br.com.miltankbank.service.ResumoService;

@RestController
public class ResumoController {

    private final ResumoService resumoService;

    public ResumoController(ResumoService resumoService) {
        this.resumoService = resumoService;
    }
    
    @GetMapping(path = "/resumo/{ano}/{mes}")
    public ResponseEntity<ResumoDTO> detalhaResumo(@PathVariable Integer ano, @PathVariable Integer mes) {
        ResumoDTO resumo = resumoService.obterPorMes(ano, mes);
        return ResponseEntity.ok(resumo);
    }
}
