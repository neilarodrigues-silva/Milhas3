package com.gft.mvc.milhas.repositories;

import com.gft.mvc.milhas.entities.MarcarPresencas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresencasRepository extends CrudRepository<MarcarPresencas, Integer> {
}
