package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Cliente;
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

    public Cliente findById(Long id) throws Exception{
        Optional<Cliente> cli;
        cli = this.rep.findById(id);
        if (cli.isPresent())
            return cli.get();

        throw new Exception("Cliente não encontrado");
    }

    public Cliente save(Cliente cli) throws Exception {
        if (cli == null)
            throw new Exception("Dados não fornecidos");
        try {
            return this.rep.save(cli);
        } catch (DataAccessException ex) {
            throw new Exception("Erro ao cadastrar");
        }
    }

    public List<Cliente> findByNome(String nome) {
        List<Cliente> lstCli = this.rep.findByNome(nome);
        return lstCli;
    }

    public List<Cliente> todosClientes() throws Exception{
        List<Cliente> clientes = this.rep.findAll();
        if (clientes.isEmpty())
            throw new Exception("Não há registros");

        return clientes;
    }

    public Cliente findByEmail(String email) throws Exception{
        Cliente cli = this.rep.findByEmail(email);
        if (cli == null) {
            throw new Exception("Nenhum email compativel");
        }
        return cli;
    }

    public List<Cliente> findByFone(String fone) throws Exception{
        List<Cliente> lstCli = this.rep.findByFone(fone);
        if(lstCli.isEmpty()) {
            throw new Exception("Nenhum telefone encontrado");
        }
        return lstCli;
    }

    public Cliente findByCpf(String cpf) throws Exception {
        Cliente cli;
        cli = this.rep.findByCpf(cpf);
        if (cli != null) {
            return cli;
        }
        throw new Exception("CPF não encontrado");
    }

    public Cliente alterar(Cliente cli) throws Exception {
        var cliente = new Cliente();
        cliente.setNome(cli.getNome());
        cliente.setCel(cli.getCel());
        cliente.setCpf(cli.getCpf());
        cliente.setEmail(cli.getEmail());
        cliente.setSobreNome(cli.getSobreNome());

        return this.rep.save(cliente);
    }

    public void delete(Long id) throws Exception {
        if (id == null)
            throw new Exception("Cliente não localizado");
        this.rep.deleteById(id);
    }

}
