package com.javasampleapproach.springrest.mysql.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.javasampleapproach.springrest.mysql.model.Zona;

public interface ZonaRepository extends CrudRepository<Zona, Long> {

	@Query(value = "	SELECT zona.* "
					+ "	FROM TONT_AVES AS zona"
					+ "	WHERE zona.cdzona = :cdzona ", nativeQuery = true)
	public abstract Zona findByCdZona(@Param("cdzona") String cdzona);

}
