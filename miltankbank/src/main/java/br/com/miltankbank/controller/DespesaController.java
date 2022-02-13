package br.com.miltankbank.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.exceptions.despesa.DespesaDuplicadaException;
import br.com.miltankbank.exceptions.despesa.DespesaExcluidaException;
import br.com.miltankbank.exceptions.despesa.DespesaNaoEncontradaException;
import br.com.miltankbank.exceptions.despesa.ListaDespesasVaziaException;
import br.com.miltankbank.exceptions.despesa.ListaDespesasVaziaPorDescricaoException;
import br.com.miltankbank.exceptions.despesa.ListaDespesasVaziaPorMesException;
import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.service.AlteraDespesaService;
import br.com.miltankbank.service.CadastroDespesaService;
import br.com.miltankbank.service.DetalhaDespesaService;
import br.com.miltankbank.service.ExcluiDespesaService;
import br.com.miltankbank.service.ListarDespesaService;

@RestController
public class DespesaController {

    private final CadastroDespesaService cadastroDespesaService;
    private final AlteraDespesaService alteraDespesaService;
    private final ExcluiDespesaService excluiDespesaService;
    private final DetalhaDespesaService detalhaDespesaService;
    private final ListarDespesaService listarDespesaService;

    public DespesaController(CadastroDespesaService cadastroDespesaService, AlteraDespesaService alteraDespesaService,
            ExcluiDespesaService excluiDespesaService, DetalhaDespesaService detalhaDespesaService,
            ListarDespesaService listarDespesaService) {
        this.cadastroDespesaService = cadastroDespesaService;
        this.alteraDespesaService = alteraDespesaService;
        this.excluiDespesaService = excluiDespesaService;
        this.detalhaDespesaService = detalhaDespesaService;
        this.listarDespesaService = listarDespesaService;
    }

    @PostMapping(path = "/despesa")
    public ResponseEntity<?> cadastrarDespesa(@RequestBody DespesaForm despesaForm) {
        try {
            return ResponseEntity.created(URI.create("")).body(cadastroDespesaService.cadastrar(despesaForm));
        } catch (DespesaDuplicadaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }

    }

    @PutMapping(path = "/despesa/{idDespesa}")
    public ResponseEntity<?> alterarDespesa(@RequestBody DespesaForm despesaForm, @PathVariable Long idDespesa) {
        try {
            return ResponseEntity.ok(alteraDespesaService.altera(despesaForm));
        } catch (DespesaDuplicadaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }

    }

    @DeleteMapping(path = "/despesa/{idDespesa}")
    public ResponseEntity<?> excluiDespesa(@PathVariable Long idDespesa) {
        try {
            return ResponseEntity.ok(excluiDespesaService.excluir(idDespesa));
        } catch (DespesaExcluidaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }

    }

    @GetMapping(path = "/despesa/{idDespesa}")
    public ResponseEntity<?> detalhaDespesa(@PathVariable Long idDespesa) {
        try {
            return ResponseEntity.ok(detalhaDespesaService.obterPor(idDespesa));
        } catch (DespesaNaoEncontradaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
    }

    @GetMapping(value = "/despesas")
    public ResponseEntity<?> listarDespesas() {
        try {
            return ResponseEntity.ok(listarDespesaService.listarDespesas());
        } catch (ListaDespesasVaziaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }

    }

    @GetMapping(value = "/despesas", params = "descricaoDespesa")
    public ResponseEntity<?> listarDespesasPesquisadas(
            @RequestParam(name = "descricaoDespesa", required = false) String descricaoDespesa) {
        try {
            return ResponseEntity.ok(listarDespesaService.listarDespesasPesquisadas(descricaoDespesa));
        } catch (ListaDespesasVaziaPorDescricaoException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
    }

    @GetMapping(path = "/despesas/{ano}/{mes}")
    public ResponseEntity<?> listarDespesasPorMes(@PathVariable Integer ano,
            @PathVariable Integer mes) {
        try {
            return ResponseEntity.ok(listarDespesaService.listarDespesasPorMes(ano, mes));
        } catch (ListaDespesasVaziaPorMesException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }

    }
}
