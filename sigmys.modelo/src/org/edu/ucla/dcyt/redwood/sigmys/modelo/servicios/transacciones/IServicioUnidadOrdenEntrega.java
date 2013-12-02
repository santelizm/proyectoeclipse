package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.UnidadOrdenEntrega;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioUnidadOrdenEntrega")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioUnidadOrdenEntrega extends
		IServicioGenerico<UnidadOrdenEntrega> {
	public UnidadOrdenEntrega buscarPorId(int id);
	
	public List<UnidadOrdenEntrega> buscarPorUnidadorganizativa(UnidadOrganizativa unidadorganizativa);
	
	public List<UnidadOrdenEntrega> buscarPorOrdenentrega(OrdenEntrega ordenentrega);
	
	public List<UnidadOrdenEntrega> buscarPorDestino(EspacioFisico destino);
}
