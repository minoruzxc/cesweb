package com.pi.ces.controller;

import com.pi.ces.model.Usuario;
import com.pi.ces.service.UsuarioService;
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
@RequestMapping("/usuario")
public class UsuarioAPIController {
    
    @Autowired
    UsuarioService usuarioService; // Injeta o serviço + repositorio
    
    @PostMapping("/adicionar")
    public ResponseEntity<Usuario> criar (@RequestBody Usuario usuario){
        usuario.setId(null);
       Usuario novoUsuario = usuarioService.criar(usuario);
       return new ResponseEntity<>(novoUsuario,HttpStatus.CREATED);
    }
    
    @GetMapping("/listarTodos") //retorna a lista de usuarios do banco
    public ResponseEntity<List> listar(){
        List<Usuario> listarTodosUsuarios = usuarioService.buscarTodos();
        return new ResponseEntity<>(listarTodosUsuarios,HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{id}") //Retorna dados do usuario por id
    public ResponseEntity<Usuario> buscar(@PathVariable Integer id){
        Usuario usuarioEncontrado = usuarioService.buscarPorId(id);
        return new ResponseEntity<>(usuarioEncontrado,HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}") //atualiza dados de usuario por id
    public ResponseEntity<Usuario> atualizar(@PathVariable Integer id, @RequestBody Usuario usuario){
        Usuario usuarioAtualizado = usuarioService.atualizar(id, usuario);
        return new ResponseEntity<>(usuarioAtualizado,HttpStatus.OK);
    }
    
    @DeleteMapping("/excluir/{id}") //exclui um cadastro por id
    public ResponseEntity<Usuario> excluir(@PathVariable Integer id){
        usuarioService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
