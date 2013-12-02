package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUnidadOrganizativaRepository extends
		JpaRepository<UnidadOrganizativa, Integer> {

	public UnidadOrganizativa findById(int id);

	public UnidadOrganizativa findByNombre(String nombre);

	public List<UnidadOrganizativa> findByNombreLike(String nombre);

	public List<UnidadOrganizativa> findByDescripcionLike(String descripcion);

	public List<UnidadOrganizativa> findByStatusLike(String status);
	
	public List<UnidadOrganizativa> findByProyectoIsNull();


	@Query("select u from UnidadOrganizativa u where (upper(u.nombre) like upper(?1)) "
			+ "or (upper(u.descripcion) like upper(?1)) "
			+ "or (upper(u.proyecto.nombre) like upper(?1))"
			+ "or (upper(u.status) like upper(?1))")
	public List<UnidadOrganizativa> buscarPorX(String parametro);
}
