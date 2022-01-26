package br.com.miltankbank.model.repository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.miltankbank.model.entity.Categoria;

@SpringBootTest
public class CategoriaRepositoryTest {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Test
    public void deveListarCategorias(){
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        assertNotNull(listaCategorias);
        assertFalse(listaCategorias.isEmpty());
        assertEquals(8, listaCategorias.size());
    }
}
