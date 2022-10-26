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
public class MarcarPresencas {

    @Id
    @Column(name = "cod_evento")
    private Integer codEvento;

    @Column(name = "cod_atividade")
    private Integer codAtividade;

    @Column(name = "cod_participante")
    private Integer codParticipante;

    @Column(name = "data_conclusao")
    private Date dataConclusao;

    public MarcarPresencas(Integer codEvento, Integer codAtividade, Integer codParticipante, Date dataConclusão) {
        this.codEvento = codEvento;
        this.codAtividade = codAtividade;
        this.codParticipante = codParticipante;
        this.dataConclusao = dataConclusao;
    }
}
