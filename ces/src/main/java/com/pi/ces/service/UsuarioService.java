
package com.pi.ces.service;

import com.pi.ces.model.Usuario;
import com.pi.ces.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public Usuario criar(Usuario u) {
        u.setId(null);
        usuarioRepository.save(u);
        return u;
    }
    
    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }
    
     public Usuario buscarPorId(Integer id){ //recebe o Identificador... 
        return usuarioRepository.findById(id).orElseThrow(); //e retorna o objeto Usuario do repositorio ou retorna erro
    }
    
    public void excluir(Integer id){ //recebe id do produto e exclui do repositorio
       Usuario usuarioEncontrado = buscarPorId(id);
       usuarioRepository.deleteById(usuarioEncontrado.getId());
    }
    
    public Usuario atualizar(Integer id, Usuario u){
        Usuario usuarioEncontrado = buscarPorId(id);
        
        usuarioEncontrado.setNome(u.getNome());
        usuarioEncontrado.setPass(u.getPass());
        usuarioEncontrado.setAcesso(u.getAcesso());
        return usuarioEncontrado;
    }
}
