package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ObservacionEntrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEntregaEventualRepository extends
		JpaRepository<EntregaEventual, Integer> {

	public EntregaEventual findById(int id);
	
	public List<EntregaEventual> findByFecha(Date fecha);
	
	public List<EntregaEventual> findByStatus(String status);
	
	public List<EntregaEventual> findByFechaBetween(Date desde, Date hasta);
	
	@Query("select ee from EntregaEventual ee where " +
	   "(upper(ee.motivo) like upper(?1)) ")
	public List<EntregaEventual> buscarPorX(String parametro);
	
}
