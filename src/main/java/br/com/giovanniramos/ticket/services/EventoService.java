package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.entities.Evento;
import br.com.giovanniramos.ticket.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private EventoRepository rep;

    public Evento findById(Long id) throws Exception {
        Optional<Evento> evento = this.rep.findById(id);
        if (evento.isPresent())
            return evento.get();

        throw new Exception("Evento não encontrado");
    }

    public List<Evento> findByNome(String nome) throws Exception {
        List<Evento> eventos = this.rep.findByNome(nome);
        if (eventos.isEmpty())
            throw new Exception("Evento não encontrado");

        return eventos;
    }

    public List<Evento> findByLocal(String local) throws Exception {
        List<Evento> eventos = this.rep.findByLocal(local);
        if (eventos.isEmpty())
            throw new Exception("Local do evento não encontrado");

        return eventos;
    }

    public List<Evento> findByData(Calendar dataEvento) throws Exception  {
        List<Evento> eventos = this.rep.findByData(dataEvento);
        if (eventos.isEmpty())
            throw new Exception("Evento não encontrado");

        return eventos;
    }

    public List<Evento> findByCategoria(Categoria categoria) throws Exception {
        List<Evento> eventos = this.rep.findByCategoria(categoria);
        if (eventos.isEmpty())
            throw new Exception("Evento não encontrado");

        return eventos;
    }
}
