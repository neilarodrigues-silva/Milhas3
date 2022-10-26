package com.gft.mvc.milhas.repositories;

import com.gft.mvc.milhas.entities.Atividade;
import com.gft.mvc.milhas.entities.Participante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {

    List<Participante> findAllByCodEventoEquals(Integer codEvento);
}
