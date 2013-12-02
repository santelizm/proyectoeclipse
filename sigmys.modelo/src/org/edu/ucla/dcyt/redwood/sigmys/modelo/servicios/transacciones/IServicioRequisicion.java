package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioRequisicion")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioRequisicion extends IServicioGenerico<Requisicion> {
	
	public Requisicion buscarRequisicionPorId(int id);
	
	public Requisicion buscarRequisicionPorNumero(String numero);
	
	public List<Requisicion> buscarRequisicionesPorObservacionesSimilares(String observacion);
	
	public List<Requisicion> buscarRequisicionesPorTipoRequisicion(TipoRequisicion tiporequisicion);
	
	public List<Requisicion> buscarRequisicionPorFechaEntre(Date fechaDesde, Date fechaHasta);
	
	public List<Requisicion> buscarRequisicionesPorEstadoRequisicion(EstadoRequisicion estadorequisicion);
	
	public List<Requisicion> buscarPorX(String parametro);
	
	public List<Requisicion> buscarPorStatus(String statuss);
	
	public List<Requisicion> buscarPorStatusNoIgualA(String status);
	
	public List<Requisicion> buscarTodosExceptoTotalmenteAprobada();
	  

}
