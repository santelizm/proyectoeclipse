package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRequisiconRepository extends	JpaRepository<Requisicion, Integer> {
	
	public Requisicion findById(int id);
	
	public Requisicion findByNumero(String numero);
	
	public List<Requisicion> findByObservacionLike(String observacion);
	
	public List<Requisicion> findByTiporequisicion(TipoRequisicion tiporequisicion);
	
	public List<Requisicion> findByEstadorequisicion(EstadoRequisicion estadorequisicion);

	@Query("select r from Requisicion r where (upper(r.numero) like upper(?1)) "  +
										  "or (upper(r.estadorequisicion.nombre) like upper(?1)) " +
										  "or (upper(to_char(r.fecha, 'dd/mm/yyy')) like upper(?1))  ") 
	public List<Requisicion> buscarPorX(String parametro);
	
	public List<Requisicion> findByStatus(String status);
	
	public List<Requisicion> findByStatusNotLike(String status);
	
	public List<Requisicion> findByFechaBetween(Date desde, Date hasta);
		
	public List<Requisicion> findByFecha(Date fecha);
	
	@Query("select r from Requisicion r where r.fecha>=?1")
	public List<Requisicion> buscarPorFechaDespues(Date fecha);

	@Query("select r from Requisicion r where r.fecha<=?1")
	public List<Requisicion> buscarPorFechaAntes(Date fecha);
	
	@Query ("select r from Requisicion r where r.status='R' or r.status='F'")
	public List<Requisicion> buscarPorStatusRoF();
	
	@Query("select r from Requisicion r where r.fecha<=?1 and r.status='F'")
	public List<Requisicion> buscarPorFechaHasta(Date fechahasta);
			
}
