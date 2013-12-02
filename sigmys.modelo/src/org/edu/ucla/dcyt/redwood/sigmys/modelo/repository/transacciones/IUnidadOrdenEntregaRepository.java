package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.UnidadOrdenEntrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUnidadOrdenEntregaRepository extends
		JpaRepository<UnidadOrdenEntrega, Integer> {
	public UnidadOrdenEntrega findById(int id);
	
	public List<UnidadOrdenEntrega> findByUnidadorganizativa(UnidadOrganizativa unidadorganizativa);
	
	public List<UnidadOrdenEntrega> findByOrdenentrega(OrdenEntrega ordenentrega);
	
	public List<UnidadOrdenEntrega> findByDestino(EspacioFisico destino);
}
