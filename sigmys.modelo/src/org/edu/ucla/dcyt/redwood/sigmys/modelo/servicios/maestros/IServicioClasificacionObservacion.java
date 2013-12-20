//editando santeliz propietario
package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ClasificacionObservacion;

import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioClasificacionObservacion")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioClasificacionObservacion extends IServicioGenerico<ClasificacionObservacion> {
	
	public ClasificacionObservacion buscarPorId(int id);
	public ClasificacionObservacion buscarPorNombre(String nombre);
	public List<ClasificacionObservacion> buscarPorStatus(String status);
	
}
