package br.com.miltankbank.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.miltankbank.form.LoginForm;
import br.com.miltankbank.model.dto.TokenDTO;
import br.com.miltankbank.service.TokenServices;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AuthenticationManager authManager;
    private final TokenServices tokenServices;
    
    public AutenticacaoController(AuthenticationManager authManager, TokenServices tokenServices) {
        this.authManager = authManager;
        this.tokenServices = tokenServices;
    }


    @PostMapping
    public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form){
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        try {
            Authentication authentication = authManager.authenticate(dadosLogin);
            String token = tokenServices.gerarToken(authentication);
            return ResponseEntity.ok(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e) {
             return ResponseEntity.badRequest().build();
        }
        
    }
}
