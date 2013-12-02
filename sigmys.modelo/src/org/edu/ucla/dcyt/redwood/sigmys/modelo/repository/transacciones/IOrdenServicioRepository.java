package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.OrigenCompra;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrdenServicioRepository extends
		JpaRepository<OrdenServicio, Integer> {

	public OrdenServicio findById(int id);

	public OrdenServicio findByDescripcion(String descripcion);

	public OrdenServicio findByFecha(Date fecha);

	public OrdenServicio findByNumerocompromiso(String numerocompromiso);

	public OrdenServicio findByStatus(String Status);

	public List<OrdenServicio> findByDescripcionLike(String descripcion);

	public List<OrdenServicio> findByOrigencompra(OrigenCompra origencompra);

	@Query("select ef from OrdenServicio ef where (upper(ef.descripcion) like upper(?1)) "
			+ "or (upper(ef.origencompra.nombre) like upper(?1)) ")
	public List<OrdenServicio> buscarPorX(String parametro);

	public List<OrdenServicio> findByFechaBetween(Date desde, Date hasta);
	
	@Query("select os from OrdenServicio os where os.fecha<=?1")
	public List<OrdenServicio> buscarPorFechaHasta(Date fecha);

	@Query("select os from OrdenServicio os where os.fecha>=?1")
	public List<OrdenServicio> buscarPorFechaDesde(Date fecha);

    public OrdenServicio findByNumero(String numero);
    
    @Query("select os from OrdenServicio os where os.fecha<=?1 and os.status='A'")
	public List<OrdenServicio> buscarPorFechaHastaYStatus(Date fechahasta);

}
