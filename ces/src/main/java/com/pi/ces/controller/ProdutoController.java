
package com.pi.ces.controller;

import com.pi.ces.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoController {
    
    @Autowired
    ProdutoService produtoService;
    
    @GetMapping("/")
    public String root(Model model) {
        return "index";
    }
    
    @GetMapping("/adicionarproduto")
    public String adicionarProduto(Model model){
        return "adicionarproduto";
    }
    
    @GetMapping("/retirarproduto")
    public String retirarProduto(Model model){
        return "retirarproduto";
    }
    
}
