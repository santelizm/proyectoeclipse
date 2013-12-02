package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;



import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoRequisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEstadoRequisicionRepository extends
		JpaRepository<EstadoRequisicion, Integer> {

	public EstadoRequisicion findById(int id);
	
	public EstadoRequisicion findByNombre(String nombre);
	
	public List<EstadoRequisicion> findByNombreLike(String nombre);
	
	@Query("select er from EstadoRequisicion er where (upper(er.nombre) like upper(?1)) "
			+ "or (upper(er.descripcion) like upper(?1)) "
			+ "or (upper(er.status) like upper(?1))")
	public List<EstadoRequisicion> buscarPorX(String parametro);
}
