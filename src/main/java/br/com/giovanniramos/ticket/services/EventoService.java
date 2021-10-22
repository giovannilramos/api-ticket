package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.repositories.EventoRepository;
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

    public Evento findById(final Long id) throws Exception {
        Optional<Evento> evento = this.rep.findById(id);
        if (evento.isPresent())
            return evento.get();

        throw new Exception("Evento não encontrado");
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
            throw new Exception("Nenhum evento registrado");

        return eventos;
    }

    public List<Evento> findByNome(final String nome) throws Exception {
        List<Evento> eventos = this.rep.findByNome(nome);
        if (eventos.isEmpty())
            throw new Exception("Evento não encontrado");

        return eventos;
    }

    public List<Evento> findByLocal(final String local) throws Exception {
        List<Evento> eventos = this.rep.findByLocal(local);
        if (eventos.isEmpty())
            throw new Exception("Local do evento não encontrado");

        return eventos;
    }

    public List<Evento> findByDataEvento(final Calendar dataEvento) throws Exception  {
        List<Evento> eventos = this.rep.findByDataEvento(dataEvento);
        if (eventos.isEmpty())
            throw new Exception("Evento não encontrado");

        return eventos;
    }

    public List<Evento> findByCategoria(final Categoria categoria) throws Exception {
        List<Evento> eventos = this.rep.findByCategoria(categoria);
        if (eventos.isEmpty())
            throw new Exception("Evento não encontrado");

        return eventos;
    }

    public Evento update(final Evento evento) throws Exception {
        try {
            var e = new Evento();

            e.setNome(evento.getNome());
            e.setCategoria(evento.getCategoria());
            e.setDescricao(evento.getDescricao());
            e.setLocal(evento.getLocal());
            e.setPreco(evento.getPreco());
            e.setDataEvento(evento.getDataEvento());
            e.setUrl(evento.getUrl());

            return this.rep.save(e);
        } catch (DataAccessException ex) {
            throw new Exception("Erro na alteração dos dados");
        }
    }

    public void delete(final Long id) throws Exception {
        if (id == null)
            throw new Exception("Evento não localizado");
        this.rep.deleteById(id);
    }
}
