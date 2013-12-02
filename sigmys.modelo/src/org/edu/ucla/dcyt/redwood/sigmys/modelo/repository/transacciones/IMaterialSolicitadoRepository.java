package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMaterialSolicitadoRepository extends
		JpaRepository<MaterialSolicitado, Integer> {
	
	public List<MaterialSolicitado> findByMaterial(Material material);
	public List<MaterialSolicitado> findBySolicitudMaterial(SolicitudMaterial solicitud);
	public List<MaterialSolicitado> findByEstadoMaterialSolicitado(EstadoMaterialSolicitado estadoMaterialSolicitado);
	
	@Query("select ms from MaterialSolicitado ms where "
			+ " (upper(ms.material.nombre) like upper(?1)) "
			+ " or (upper(ms.estadoMaterialSolicitado.nombre) like upper(?1)) ")
	public List<MaterialSolicitado> buscarPorX(String parametro);

}
