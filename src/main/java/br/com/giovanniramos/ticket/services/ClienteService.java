package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Cliente;
import br.com.giovanniramos.ticket.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Cliente> findByNome(String nome) {
        List<Cliente> lstCli = this.rep.findByNome(nome);
        return lstCli;
    }

    public List<Cliente> findByEmail(String email) throws Exception{
        List<Cliente> lstCli = this.rep.findByEmail(email);
        if (lstCli.isEmpty()) {
            throw new Exception("Nenhum email compativel");
        }
        return lstCli;
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

}
