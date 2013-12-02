package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Motivo;
import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioMotivo")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioMotivo extends IServicioGenerico<Motivo> {
	
	public Motivo BuscarPorId(int id);
	
	public List<Motivo> buscarMotivoPorNombre(String nombre); 
	
	public List<Motivo> buscarMotivoPorDescripcion(String descripcion);
	
	public List<Motivo> buscarMotivoPorStatus(String status);

}
