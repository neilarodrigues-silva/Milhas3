package com.gft.mvc.milhas.controllers;


import com.gft.mvc.milhas.entities.AtividadesConcluidas;
import com.gft.mvc.milhas.repositories.AtividadesConcluidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MarcarAtividadesController {

    @Autowired
    private AtividadesConcluidasRepository atividadesConcluidasRepository;

    @GetMapping(path = "/atividadesConcluidas/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("atividadesConcluidas/cadastro.html");

        return modelAndView;
    }

    @PostMapping(path = "/atividadesConcluidas")
    public String create(AtividadesConcluidas atividadesConcluidas) {

        atividadesConcluidasRepository.save(atividadesConcluidas);

        return "redirect:/atividadesConcluidas/lista";
    }
}