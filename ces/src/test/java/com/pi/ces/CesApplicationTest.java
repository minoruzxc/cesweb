package com.pi.ces;

import com.pi.ces.model.Usuario;
import com.pi.ces.service.ProdutoService;
import com.pi.ces.service.UsuarioService;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CesApplicationTest {

    @Autowired
    UsuarioService userSvc;
    
    @Autowired
    ProdutoService produtoService;

    public CesApplicationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //cria conta admin quando não existe no banco
        Usuario admin = new Usuario();
        String phUser = "admin";
        String phPass = "pass";
        admin.setNome(phUser);
        admin.setPass(phPass);
        
        List<Usuario> listaUsers = userSvc.buscarTodos();
        boolean foundAdmin = false;
        for (Usuario u : listaUsers) {
            if (u.getNome().equals(phUser)) {
                foundAdmin = true;
            }
        }
        if (!foundAdmin) {
            userSvc.criar(admin);
        }
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CesApplication.main(args);
        
        adminTest();

    }

    private void adminTest() {
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

}
