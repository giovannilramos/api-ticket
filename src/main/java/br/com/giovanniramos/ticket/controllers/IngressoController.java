package br.com.giovanniramos.ticket.controllers;

import br.com.giovanniramos.ticket.entities.Cliente;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.entities.Ingresso;
import br.com.giovanniramos.ticket.services.IngressoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingressos")
public class IngressoController {
    @Autowired
    IngressoService service;

    @GetMapping("/{id}")
    public Ingresso obterPorId(@PathVariable Long id) throws Exception {
        return this.service.findById(id);
    }

    @GetMapping("/{cliente}")
    public Ingresso findByCliente(@PathVariable Cliente cliente) throws Exception {
        return this.service.findByCliente(cliente);
    }

    @GetMapping("/{eventos}")
    public Ingresso findByEvento(@PathVariable Evento evento) throws Exception {
        return this.service.findByEvento(evento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        this.service.delete(id);
    }
}
