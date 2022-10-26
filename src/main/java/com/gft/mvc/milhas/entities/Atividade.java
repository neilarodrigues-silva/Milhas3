package com.gft.mvc.milhas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cod;

    @Column
    private String nome;

    @Column(name = "data_de_inicio")
    private Date dataDeInicio;

    @Column(name = "data_de_entrega")
    private Date dataDeEntrega;

    @Column(name = "cod_evento")
    private Integer codEvento;

    public Atividade(String nome, Date dataDeInicio, Date dataDeEntrega, Integer codEvento) {
        this.nome = nome;
        this.dataDeInicio = dataDeInicio;
        this.dataDeEntrega = dataDeEntrega;
        this.codEvento = codEvento;
    }
}
