
package com.pi.ces.service;

import com.pi.ces.model.Produto;
import com.pi.ces.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;
    
    public Produto criar(Produto p) {
        p.setId(null);
        produtoRepository.save(p);
        return p;
    }
    
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }
    
     public Produto buscarPorId(Integer id){ //recebe o Identificador... 
        return produtoRepository.findById(id).orElseThrow(); //e retorna o objeto Produto do repositorio ou retorna erro
    }
    
    public void excluir(Integer id){ //recebe id do produto e exclui do repositorio
       Produto produtoEncontrado = buscarPorId(id);
       produtoRepository.deleteById(produtoEncontrado.getId());
    }
    
    public Produto atualizar(Integer id, Produto p){
        Produto produtoEncontrado = buscarPorId(id);
        
        produtoEncontrado.setNome(p.getNome());
        produtoEncontrado.setDescricao(p.getDescricao());
        produtoEncontrado.setQuantidade(p.getQuantidade());
        return produtoEncontrado;
    }
    
}
