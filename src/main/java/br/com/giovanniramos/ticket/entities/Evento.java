package br.com.giovanniramos.ticket.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 150, unique = false, nullable = false)
    private String nome;
    @Column(unique = false, nullable = true)
    private String descricao;
    @Column(unique = false, nullable = false)
    private String local;
    @Column(unique = false, nullable = false)
    private float preco;
    @Column(nullable = false)
    private Calendar dataEvento;

    @Lob
    private Text url;

    @OneToOne
    private Cliente responsavel;
    @OneToOne
    private Categoria categoria;
}
