package com.br.adivinhacao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.adivinhacao.model.VencedorModel;
@Repository
public interface VencedorRepository extends  CrudRepository<VencedorModel, Integer> {

}
