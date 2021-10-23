package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.exceptions.CategoriaNotFoundException;
import br.com.giovanniramos.ticket.exceptions.UpdateDatabaseException;
import br.com.giovanniramos.ticket.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository rep;

    public Categoria findById(final Long id) {
        Optional<Categoria> categ = this.rep.findById(id);
        if (categ.isPresent()) {
            return categ.get();
        }
        throw new CategoriaNotFoundException();
    }

    public Categoria save(final Categoria categ) {
        if (categ == null)
            throw new UpdateDatabaseException();
        return this.rep.save(categ);
    }

    public Categoria findByNome(final String nome) {
        Categoria categ = this.rep.findByNome(nome);
        if(categ != null) {
            return categ;
        }
        throw new CategoriaNotFoundException();
    }

    public void delete(final Long id) {
        if (id == null)
            throw new CategoriaNotFoundException();
        this.rep.deleteById(id);
    }
}
