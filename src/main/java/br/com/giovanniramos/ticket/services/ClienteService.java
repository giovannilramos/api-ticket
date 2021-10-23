package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Cliente;
import br.com.giovanniramos.ticket.exceptions.ClienteNotFoundException;
import br.com.giovanniramos.ticket.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository rep;

    public Cliente findById(final Long id) {
        Optional<Cliente> cli;
        cli = this.rep.findById(id);
        if (cli.isPresent())
            return cli.get();

        throw new ClienteNotFoundException("Cliente não encontrado");
    }

    public Cliente save(final Cliente cli) throws Exception {
        if (cli == null)
            throw new Exception("Dados não fornecidos");
        try {
            return this.rep.save(cli);
        } catch (DataAccessException ex) {
            throw new Exception("Erro ao cadastrar");
        }
    }

    public List<Cliente> findByNome(final String nome) {
        try {
            return this.rep.findByNome(nome);
        } catch (DataAccessException ex) {
            throw new ClienteNotFoundException("Nenhum nome econtrado");
        }
    }

    public List<Cliente> todosClientes() {
        List<Cliente> clientes = this.rep.findAll();
        if (clientes.isEmpty())
            throw new ClienteNotFoundException("Não há registros");

        return clientes;
    }

    public Cliente findByEmail(final String email) {
        Cliente cli = this.rep.findByEmail(email);
        if (cli == null) {
            throw new ClienteNotFoundException("Nenhum email compativel");
        }
        return cli;
    }

    public List<Cliente> findByCel(final String cel) {
        List<Cliente> lstCli = this.rep.findByCel(cel);
        if(lstCli.isEmpty()) {
            throw new ClienteNotFoundException("Nenhum telefone encontrado");
        }
        return lstCli;
    }

    public Cliente findByCpf(final String cpf) {
        Cliente cli;
        cli = this.rep.findByCpf(cpf);
        if (cli != null) {
            return cli;
        }
        throw new ClienteNotFoundException("CPF não encontrado");
    }

    public Cliente update(final Cliente cli) throws Exception {
        try {
            final var cliente = Cliente.builder()
                    .nome(cli.getNome())
                    .cel(cli.getCel())
                    .cpf(cli.getCpf())
                    .email(cli.getEmail())
                    .sobreNome(cli.getSobreNome())
                    .build();

            return this.rep.save(cliente);
        } catch (DataAccessException ex) {
            throw new Exception("Erro ao atualizar os dados");
        }
    }

    public void delete(final Long id) {
        if (id == null)
            throw new ClienteNotFoundException("Cliente não localizado");
        this.rep.deleteById(id);
    }

}
