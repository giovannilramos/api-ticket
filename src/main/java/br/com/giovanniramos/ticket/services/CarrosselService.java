package br.com.giovanniramos.ticket.services;

import br.com.giovanniramos.ticket.entities.Carrossel;
import br.com.giovanniramos.ticket.repositories.CarrosselRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarrosselService {
    @Autowired
    private CarrosselRepository rep;

    public Carrossel findById(final Long id) throws Exception {
        Optional<Carrossel> carrossel = this.rep.findById(id);
        if (carrossel.isPresent())
            return carrossel.get();

        throw new Exception("Não encontrado");
    }
}
