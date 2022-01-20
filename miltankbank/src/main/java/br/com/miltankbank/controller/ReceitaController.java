package br.com.miltankbank.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.form.ReceitaForm;
import br.com.miltankbank.model.dto.ListarReceitaDTO;
import br.com.miltankbank.model.dto.ReceitaDTO;
import br.com.miltankbank.service.AlteraReceitaService;
import br.com.miltankbank.service.CadastroReceitaService;
import br.com.miltankbank.service.DetalhaReceitaService;
import br.com.miltankbank.service.ExcluiReceitaService;
import br.com.miltankbank.service.ListarReceitaService;

@RestController
@RequestMapping(path = "/receitas")
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

    @PostMapping
    public ResponseEntity<ReceitaDTO> cadastrarReceita(@RequestBody ReceitaForm receitaForm){
        return ResponseEntity.created(URI.create("")).body(cadastroReceitaService.cadastrar(receitaForm));
    }

    @PutMapping(path = "/{idReceita}")
    public ResponseEntity<ReceitaDTO> alterarReceita(@RequestBody ReceitaForm receitaForm, @PathVariable Long idReceita){
        return ResponseEntity.ok(alteraReceitaService.altera(receitaForm));
    }

    @DeleteMapping(path = "/{idReceita}")
    public ResponseEntity<?> excluiReceita(@PathVariable Long idReceita){
        return ResponseEntity.ok(excluiReceitaService.excluir(idReceita));
    }

    @GetMapping(path = "/{idReceita}")
    public ResponseEntity<ReceitaDTO> detalhaReceita(@PathVariable Long idReceita){
        ReceitaDTO receita = detalhaReceitaService.obterPor(idReceita);
        if (receita.getIdReceita() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(receita);
    }

    @GetMapping
    public ResponseEntity<List<ListarReceitaDTO>> listarReceitas(){
        return ResponseEntity.ok(listarReceitaService.listarReceitas());
    }
}
