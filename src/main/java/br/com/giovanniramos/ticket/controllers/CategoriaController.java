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
    CategoriaService service;

    @PostMapping
    public Categoria save(@RequestBody Categoria categ) throws Exception{
        return this.service.save(categ);
    }

    @GetMapping("/{id}")
    public Categoria obterPorId(@PathVariable Long id) throws Exception {
        return this.service.findById(id);
    }

    @GetMapping("/{nome}")
    public Categoria findByNome(@PathVariable String nome) throws Exception {
        return this.service.findByNome(nome);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        this.service.delete(id);
    }

}
