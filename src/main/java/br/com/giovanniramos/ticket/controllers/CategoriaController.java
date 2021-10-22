package br.com.giovanniramos.ticket.controllers;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @PostMapping
    public Categoria save(@RequestBody final Categoria categ) throws Exception{
        return this.service.save(categ);
    }

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable final Long id) throws Exception {
        return this.service.findById(id);
    }

    @GetMapping("/{nome}")
    public Categoria findByNome(@PathVariable final String nome) throws Exception {
        return this.service.findByNome(nome);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final Long id) throws Exception {
        this.service.delete(id);
    }

}
