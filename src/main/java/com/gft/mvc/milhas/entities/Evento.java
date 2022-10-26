package com.gft.mvc.milhas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @Column
    private String nome;

    @Column(name = "data_de_inicio")
    private Date dataDeInicio;

    @Column(name = "data_final")
    private Date dataFinal;

    public Evento(String nome, Date dataDeInicio, Date dataFinal) {
        this.nome = nome;
        this.dataDeInicio = dataDeInicio;
        this.dataFinal = dataFinal;
    }
}
