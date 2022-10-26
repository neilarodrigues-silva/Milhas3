package com.gft.mvc.milhas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "participante")
public class Participante {
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
    private Integer nivel;

    @Column(name = "cod_evento")
    private Integer codEvento;

    @Column(name = "cod_grupo")
    private Integer codGrupo;

    public Participante(String nome, String email, String quatroLetras, Integer nivel, Integer codGrupo) {
        this.nome = nome;
        this.email = email;
        this.quatroLetras = quatroLetras;
        this.nivel = nivel;
        this.codGrupo = codGrupo;
    }
}
