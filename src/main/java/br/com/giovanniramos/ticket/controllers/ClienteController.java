package br.com.giovanniramos.ticket.controllers;

import br.com.giovanniramos.ticket.entities.Cliente;
import br.com.giovanniramos.ticket.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService service;

    @PostMapping
    public Cliente save(@RequestBody Cliente cli) throws Exception  {
        return this.service.save(cli);
    }

    @GetMapping("/{id}")
    public Cliente obterPorId(@PathVariable Long id) throws Exception {
        return this.service.findById(id);
    }

    @GetMapping("/{nome}")
    public List<Cliente> obterPorNome(@PathVariable String nome) throws Exception {
        return this.service.findByNome(nome);
    }

    @GetMapping("/{email}")
    public Cliente obterPorEmail(@PathVariable String email) throws Exception {
        return this.service.findByEmail(email);
    }

    @GetMapping
    public List<Cliente> obterTodos() throws Exception {
        return this.service.todosClientes();
    }

    @GetMapping("/{fone}")
    public List<Cliente> obterPorFone(@PathVariable String fone) throws Exception {
        return this.service.findByFone(fone);
    }

    @GetMapping("/cpf")
    public Cliente obterPorCpf(@PathVariable String cpf) throws Exception {
        return this.service.findByCpf(cpf);
    }

    @PutMapping("/{id}")
    public Cliente alterar(@RequestBody Cliente cli) throws Exception {
        return this.service.alterar(cli);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody Long id) throws Exception {
        this.service.delete(id);
    }
}
