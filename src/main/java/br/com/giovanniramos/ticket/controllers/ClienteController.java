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
    private ClienteService service;

    @PostMapping
    public Cliente save(@RequestBody final Cliente cli) throws Exception  {
        return this.service.save(cli);
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable final Long id) throws Exception {
        return this.service.findById(id);
    }

    @GetMapping("/name/{nome}")
    public List<Cliente> findByNome(@PathVariable final String nome) throws Exception {
        return this.service.findByNome(nome);
    }

    @GetMapping("/email/{email}")
    public Cliente findByEmail(@PathVariable final String email) throws Exception {
        return this.service.findByEmail(email);
    }

    @GetMapping
    public List<Cliente> obterTodos() throws Exception {
        return this.service.todosClientes();
    }

    @GetMapping("/cel/{cel}")
    public List<Cliente> findByCel(@PathVariable final String cel) throws Exception {
        return this.service.findByCel(cel);
    }

    @GetMapping("/cpf/{cpf}")
    public Cliente findByCpf(@PathVariable final String cpf) throws Exception {
        return this.service.findByCpf(cpf);
    }

    @PutMapping("/{id}")
    public Cliente update(@RequestBody final Cliente cli) throws Exception {
        return this.service.update(cli);
    }

    @DeleteMapping("/{id}")
    public void delete(@RequestBody final Long id) throws Exception {
        this.service.delete(id);
    }
}
