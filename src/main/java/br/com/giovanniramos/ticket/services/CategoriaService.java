package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Categoria;
import br.com.giovanniramos.ticket.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository rep;

    public Categoria findById(Long id) throws Exception {
        Optional<Categoria> categ = this.rep.findById(id);
        if (categ.isPresent()) {
            return categ.get();
        }
        throw new Exception("Categoria não encontrada");
    }

    public Categoria save(Categoria categ) throws Exception {
        if (categ == null)
            throw new Exception("Erro ao registrar uma nova categoria");
        Categoria categoria = this.rep.save(categ);
        return categoria;
    }

    public Categoria findByNome(String nome) throws Exception {
        Categoria categ = this.rep.findByNome(nome);
        if(categ != null) {
            return categ;
        }
        throw new Exception("Categoria não encontrada");
    }

    public void delete(Long id) throws Exception {
        if (id == null)
            throw new Exception("Categoria não encontrada");
        this.rep.deleteById(id);
    }
}
