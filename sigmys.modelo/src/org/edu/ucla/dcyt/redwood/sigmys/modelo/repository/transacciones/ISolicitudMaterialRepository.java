package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ISolicitudMaterialRepository extends
JpaRepository<SolicitudMaterial, Integer> {
	
	public SolicitudMaterial findById(int id);
	
	public SolicitudMaterial findByNumero(String numero);
	
	public List<SolicitudMaterial> findByFechaemision(Date fechaemision);
	
	public List<SolicitudMaterial>findByFechaemisionBetween(Date desde, Date hasta);

	//Habia creado estos metodos pero despues me puse a pensar y siempre tendra una fecha entre y hasta
	//De todas formas se pueden implementar luego
/*	@Query("select sol from SolicitudMaterial sol where sol.fechaemision>=?1")
	public List<SolicitudMaterial> buscarPorFechaEmisionDespues(Date fechaDespues);
	
	@Query("select sol from SolicitudMaterial sol where sol.fechaemision<=?1")
	public List<SolicitudMaterial> buscarPorFechaEmisionAntes (Date fechaAntes);
*/	
	public List<SolicitudMaterial> findByUnidadorganizativa(UnidadOrganizativa unidadorganizativa);
	
	public List<SolicitudMaterial> findByDestino(EspacioFisico destino);
	
	@Query("select sma from SolicitudMaterial sma where (upper(sma.unidadorganizativa.nombre) like upper(?1))"
			+ "or (upper(sma.destino.nombre) like upper(?1)) " +
			"or (upper(sma.numero) like upper(?1)) " +
			"or (upper(to_char(sma.fechaemision, 'dd/mm/yyy')) like upper(?1)) ")
	public List<SolicitudMaterial> buscarPorX(String parametro);
	 
	public List<SolicitudMaterial> findByStatus(String status);
	
	@Query("select sol from SolicitudMaterial sol where sol.fechaemision<=?1 and sol.status='E'")
	public List<SolicitudMaterial> buscarPorFechaHasta (Date fechahasta);
	
	
	
	
	
	 
	 

}
