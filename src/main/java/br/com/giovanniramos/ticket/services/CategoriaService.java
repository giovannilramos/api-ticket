package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository rep;

    public Categoria findById(final Long id) throws Exception {
        Optional<Categoria> categ = this.rep.findById(id);
        if (categ.isPresent()) {
            return categ.get();
        }
        throw new Exception("Categoria não encontrada");
    }

    public Categoria save(final Categoria categ) throws Exception {
        if (categ == null)
            throw new Exception("Erro ao registrar uma nova categoria");
        return this.rep.save(categ);
    }

    public Categoria findByNome(final String nome) throws Exception {
        Categoria categ = this.rep.findByNome(nome);
        if(categ != null) {
            return categ;
        }
        throw new Exception("Categoria não encontrada");
    }

    public void delete(final Long id) throws Exception {
        if (id == null)
            throw new Exception("Categoria não encontrada");
        this.rep.deleteById(id);
    }
}
