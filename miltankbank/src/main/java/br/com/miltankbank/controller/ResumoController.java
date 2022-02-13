package br.com.miltankbank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.exceptions.resumo.ResumoNaoEncontradoException;
import br.com.miltankbank.service.ResumoService;

@RestController
public class ResumoController {

    private final ResumoService resumoService;

    public ResumoController(ResumoService resumoService) {
        this.resumoService = resumoService;
    }
    
    @GetMapping(path = "/resumo/{ano}/{mes}")
    public ResponseEntity<?> detalhaResumo(@PathVariable Integer ano, @PathVariable Integer mes) {
        try {
            return ResponseEntity.ok(resumoService.obterPorMes(ano, mes));
        } catch (ResumoNaoEncontradoException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
        
    }
}
