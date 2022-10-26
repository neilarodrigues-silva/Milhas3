package com.gft.mvc.milhas.controllers;


import com.gft.mvc.milhas.entities.MarcarPresencas;
import com.gft.mvc.milhas.repositories.PresencasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PresencasController {

    @Autowired
    private PresencasRepository presencasRepository;

    @GetMapping(path = "/presencas/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("presencas/cadastro.html");

        return modelAndView;
    }

    @PostMapping(path = "/presencas")
    public String create(MarcarPresencas presencas) {

        presencasRepository.save(presencas);

        return "redirect:/presencas/lista";
    }

    @GetMapping(path = "/MarcarPresencas/lista")
    public ModelAndView listaDeParticipantesPresentes() {
        ModelAndView modelAndView = new ModelAndView("MarcarPresenca/lista.html");

        Iterable<MarcarPresencas> listaDeParticipantesPresentes = presencasRepository.findAll();

        modelAndView.addObject("listaDeParticipantesPresentes", listaDeParticipantesPresentes);

        return modelAndView;
    }

}

