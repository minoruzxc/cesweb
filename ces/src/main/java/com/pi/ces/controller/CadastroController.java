package com.pi.ces.controller;

import com.pi.ces.model.Usuario;
import com.pi.ces.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/adicionar")
    public String cadastroUsuario(@ModelAttribute Usuario usuario, Model model) {
        usuarioService.criar(usuario);
        return "cadastrousuario";
    }

    @PostMapping("/criar")
    public String criarUsuario(@ModelAttribute Usuario usuario, Model model) {
        usuarioService.criar(usuario);
        List<Usuario> lu = usuarioService.buscarTodos();
        model.addAttribute("usuarios", lu);
        return "adminpanel";
    }

}
