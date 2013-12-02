package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITipoMaterialRepository extends
		JpaRepository<TipoMaterial, String> {

	public TipoMaterial findByNombre(String nombre);

	public List<TipoMaterial> findByNombreLike(String nombre);

	@Query("select tm from TipoMaterial tm where (upper(tm.nombre) like upper(?1)) ")
	public List<TipoMaterial> buscarPorX(String parametro);

}
