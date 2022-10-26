package com.gft.mvc.milhas.controllers;

import javax.validation.Valid;

import com.gft.mvc.milhas.entities.Participante;
import com.gft.mvc.milhas.entities.Usuario;
import com.gft.mvc.milhas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class UsuariosController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(path = "/usuario/lista")
    public ModelAndView listaDeUsuarios() {
        ModelAndView modelAndView = new ModelAndView("usuario/lista.html");

        Iterable<Usuario> listaDeUsuarios = usuarioRepository.findAll();

        modelAndView.addObject("listaDeUsuarios", listaDeUsuarios);

        return modelAndView;
    }

    @GetMapping(path = "/usuario/{id}/descricao")
    public ModelAndView usuario(
            @PathVariable(name = "id") Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView("usuario/descricao.html");

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);

        usuarioOpt.ifPresent(usuario -> modelAndView.addObject("usuario", usuario));

        return modelAndView;
    }
    @GetMapping(path = "/usuario/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("usuario/cadastro.html");

        return modelAndView;
    }

    @PostMapping(path = "/usuario")
    public String create(Usuario usuario) {

        usuarioRepository.save(usuario);

        return "redirect:/usuario/lista";
    }
}


