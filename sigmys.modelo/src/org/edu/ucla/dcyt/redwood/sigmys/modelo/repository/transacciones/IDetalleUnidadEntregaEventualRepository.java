package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.DetalleUnidadEntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleUnidadEntregaEventualRepository extends
		JpaRepository<DetalleUnidadEntregaEventual, Integer> {
	
	public DetalleUnidadEntregaEventual findById(int id);
	
	public List<DetalleUnidadEntregaEventual> findByUnidadorganizativa(UnidadOrganizativa unidadorganizativa);
	
	public List<DetalleUnidadEntregaEventual> findByDestino(EspacioFisico destino);
	
	public List<DetalleUnidadEntregaEventual> findByEntregaeventual(EntregaEventual entregaeventual);
}
