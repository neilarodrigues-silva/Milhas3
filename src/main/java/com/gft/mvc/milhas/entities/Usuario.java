package com.gft.mvc.milhas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @Column
    private String nome;

    @Column
    private String email;

    @Column(name = "quatro_letras")
    private String quatroLetras;

    @Column
    private String senha;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Usuario(String nome, String email, String quatroLetras, String senha) {
        this.nome = nome;
        this.email = email;
        this.quatroLetras = quatroLetras;
        this.senha = senha;
    }
}
