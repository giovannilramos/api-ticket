package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.exceptions.EventoNotFoundException;
import br.com.giovanniramos.ticket.repositories.EventoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepository rep;

    public Evento findById(final Long id) {
        Optional<Evento> evento = this.rep.findById(id);
        if (evento.isPresent())
            return evento.get();

        throw new EventoNotFoundException();
    }

    public Evento save(final Evento evento) throws Exception {
        if (evento == null)
            throw new Exception("Preencha todos os dados");

        try {
            return this.rep.save(evento);
        } catch (DataAccessException ex) {
            throw new Exception("Erro no cadastro");
        }
    }

    public List<Evento> todosEventos() throws Exception {
        List<Evento> eventos = this.rep.findAll();
        if (eventos.isEmpty())
            throw new EventoNotFoundException();

        return eventos;
    }

    public List<Evento> findByNome(final String nome) {
        List<Evento> eventos = this.rep.findByNome(nome);
        if (eventos.isEmpty())
            throw new EventoNotFoundException();

        return eventos;
    }

    public List<Evento> findByLocal(final String local) {
        List<Evento> eventos = this.rep.findByLocal(local);
        if (eventos.isEmpty())
            throw new EventoNotFoundException();

        return eventos;
    }

    public List<Evento> findByDataEvento(final Calendar dataEvento) {
        List<Evento> eventos = this.rep.findByDataEvento(dataEvento);
        if (eventos.isEmpty())
            throw new EventoNotFoundException();

        return eventos;
    }

    public List<Evento> findByCategoria(final Categoria categoria) {
        List<Evento> eventos = this.rep.findByCategoria(categoria);
        if (eventos.isEmpty())
            throw new EventoNotFoundException();

        return eventos;
    }

    public Evento update(final Evento evento) throws Exception {
        try {
            final var e = Evento.builder()
                    .nome(evento.getNome())
                    .categoria(evento.getCategoria())
                    .descricao(evento.getDescricao())
                    .local(evento.getLocal())
                    .preco(evento.getPreco())
                    .dataEvento(evento.getDataEvento())
                    .url(evento.getUrl())
                    .build();

            return this.rep.save(e);
        } catch (DataAccessException ex) {
            throw new Exception("Erro na alteração dos dados");
        }
    }

    public void delete(final Long id) {
        if (id == null)
            throw new EventoNotFoundException();
        this.rep.deleteById(id);
    }
}
