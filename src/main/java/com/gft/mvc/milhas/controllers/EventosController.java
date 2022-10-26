package com.gft.mvc.milhas.controllers;

import com.gft.mvc.milhas.entities.Atividade;
import com.gft.mvc.milhas.entities.Evento;
import com.gft.mvc.milhas.entities.Grupo;
import com.gft.mvc.milhas.entities.Participante;
import com.gft.mvc.milhas.repositories.AtividadeRepository;
import com.gft.mvc.milhas.repositories.EventoRepository;
import com.gft.mvc.milhas.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class EventosController {

    private final EventoRepository eventoRepository;

    private final GrupoRepository grupoRepository;

    private final AtividadeRepository atividadeRepository;

    @Autowired
    public EventosController(EventoRepository eventoRepository, GrupoRepository grupoRepository, AtividadeRepository atividadeRepository) {
        this.eventoRepository = eventoRepository;
        this.grupoRepository = grupoRepository;
        this.atividadeRepository = atividadeRepository;
    }

    @GetMapping(path = "/evento/lista")
    public ModelAndView listaDeEventos() {
        ModelAndView modelAndView = new ModelAndView("evento/lista.html");

        Iterable<Evento> listaDeEventos = eventoRepository.findAll();

        modelAndView.addObject("listaDeEventos", listaDeEventos);

        return modelAndView;
    }

    @GetMapping(path = "/evento/{id}/descricao")
    public ModelAndView evento(
            @PathVariable(name = "id") Integer id
    ) {
        ModelAndView modelAndView = new ModelAndView("evento/descricao.html");

        Optional<Evento> eventoOpt = eventoRepository.findById(id);

        eventoOpt.ifPresent(evento -> modelAndView.addObject("evento", evento));

        List<Grupo> listaDeGrupos = grupoRepository.findAllByCodEventoEquals(id);

        modelAndView.addObject("listaDeGrupos", listaDeGrupos);

        List<Atividade> listaDeAtividades = atividadeRepository.findAllByCodEventoEquals(id);

        modelAndView.addObject("listaDeAtividades", listaDeAtividades);

        return modelAndView;
    }

    @GetMapping(path = "/evento/cadastro")
    public ModelAndView cadastro() {
        ModelAndView modelAndView = new ModelAndView("evento/cadastro.html");

        return modelAndView;
    }

    @GetMapping(path = "/evento/presencas")
    public ModelAndView presencas() {
        ModelAndView modelAndView = new ModelAndView("evento/presencas.html");

        return modelAndView;
    }

    @GetMapping(path = "/evento/marcar-atividades")
    public ModelAndView marcarAtividades() {
        ModelAndView modelAndView = new ModelAndView("evento/marcar-atividades.html");

        return modelAndView;
    }

    @GetMapping(path = "/evento/ranking")
    public ModelAndView ranking() {
        ModelAndView modelAndView = new ModelAndView("evento/ranking.html");

        return modelAndView;
    }

    @PostMapping(path = "/evento")
    public String create(Evento evento) {

        eventoRepository.save(evento);

        return "redirect:/evento/lista";
    }
}