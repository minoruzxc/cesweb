package com.pi.ces.controller;

import com.pi.ces.model.Usuario;
import com.pi.ces.service.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, Model model, Usuario usuario) {
        HttpSession sessao = request.getSession();
        if (sessao != null && usuario.getNome().equals("admin") && usuario.getPass().equals("pass")) {
            List<Usuario> usuariosFetched = usuarioService.buscarTodos();
            ModelAndView newMav = new ModelAndView("adminpanel");
            newMav.addObject("usuarios",usuariosFetched);
            newMav.addObject("sessao",sessao);
            return newMav;
        } else if (sessao != null && usuario.getNome().equals("guest") && usuario.getPass().equals("")) {
            //newMav.addObject("sessao",sessao); implementar tokens
            return new ModelAndView("redirect:/userpanel");
        } else {
            return new ModelAndView("redirect:/");
        }
    }
    
    @GetMapping("/adminlogin")
    public String adminLogin (Model model){
        List<Usuario> usuariosFetched = usuarioService.buscarTodos();
        model.addAttribute("usuarios",usuariosFetched);
        return "adminpanel";
    }
    
    @GetMapping("/userlogin")
    public String userLogin (Model model){
        return "/userpanel";
    }

   
    
    

}
