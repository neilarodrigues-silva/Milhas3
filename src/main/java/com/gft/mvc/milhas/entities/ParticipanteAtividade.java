package com.gft.mvc.milhas.entities;

import com.gft.mvc.milhas.controllers.AtividadesController;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class ParticipanteAtividade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Integer codEvento;

    @Column
    private Integer codGrupo;

    @Column(name = "participante_id")
    private Integer participanteId;

    @Column(name = "atividade_id")
    private Integer atividadeId;
}
