package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoObservacion;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioTipoObservacion")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioTipoObservacion extends IServicioGenerico<TipoObservacion> {
	
	public TipoObservacion buscarTipoObservacionPorNombre(String nombre);
	
	public TipoObservacion buscarTipoObservacionPorId(int id);
	
	public List<TipoObservacion> buscarTipoObservacionesPorNombre(String nombre);
	
	public List<TipoObservacion> buscarTipoObservacionPorStatus(String status);
	
	public List<TipoObservacion> buscarPorX(String parametro);
	
}
