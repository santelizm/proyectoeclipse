package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.OrigenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrigenCompraRepository extends	JpaRepository<OrigenCompra, Integer> {
	
	public OrigenCompra findById(int id);
	
	public List<OrigenCompra> findByNombreLike(String nombre);
	
	public List<OrigenCompra> findByDescripcionLike(String descripcion);
	
	public List<OrigenCompra> findByStatusLike(String status);
	
	@Query("select oc from OrigenCompra oc where (upper(oc.nombre) like upper(?1))")
	public List<OrigenCompra> buscarPorX(String parametro);
	
}
