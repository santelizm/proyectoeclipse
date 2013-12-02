package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProveedorRepository extends JpaRepository<Proveedor, String> {

	public Proveedor findById(int id);
	
	public List<Proveedor> findByNombreLike(String nombre); 
	
	public List<Proveedor> findByDescripcionLike(String descripcion);
	
	public List<Proveedor> findByDireccionLike(String direccion);
	
	public List<Proveedor> findByStatusLike(String status);
	
	@Query("select p from Proveedor p where (upper(p.nombre) like upper(?1))")
	public List<Proveedor> buscarPorX(String parametro);

}
