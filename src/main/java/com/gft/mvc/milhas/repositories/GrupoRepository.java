package com.gft.mvc.milhas.repositories;

import com.gft.mvc.milhas.entities.Grupo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends CrudRepository<Grupo, Integer> {
    List<Grupo> findAllByCodEventoEquals(Integer codEvento);
}
