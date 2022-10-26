package com.gft.mvc.milhas.repositories;

import com.gft.mvc.milhas.entities.Atividade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade, Integer> {
    List<Atividade> findAllByCodEventoEquals(Integer codEvento);
}
