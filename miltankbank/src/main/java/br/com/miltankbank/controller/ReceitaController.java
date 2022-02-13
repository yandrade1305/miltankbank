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

import br.com.miltankbank.exceptions.receita.ListaReceitasVaziaException;
import br.com.miltankbank.exceptions.receita.ListaReceitasVaziaPorDescricaoException;
import br.com.miltankbank.exceptions.receita.ListaReceitasVaziaPorMesException;
import br.com.miltankbank.exceptions.receita.ReceitaDuplicadaException;
import br.com.miltankbank.exceptions.receita.ReceitaExcluidaException;
import br.com.miltankbank.exceptions.receita.ReceitaNaoEncontradaException;
import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.service.AlteraReceitaService;
import br.com.miltankbank.service.CadastroReceitaService;
import br.com.miltankbank.service.DetalhaReceitaService;
import br.com.miltankbank.service.ExcluiReceitaService;
import br.com.miltankbank.service.ListarReceitaService;

@RestController
public class ReceitaController {
    
    private final CadastroReceitaService cadastroReceitaService;
    private final AlteraReceitaService alteraReceitaService;
    private final ExcluiReceitaService excluiReceitaService;
    private final DetalhaReceitaService detalhaReceitaService;
    private final ListarReceitaService listarReceitaService;


    public ReceitaController(CadastroReceitaService cadastroReceitaService, AlteraReceitaService alteraReceitaService,
     ExcluiReceitaService excluiReceitaService, DetalhaReceitaService detalhaReceitaService, ListarReceitaService listarReceitaService) {
        this.cadastroReceitaService = cadastroReceitaService;
        this.alteraReceitaService = alteraReceitaService;
        this.excluiReceitaService = excluiReceitaService;
        this.detalhaReceitaService = detalhaReceitaService;
        this.listarReceitaService = listarReceitaService;
    }

    @PostMapping(path = "/receita")
    public ResponseEntity<?> cadastrarReceita(@RequestBody ReceitaForm receitaForm){
        try {
            return ResponseEntity.created(URI.create("")).body(cadastroReceitaService.cadastrar(receitaForm));   
        } catch (ReceitaDuplicadaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
    }

    @PutMapping(path = "/receita/{idReceita}")
    public ResponseEntity<?> alterarReceita(@RequestBody ReceitaForm receitaForm, @PathVariable Long idReceita){
        try {
            return ResponseEntity.ok(alteraReceitaService.altera(receitaForm));    
        } catch (ReceitaDuplicadaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
        
    }

    @DeleteMapping(path = "/receita/{idReceita}")
    public ResponseEntity<?> excluiReceita(@PathVariable Long idReceita){
        try {
            return ResponseEntity.ok(excluiReceitaService.excluir(idReceita));
        } catch (ReceitaExcluidaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
       
    }

    @GetMapping(path = "/receita/{idReceita}")
    public ResponseEntity<?> detalhaReceita(@PathVariable Long idReceita){
        try {
            return ResponseEntity.ok(detalhaReceitaService.obterPor(idReceita));
        } catch (ReceitaNaoEncontradaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
    }

    @GetMapping(path = "/receitas")
    public ResponseEntity<?> listarReceitas(){
        try {
            return ResponseEntity.ok(listarReceitaService.listarReceitas());
        } catch (ListaReceitasVaziaException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
        
    }

    @GetMapping(value = "/receitas", params = "descricaoReceita")
    public ResponseEntity<?> listarReceitasPesquisadas(@RequestParam(name = "descricaoReceita", required = false) String descricaoReceita){
        try {
            return ResponseEntity.ok(listarReceitaService.listarReceitasPesquisadas(descricaoReceita));
        } catch (ListaReceitasVaziaPorDescricaoException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
        
    }

    @GetMapping(path = "/receitas/{ano}/{mes}")
    public ResponseEntity<?> listarDespesasPorMes(@PathVariable Integer ano, @PathVariable Integer mes) {
        try {
            return ResponseEntity.ok(listarReceitaService.listarReceitasPorMes(ano, mes));
        } catch (ListaReceitasVaziaPorMesException ex) {
            return ResponseEntity.badRequest().body(ex.getMensagem());
        }
        
    }
}
