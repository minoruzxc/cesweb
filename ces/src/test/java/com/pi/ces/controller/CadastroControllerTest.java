
package com.pi.ces.controller;

import com.pi.ces.model.Usuario;
import com.pi.ces.service.UsuarioService;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
public class CadastroControllerTest {
    
    @Autowired
    UsuarioService userSvc;
    
    public CadastroControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of cadastroUsuario method, of class CadastroController.
     */
    @Test
    public void adminTest() {
         String admin = "admin";
        List<Usuario> listaUsers = userSvc.buscarTodos();
        boolean result = false;
        
        for (Usuario u : listaUsers) {
            if (u.getNome().equals(admin)) {
                result = true;
            }
        }
        assertTrue(result);
    }
    
    @Test
    public void testCadastroUsuario() {
        System.out.println("cadastroUsuario");
        Usuario usuario = null;
        Model model = null;
        CadastroController instance = new CadastroController();
        String expResult = "";
        String result = instance.cadastroUsuario(usuario, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarUsuario method, of class CadastroController.
     */
    @Test
    public void testCriarUsuario() {
        System.out.println("criarUsuario");
        Usuario usuario = null;
        Model model = null;
        CadastroController instance = new CadastroController();
        String expResult = "";
        String result = instance.criarUsuario(usuario, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluirUsuario method, of class CadastroController.
     */
    @Test
    public void testExcluirUsuario() {
        System.out.println("excluirUsuario");
        String id = "";
        Model model = null;
        CadastroController instance = new CadastroController();
        String expResult = "";
        String result = instance.excluirUsuario(id, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
