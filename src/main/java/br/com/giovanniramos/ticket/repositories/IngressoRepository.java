package br.com.giovanniramos.ticket.repositories;

import br.com.giovanniramos.ticket.entities.Cliente;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.entities.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
    Ingresso findByCliente(final Cliente cliente);
    Ingresso findByEvento(final Evento evento);
}
