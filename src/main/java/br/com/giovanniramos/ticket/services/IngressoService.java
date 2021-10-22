package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Cliente;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.entities.Ingresso;
import br.com.giovanniramos.ticket.repositories.IngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngressoService {
    @Autowired
    IngressoRepository rep;

    public Ingresso findById(Long id) throws Exception{
        Optional<Ingresso> ticket = this.rep.findById(id);
        if (ticket.isPresent()) {
            return ticket.get();
        }
        throw new Exception("Ingresso não encontrado");
    }

    public Ingresso findByCliente(Cliente cliente) throws Exception{
        Ingresso ticket = this.rep.findByCliente(cliente);
        if (ticket != null) {
            return ticket;
        }
        throw new Exception("Ingresso não encontrado");
    }

    public Ingresso findByEvento(Evento evento) throws Exception {
        Ingresso ticket = this.rep.findByEvento(evento);
        if (ticket != null) {
            return ticket;
        }
        throw new Exception("Ingresso não encontrado");
    }
}
