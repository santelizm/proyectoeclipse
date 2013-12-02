package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;



import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoRequisicion;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService (name="servicioEstadoRequisicion")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)

public interface IServicioEstadoRequisicion extends IServicioGenerico<EstadoRequisicion>{
	
	
	public EstadoRequisicion buscarEstadoRequisicionPorId(int id);
	
	public EstadoRequisicion buscarEstadoRequisicionPorNombre(String nombre);
	
	public List<EstadoRequisicion> buscarEstadoRequisiconPorNombreComo(String nombre);

	public List<EstadoRequisicion> buscarPorX(String parametro);
}
