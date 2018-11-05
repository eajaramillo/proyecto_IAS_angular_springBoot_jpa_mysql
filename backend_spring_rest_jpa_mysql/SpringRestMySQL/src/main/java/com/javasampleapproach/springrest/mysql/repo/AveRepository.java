package com.javasampleapproach.springrest.mysql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.javasampleapproach.springrest.mysql.model.Ave;

public interface AveRepository extends CrudRepository<Ave, Long> {
	//List<Customer> findAvesbyZona(int age);
	//	@Query("Select t.dsnombre_comun From tont_aves t Where t.dsnombre_comun like ||'%',?1,'%' "
	//	+ "or dsnombre_cientifico like || '%',?1,'%'") 
	@Query(value = "	SELECT aves.* "
					+ "	FROM TONT_AVES AS aves"
					+ "	INNER JOIN"
					+ "	TONT_AVES_PAIS AS avepais ON (aves.cdave = avepais.cdpais)"
					+ " INNER JOIN TONT_PAISES AS paises ON (paises.cdpais = avepais.cdpais)"
					+ "	INNER JOIN TONT_ZONAS AS zonas ON (zonas.cdzona = paises.cdzona AND zonas.cdzona = :zona)"
					+ "	WHERE aves.dsnombre_comun LIKE  %:nombre% OR aves.dsnombre_cientifico LIKE %:nombre%", nativeQuery = true)
	public abstract List<Ave> findAveByNombreAndZona(@Param("nombre") String nombre, @Param("zona") String zona);

	@Query(value = "	SELECT aves.* "
					+ "	FROM TONT_AVES AS aves"
					+ "	INNER JOIN"
					+ "	TONT_AVES_PAIS AS avepais ON (aves.cdave = avepais.cdpais)"
					+ " INNER JOIN TONT_PAISES AS paises ON (paises.cdpais = avepais.cdpais)"
					+ "	INNER JOIN TONT_ZONAS AS zonas ON (zonas.cdzona = paises.cdzona)"
					+ "	WHERE aves.cdave = :cdave ", nativeQuery = true)
	public abstract Ave findByCdAve(@Param("cdave") String cdave);

	@Query(value = "Select a.cdave, a.dsnombre_comun, a.dsnombre_cientifico "
		+ "From tont_aves a inner join tont_aves_pais ap on a.cdave = ap.cdave "
		+ "inner join tont_paises p on ap.cdpais = p.cdpais "
		+ "inner join tont_zonas z on p.cdzona = z.cdzona "
		+ "Where z.cdzona = :zona", nativeQuery = true)
	public List<Ave> findAvesbyZona(@Param("zona") String zona);
	
	@Query(value = "delete From tont_aves_pais where cdave = :cdave", nativeQuery = true)
	public void deleteRelationByCdAve(@Param("cdave") String cdave);
	

	@Query(value = "delete From tont_aves_pais where cdave = :cdave", nativeQuery = true)
	public void deleteByCdAve(@Param("cdave") String cdave);
}