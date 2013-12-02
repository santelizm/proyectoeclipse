package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EnlaceInteres;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEnlaceInteresRepository extends
		JpaRepository<EnlaceInteres, Integer> {

	public EnlaceInteres findById(int id);

	public EnlaceInteres findByLinkenlace(String linkenlace);

	public List<EnlaceInteres> findByUnidadorganizativa(
			UnidadOrganizativa unidadorganizativa);

	public List<EnlaceInteres> findByStatus(String status);

	@Query("select ei from EnlaceInteres ei where (upper(ei.linkenlace) like upper(?1)) "
			+ "or (upper(ei.status) like upper(?1)) "
			+ "or (upper(ei.unidadorganizativa.nombre) like upper(?1))")
	public List<EnlaceInteres> buscarPorX(String parametro);

	@Query("SELECT ei FROM EnlaceInteres ei ORDER BY ei.id DESC LIMIT 3")
	public List<EnlaceInteres> buscarEnlacesOrdenados();
}
