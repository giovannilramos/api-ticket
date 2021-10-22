package br.com.giovanniramos.ticket.repositories;

import br.com.giovanniramos.ticket.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
