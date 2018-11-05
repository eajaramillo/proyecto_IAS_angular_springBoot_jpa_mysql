package com.javasampleapproach.springrest.mysql.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javasampleapproach.springrest.mysql.model.Pais;
import com.javasampleapproach.springrest.mysql.model.Zona;
import com.javasampleapproach.springrest.mysql.model.AvesPaises;

public interface AvesPaisesRepository extends CrudRepository<AvesPaises, Long>  {

}
