package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Cliente;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.entities.Ingresso;
import br.com.giovanniramos.ticket.exceptions.TicketNotFoundException;
import br.com.giovanniramos.ticket.repositories.IngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IngressoService {
    @Autowired
    private IngressoRepository rep;

    public Ingresso findById(final Long id) {
        Optional<Ingresso> ticket;
        ticket = this.rep.findById(id);
        if (ticket.isPresent())
            return ticket.get();

        throw new TicketNotFoundException();
    }

    public Ingresso findByCliente(final Cliente cliente) {
        Ingresso ticket = this.rep.findByCliente(cliente);
        if (ticket != null) {
            return ticket;
        }
        throw new TicketNotFoundException();
    }

    public Ingresso findByEvento(final Evento evento) {
        Ingresso ticket = this.rep.findByEvento(evento);
        if (ticket != null) {
            return ticket;
        }
        throw new TicketNotFoundException();
    }

    public void delete(final Long id) {
        if (id == null)
            throw new TicketNotFoundException();
        this.rep.deleteById(id);
    }
}
