package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;


import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ClasificacionObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ObservacionEntrega;


import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ReferenciaObservacion;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioObservacionEntrega")

@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)

public interface IServicioObservacionEntrega extends IServicioGenerico<ObservacionEntrega> {

	
	public ObservacionEntrega buscarPorId(int id);
	public List<ObservacionEntrega> buscarPorTipoobservacioncomo(TipoObservacion tipoobservacion);
	public List<ObservacionEntrega> buscarPorUnidadorganizativacomo(UnidadOrganizativa unidadorganizativa);
	public List<ObservacionEntrega> buscarPorReferenciaObservacioncomo(ReferenciaObservacion referenciaobservacion);
	public List<ObservacionEntrega> buscarPorClasificacionObservacioncomo (ClasificacionObservacion clasificacionobservacion);
	public List<ObservacionEntrega> buscarPorStatus(String status);
	public List<ObservacionEntrega> buscarPorClasificacionYStatus (ClasificacionObservacion clasificacionobservacion, String status);
	public List<ObservacionEntrega> buscarPorX(String parametro);
	public List<ObservacionEntrega> buscarPorFechaEntre(Date desde, Date hasta);
	
	


}//Fin de la clase
