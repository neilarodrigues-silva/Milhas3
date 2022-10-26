package com.gft.mvc.milhas.repositories;

import com.gft.mvc.milhas.entities.Evento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends CrudRepository<Evento, Integer> {
}
