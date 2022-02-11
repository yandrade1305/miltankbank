package br.com.miltankbank.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import br.com.miltankbank.model.entity.Usuario;

@SpringBootTest
public class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void deveListarUsuarios(){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        assertNotNull(listaUsuarios);
        assertFalse(listaUsuarios.isEmpty());
        assertEquals(1, listaUsuarios.size());
    }
}
