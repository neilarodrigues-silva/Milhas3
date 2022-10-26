package com.gft.mvc.milhas.controllers;

import com.gft.mvc.milhas.entities.Atividade;
import com.gft.mvc.milhas.repositories.AtividadeRepository;
import com.gft.mvc.milhas.repositories.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class AtividadesController {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private ParticipanteRepository participanteRepository;

    @GetMapping(path = "/atividade/lista")
    public ModelAndView listaDeAtividades() {
        ModelAndView modelAndView = new ModelAndView("atividade/lista.html");

        Iterable<Atividade> listaDeAtividades = atividadeRepository.findAll();

        modelAndView.addObject("listaDeAtividades", listaDeAtividades);

        return modelAndView;
    }

    @GetMapping(path = "/atividade/{id}/descricao")
    public ModelAndView atividade(
            @PathVariable(name = "id") Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView("atividade/descricao.html");

        Optional<Atividade> atividadeOpt = atividadeRepository.findById(id);

        atividadeOpt.ifPresent(atividade -> modelAndView.addObject("atividade", atividade));

        return modelAndView;
    }

    @GetMapping(path = "/atividade/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("atividade/cadastro.html");

        return modelAndView;
    }

    @PostMapping(path = "/atividade")
    public String create(Atividade atividade) {

        atividadeRepository.save(atividade);

        return "redirect:/atividade/lista";
    }

}