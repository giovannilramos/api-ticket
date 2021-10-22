package br.com.giovanniramos.ticket.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = false, nullable = false)
    private String nome;
    @Column(nullable = false)
    private String sobreNome;
    @Column(unique = true, length = 14, nullable = false)
    private String cpf;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String cel;
    @Column(unique = true, nullable = false)
    private String senha;

    public  Cliente() {

    }

    public Cliente(Long id, String nome, String sobreNome, String cpf, String email, String cel, String senha) {
        this.id = id;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
        this.email = email;
        this.cel = cel;
        this.senha = senha;
    }
}
