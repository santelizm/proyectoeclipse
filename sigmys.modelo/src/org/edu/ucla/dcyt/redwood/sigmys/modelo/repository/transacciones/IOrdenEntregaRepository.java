package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrdenEntregaRepository extends
		JpaRepository<OrdenEntrega, Integer> {

	public OrdenEntrega findById(int id);

	public List<OrdenEntrega> findByFecha(Date fecha);

	public List<OrdenEntrega> findByStatus(String status);

	@Query("select em from OrdenEntrega em where (upper(em.numero) like upper(?1)) " +
	  												"or (upper(to_char(em.fecha, 'dd/mm/yyy')) like upper(?1)) ")  		
	public List<OrdenEntrega> buscarPorX(String parametro);

	public List<OrdenEntrega> findByFechaBetween(Date desde, Date hasta);

	@Query("select em from OrdenEntrega em where em.fecha<=?1 and em.status='B'") 		
	public List<OrdenEntrega> buscarPorFechaHasta(Date fechahasta);
	
}
