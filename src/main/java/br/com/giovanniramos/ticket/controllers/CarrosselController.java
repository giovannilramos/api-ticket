package br.com.giovanniramos.ticket.controllers;

import br.com.giovanniramos.ticket.entities.Carrossel;
import br.com.giovanniramos.ticket.services.CarrosselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrossel")
public class CarrosselController {
    @Autowired
    private CarrosselService service;

    @GetMapping("/{id}")
    public Carrossel obterPorId(@PathVariable final Long id) throws Exception {
        return this.service.findById(id);
    }
}
