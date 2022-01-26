package br.com.miltankbank.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.exceptions.DespesaDuplicadaException;
import br.com.miltankbank.form.DespesaForm;
import br.com.miltankbank.model.dto.DespesaDTO;
import br.com.miltankbank.model.dto.ListarDespesaDTO;
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
        return ResponseEntity.ok(excluiDespesaService.excluir(idDespesa));
    }

    @GetMapping(path = "/despesa/{idDespesa}")
    public ResponseEntity<DespesaDTO> detalhaDespesa(@PathVariable Long idDespesa) {
        DespesaDTO despesa = detalhaDespesaService.obterPor(idDespesa);
        if (despesa.getIdDespesa() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(despesa);
    }

    @GetMapping(path = "/despesas")
    public ResponseEntity<List<ListarDespesaDTO>> listarDespesas() {
        return ResponseEntity.ok(listarDespesaService.listarDespesas());
    }

    @GetMapping(path = "/despesa")
    public ResponseEntity<List<ListarDespesaDTO>> listarDespesasPesquisadas(@RequestParam(name = "descricaoDespesa", required = false) String descricaoDespesa) {
        return ResponseEntity.ok(listarDespesaService.listarDespesasPesquisadas(descricaoDespesa));
    }
}
