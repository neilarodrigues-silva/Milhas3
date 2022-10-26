package com.gft.mvc.milhas.controllers;

import com.gft.mvc.milhas.entities.Evento;
import com.gft.mvc.milhas.entities.Grupo;
import com.gft.mvc.milhas.entities.Participante;
import com.gft.mvc.milhas.entities.Usuario;
import com.gft.mvc.milhas.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class GruposController {

    @Autowired

    private GrupoRepository grupoRepository;

    @GetMapping(path = "/grupo/lista")
    public ModelAndView listaDeUsuarios() {
        ModelAndView modelAndView = new ModelAndView("grupo/lista.html");

        Iterable<Grupo> listaDeGrupos = grupoRepository.findAll();

        modelAndView.addObject("listaDeGrupos", listaDeGrupos);

        return modelAndView;
    }
    @GetMapping(path = "/grupo/{id}/descricao")
    public ModelAndView grupo(
            @PathVariable(name = "id") Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView("grupo/descricao.html");

        Optional<Grupo> grupoOpt = grupoRepository.findById(id);

        grupoOpt.ifPresent(grupo -> modelAndView.addObject("grupo", grupo));

        return modelAndView;
    }
    @GetMapping(path = "/grupo/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("grupo/cadastro.html");

        return modelAndView;
    }
    @PostMapping(path ="/grupo")
    public String create(Grupo grupo){

        grupoRepository.save(grupo);

        return "redirect:/grupo/lista";
    }
}
