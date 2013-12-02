package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioEntregaMaterial")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioOrdenEntrega extends IServicioGenerico<OrdenEntrega>{

	public OrdenEntrega buscarOrdenEntregaPorId(int id);
	public List<OrdenEntrega> buscarOrdenEntregaPorFecha(Date fecha);
	public List<OrdenEntrega> buscarOrdenEntregaPorStatus(String status);
	public List<OrdenEntrega> buscarPorX(String parametro);
	public List<OrdenEntrega> buscarOrdenEntregaPorFechaEntre(Date fechaDesde, Date fechaHasta);
	
	
}
