package com.gft.mvc.milhas.controllers;

import com.gft.mvc.milhas.entities.Evento;
import com.gft.mvc.milhas.entities.Participante;
import com.gft.mvc.milhas.repositories.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Part;
import java.util.Optional;

@Controller
public class ParticipantesController {
    @Autowired
    private ParticipanteRepository participanteRepository;

    @GetMapping(path = "/participante/lista")
    public ModelAndView listaDeParticipantes() {
        ModelAndView modelAndView = new ModelAndView("participante/lista.html");

        Iterable<Participante> listaDeParticipantes = participanteRepository.findAll();

        modelAndView.addObject("listaDeParticipantes", listaDeParticipantes);

        return modelAndView;
    }

    @GetMapping(path = "/participante/{id}/descricao")
    public ModelAndView participante(
            @PathVariable(name = "id") Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView("participante/descricao.html");

        Optional<Participante> participanteOpt = participanteRepository.findById(id);

        participanteOpt.ifPresent(participante -> modelAndView.addObject("participante", participante));

        return modelAndView;
    }

    @GetMapping(path = "/participante/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("participante/cadastro.html");

        return modelAndView;
    }

    @PostMapping(path ="/participante")
    public String create(Participante participante){

       participanteRepository.save(participante);

       return "redirect:/participante.lista";
        }
}