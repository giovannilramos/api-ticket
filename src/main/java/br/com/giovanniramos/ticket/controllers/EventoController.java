package br.com.giovanniramos.ticket.controllers;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    @Autowired
    private EventoService service;

    @PostMapping
    public Evento save(@RequestBody final Evento evento) throws Exception {
        return this.service.save(evento);
    }

    @GetMapping("/{id}")
    public Evento findById(@PathVariable final Long id) throws Exception {
        return this.service.findById(id);
    }

    @GetMapping("/{nome}")
    public List<Evento> findByNome(@PathVariable final String nome) throws Exception {
        return this.service.findByNome(nome);
    }

    @GetMapping("/eventos")
    public List<Evento> todosEventos() throws Exception {
        return this.service.todosEventos();
    }

    @GetMapping("/{local}")
    public List<Evento> findByLocal(@PathVariable final String local) throws Exception {
        return this.service.findByLocal(local);
    }

    @GetMapping("/{dataEvento}")
    public List<Evento> findByDataEvento(@PathVariable final Calendar dataEvento) throws Exception  {
        return this.service.findByDataEvento(dataEvento);
    }

    @GetMapping("/{categoria}")
    public List<Evento> findByCategoria(@PathVariable final Categoria categoria) throws Exception {
        return this.service.findByCategoria(categoria);
    }

    @PutMapping("/{id}")
    public Evento update(@PathVariable final Evento evento) throws Exception {
        return this.service.update(evento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) throws Exception {
        this.service.delete(id);
    }
}
