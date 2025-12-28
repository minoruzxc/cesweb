
package com.pi.ces.controller;

import com.pi.ces.model.Produto;
import com.pi.ces.service.ProdutoService;
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
    
    @GetMapping("/")
    public String root(Model model) {
        List<Produto> produtosFetched = new ArrayList<>();
        produtosFetched = produtoService.buscarTodos(); //recolhe os produtos no repositorio
        model.addAttribute("produtos", produtosFetched);
        
        return "index";
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
    
    //Postmappings
    
    @PostMapping("/registrarproduto")
    public String registrarProduto (@ModelAttribute Produto produto, Model model){
            produtoService.criar(produto); //Adiciona o Produto recebido pelo form para o repositorio
            return "redirect:/"; //retorna ao menu principal
    }
    
    @GetMapping("/excluirproduto")
    public String excluirProduto (@RequestParam String id, Model model){
        Integer idProduto = Integer.parseInt(id);
        produtoService.excluir(idProduto);
        return "redirect:/";
    }
}
