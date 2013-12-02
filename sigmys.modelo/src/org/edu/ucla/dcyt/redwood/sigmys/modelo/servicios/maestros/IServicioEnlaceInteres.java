package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EnlaceInteres;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioEnlaceInteres")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioEnlaceInteres extends
		IServicioGenerico<EnlaceInteres> {

	public EnlaceInteres buscarEnlaceInteresPorId(int id);

	public EnlaceInteres buscarEnlaceInteresPorLinkenlace(
			String linkenlace);

	public List<EnlaceInteres> buscarEnlaceInteresPorUnidadOrganizativa(
			UnidadOrganizativa unidadOrganizativa);

	public List<EnlaceInteres> buscarEnlaceInteresPorStatus(String status);

	public List<EnlaceInteres> buscarPorX(String parametro);
	
	public List<EnlaceInteres> buscarEnlacesOrdenados();
	
}