package br.com.giovanniramos.ticket.repositories;

import br.com.giovanniramos.ticket.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(final Long id);
    List<Cliente> findByNome(final String nome);
    Cliente findByEmail(final String email);
    List<Cliente> findByCel(final String cel);
    Cliente findByCpf(final String cpf);
}
