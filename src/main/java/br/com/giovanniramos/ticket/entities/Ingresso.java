package br.com.giovanniramos.ticket.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private float preco;
    @Column(nullable = false)
    private Calendar dataCompra;

    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Evento evento;

}
