package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProveedor extends JpaRepository<Proveedor, String> {

	public Proveedor findById(int id);
	
	public List<Proveedor> findByNombreLike(String nombre); 
	
	public List<Proveedor> findByDescripcionLike(String descripcion);
	
	public List<Proveedor> findByDireccionLike(String direccion);
	
	public List<Proveedor> findByStatusLike(String status);

}
