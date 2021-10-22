package br.com.giovanniramos.ticket.repositories;

import br.com.giovanniramos.ticket.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
    Optional<Cliente> findById(Long id);
    Cliente findByEmail(String email);
    List<Cliente> findByFone(String fone);
    Cliente findByCpf(String cpf);
}
