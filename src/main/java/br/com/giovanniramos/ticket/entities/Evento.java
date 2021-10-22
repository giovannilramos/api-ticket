package br.com.giovanniramos.ticket.entities;

import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Calendar;

@Entity
@Data
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
    @Column(unique = false, nullable = false)
    private Text url;
    @Column(nullable = false)
    private Calendar dataEvento;

    @OneToOne
    private Cliente responsavel;
    @OneToOne
    private Categoria categoria;

    public Evento() {

    }

    public Evento(Long id, String nome, String descricao, String local, float preco, Text url, Calendar dataEvento, Cliente responsavel, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.preco = preco;
        this.url = url;
        this.dataEvento = dataEvento;
        this.responsavel = responsavel;
        this.categoria = categoria;
    }
}
