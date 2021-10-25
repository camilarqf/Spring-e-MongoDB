package com.unidade4.atividade6.repository;

import com.unidade4.atividade6.model.Cidadao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadaoRepository extends MongoRepository<Cidadao, String> {

}
