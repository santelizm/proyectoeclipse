package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IMaterialRepository extends JpaRepository<Material, Integer> {

	public Material findById(int id);
	
	public Material findByNombre(String nombre);
	
	public Material findByCodigo(String codigo);

	public List<Material> findByNombreLike(String nombre);
	
	public List<Material> findByDescripcionLike(String descripcion);

	public List<Material> findByStatusLike(String status);
	
	@Query("select m from Material m where (upper(m.nombre) like upper(?1)) "
			+ "or (upper(m.codigo) like upper(?1)) "
			+ "or (upper(m.descripcion) like upper(?1)) "
			+ "or (upper(m.medida.nombre) like upper(?1))"
			+ "or (upper(m.tipomaterial.nombre) like upper(?1))"
			+ "or (upper(m.status) like upper(?1))")
	public List<Material> buscarPorX(String parametro);

}
