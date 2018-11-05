package com.javasampleapproach.springrest.mysql.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javasampleapproach.springrest.mysql.model.Pais;
import com.javasampleapproach.springrest.mysql.model.Zona;

public interface PaisRepository extends CrudRepository<Pais, Long> {

}
