package br.com.giovanniramos.ticket.entities;

import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Carrossel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List<Evento> eventos;
    private Text url;

    public Carrossel() {

    }

    public Carrossel(Long id, List<Evento> eventos, Text url) {
        this.id = id;
        this.eventos = eventos;
        this.url = url;
    }
}
