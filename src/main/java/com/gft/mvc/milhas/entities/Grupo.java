package com.gft.mvc.milhas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @Column
    private String nome;

    @Column(name = "cod_evento")
    private Integer codEvento;

    public Grupo(String nome, Integer codEvento) {
        this.nome = nome;
        this.codEvento = codEvento;
    }
}
