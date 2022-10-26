package com.gft.mvc.milhas.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AtividadesConcluidas {

    @Id
    @Column(name = "cod_evento")
    private Integer codEvento;

    @Column(name = "cod_participante")
    private Integer codParticipante;

    @Column(name = "data_evento")
    private Date dataEvento;

    public AtividadesConcluidas(Integer codEvento, Integer codParticipante, Date dataEvento) {
        this.codEvento = codEvento;
        this.codParticipante = codParticipante;
        this.dataEvento = dataEvento;
    }
}


