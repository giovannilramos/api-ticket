package br.com.giovanniramos.ticket.repositories;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Calendar;
import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByNome(final String nome);
    List<Evento> findByLocal(final String local);
    List<Evento> findByDataEvento(final Calendar dataEvento);
    List<Evento> findByCategoria(final Categoria categoria);
}
