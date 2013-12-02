package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEstadoMaterialRequeridoRepository extends	JpaRepository<EstadoMaterialRequerido, Integer> {
	
	public EstadoMaterialRequerido findById(int id);
	
	public List<EstadoMaterialRequerido> findByNombreLike(String nombre);
	
	public List<EstadoMaterialRequerido> findByDescripcionLike(String descripcion);
	
	public List<EstadoMaterialRequerido> findByStatusLike(String status);

	@Query("select emr from EstadoMaterialRequerido emr where (upper(emr.nombre) like upper(?1)) " +
														  "or (upper(emr.descripcion) like upper(?1))")
	public List<EstadoMaterialRequerido> buscarPorX(String parametro);
}
