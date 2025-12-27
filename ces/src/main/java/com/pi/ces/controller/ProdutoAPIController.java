
package com.pi.ces.controller;

import com.pi.ces.model.Produto;
import com.pi.ces.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/produto")
public class ProdutoAPIController {
    
    @Autowired
    ProdutoService produtoService; // Injeta o serviço + repositorio
    
    @PostMapping("/adicionar")
    public ResponseEntity<Produto> criar (@RequestBody Produto produto){
       Produto novoProduto = produtoService.criar(produto);
       return new ResponseEntity<>(novoProduto,HttpStatus.CREATED);
    }
    
    @GetMapping("/listarTodos") //retorna a lista de produtos do banco
    public ResponseEntity<List> listar(){
        List<Produto> listarTodosProdutos = produtoService.buscarTodos();
        return new ResponseEntity<>(listarTodosProdutos,HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}") //Retorna um produto pelo seu id
    public ResponseEntity<Produto> buscar(@PathVariable Integer id){
        Produto produtoEncontrado = produtoService.buscarPorId(id);
        return new ResponseEntity<>(produtoEncontrado,HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}") //atualiza um produto pelo seu id
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produto){
        Produto produtoAtualizado = produtoService.atualizar(id, produto);
        return new ResponseEntity<>(produtoAtualizado,HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}") //exclui um produto pelo id
    public ResponseEntity<Produto> excluir(@PathVariable Integer id){
        produtoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
