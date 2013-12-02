package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ReferenciaObservacion;
import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioReferenciaObservacion")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioReferenciaObservacion extends IServicioGenerico<ReferenciaObservacion>{

	public ReferenciaObservacion buscarReferenciaPorId(int id);

	public ReferenciaObservacion buscarReferenciaPorNombre(String nombre);

	public List<ReferenciaObservacion> buscarReferenciaPorStatus(String status);
}
