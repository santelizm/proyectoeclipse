package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoProgramacionAnual;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService (name="servicioEstadoProgramacionAnual")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioEstadoProgramacionAnual extends IServicioGenerico<EstadoProgramacionAnual>{
	
	public EstadoProgramacionAnual buscarEstadoProgramacionAnualPorId(int id);
	
	public List<EstadoProgramacionAnual> buscarEstadosProgramacionAnualPorNombre(String nombre);
	
	public List<EstadoProgramacionAnual> buscarEstadosProgramacionAnualPorDescripcion(String descripcion);
	
	public List<EstadoProgramacionAnual> buscarEstadosProgramacionAnualPorStatus(String status);
	
	public List<EstadoProgramacionAnual> buscarPorX(String parametro);
	
}
