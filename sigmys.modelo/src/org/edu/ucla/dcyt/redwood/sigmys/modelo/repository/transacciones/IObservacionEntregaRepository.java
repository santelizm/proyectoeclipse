package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ClasificacionObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ReferenciaObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ObservacionEntrega;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IObservacionEntregaRepository extends JpaRepository<ObservacionEntrega,Integer> {

	public ObservacionEntrega findById(int id);

	public List<ObservacionEntrega> findByTipoobservacion(TipoObservacion tipoobservacion);
	
	public List<ObservacionEntrega> findByUnidadorganizativa(UnidadOrganizativa unidadorganizativa);
	
	public List<ObservacionEntrega> findByReferenciaobservacion(ReferenciaObservacion referenciaobservacion);
	
	public List<ObservacionEntrega> findByClasificacionobservacion (ClasificacionObservacion clasificacionobservacion);
	
	public List<ObservacionEntrega> findByFecha(Date Fecha);
	
	public List<ObservacionEntrega> findByClasificacionobservacionAndStatus (ClasificacionObservacion clasificacionobservacion, String status);

	
	public List<ObservacionEntrega> findByStatus(String status);
	
	@Query("select ob from ObservacionEntrega ob where (upper(ob.clasificacionobservacion.nombre) like upper(?1)) " +
	  												"or (upper(ob.unidadorganizativa.nombre) like upper(?1)) " +
	  												"or (upper(ob.tipoobservacion.nombre) like upper(?1)) " +
	  												"or (upper(to_char(ob.fecha, 'dd/mm/yyy')) like upper(?1)) " +
	  												"or (upper(ob.referenciaobservacion.nombre) like upper(?1)) ")
	  		
	 public List<ObservacionEntrega> buscarPorX (String parametro);
	
    public List<ObservacionEntrega> findByFechaBetween(Date desde, Date hasta);
	
	@Query("select os from ObservacionEntrega os where os.fecha<=?1")
	public List<ObservacionEntrega> buscarPorFechaHasta(Date fecha);

	@Query("select os from ObservacionEntrega os where os.fecha>=?1")
	public List<ObservacionEntrega> buscarPorFechaDesde(Date fecha);

    
	
}