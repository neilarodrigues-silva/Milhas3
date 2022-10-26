package com.gft.mvc.milhas.repositories;

import com.gft.mvc.milhas.entities.AtividadesConcluidas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadesConcluidasRepository extends CrudRepository<AtividadesConcluidas, Integer> {

}
