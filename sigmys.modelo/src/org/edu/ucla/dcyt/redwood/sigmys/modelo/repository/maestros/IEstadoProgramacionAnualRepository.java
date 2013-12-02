package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoProgramacionAnual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEstadoProgramacionAnualRepository extends	JpaRepository<EstadoProgramacionAnual, Integer> {
	
	public EstadoProgramacionAnual findById(int id);
	
	public List<EstadoProgramacionAnual> findByNombreLike(String nombre);
	
	public List<EstadoProgramacionAnual> findByDescripcionLike(String descripcion);
	
	public List<EstadoProgramacionAnual> findByStatusLike(String status);
	
	@Query("select epra from EstadoProgramacionAnual epra where (upper(epra.nombre) like upper(?1))")
	public List<EstadoProgramacionAnual> buscarPorX(String parametro);
	
}