package br.com.giovanniramos.ticket.entities;

import lombok.Data;
import org.w3c.dom.Text;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private Text url;

    public Categoria() {

    }

    public Categoria(Long id, String nome, String descricao, Text url) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.url = url;
    }
}
