
package com.pi.ces.controller;

import com.pi.ces.model.Produto;
import com.pi.ces.model.Usuario;
import com.pi.ces.service.ProdutoService;
import com.pi.ces.service.UsuarioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;
    
    @Autowired
    UsuarioService userSvc;
    
    @GetMapping("/")
    public String root(Model model) {
        //test admin account setup
        Usuario admin = new Usuario();
        String phUser = "admin";
        String phPass = "pass";
        admin.setNome(phUser);
        admin.setPass(phPass);
        List<Usuario> listaUsers = userSvc.buscarTodos();
        boolean foundAdmin = false;
        for (Usuario u : listaUsers) {
            if (u.getNome().equals(phUser)){
                foundAdmin = true;
            }
        }
        if (!foundAdmin){
            userSvc.criar(admin);
        }
        //setup ends here
        List<Produto> produtosFetched = new ArrayList<>();
        produtosFetched = produtoService.buscarTodos(); //recolhe os produtos no repositorio
        model.addAttribute("produtos", produtosFetched);
        Usuario usuario = new Usuario();
        model.addAttribute("usuario",usuario);
        
        return "index";
    }
    
    @GetMapping("/adminpanel")
    public String adminPanel(Model model){
        return "adminpanel";
    }
    
    @GetMapping("/userpanel")
    public String userPanel(Model model){
        return "userpanel";
    }
    
    @GetMapping("/adicionarproduto")
    public String adicionarProduto(Model model){
        model.addAttribute("produto",new Produto());
        return "adicionarproduto";
    }
    
    @GetMapping("/editarproduto")
    public String editarProduto(Model model,@RequestParam String id){
        Integer produtoId = Integer.parseInt(id);
        Produto produtoSearch = produtoService.buscarPorId(produtoId);
        
        model.addAttribute("produto",produtoSearch);
        return "editarproduto";
    }
    
    @GetMapping("/excluirproduto")
    public String excluirProduto (@RequestParam String id, Model model){
        Integer idProduto = Integer.parseInt(id);
        produtoService.excluir(idProduto);
        return "redirect:/";
    }
    
    //Postmappings
    
    @PostMapping("/registrarproduto")
    public String registrarProduto (@ModelAttribute Produto produto, Model model){
            produtoService.criar(produto); //Adiciona o Produto recebido pelo form para o repositorio
            return "redirect:/"; //retorna ao menu principal
    }
    
    
}
