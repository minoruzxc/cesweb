package com.pi.ces;

import com.pi.ces.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CesApplicationTest {

    public CesApplicationTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        Usuario admin = new Usuario();
        String phUser = "admin";
        String phPass = "pass";
        admin.setNome(phUser);
        admin.setPass(phPass);
        List<Usuario> listaUsers = new ArrayList<>();
        listaUsers.add(admin);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testMain() { //Remover o comentario no método para verificar testes
        ArrayList<Usuario> listaFetched = generateListWithAdmin();
        //listaFetched.clear();
        checkForAdmin(listaFetched);
        
    }

    @Test
    public void checkForAdmin(ArrayList<Usuario> listaUsers) {
        boolean foundAdmin = false;
        if (!listaUsers.isEmpty()) {
            for (Usuario u : listaUsers) {
                if (u.getNome().equals("admin")) {
                    foundAdmin = true;
                }
            }
        }assertTrue(foundAdmin);
    }

    @Test
    public ArrayList<Usuario> generateListWithAdmin() {
        Usuario admin = new Usuario();
        String phUser = "admin";
        String phPass = "pass";
        admin.setNome(phUser);
        admin.setPass(phPass);
        ArrayList<Usuario> listaUsers = new ArrayList<>();
        listaUsers.add(admin);
        return listaUsers;
    }

}
