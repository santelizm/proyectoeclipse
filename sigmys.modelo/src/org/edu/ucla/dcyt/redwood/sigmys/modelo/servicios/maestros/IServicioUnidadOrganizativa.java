package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;


import com.sinergia.modelo.servicios.IServicioGenerico;
@WebService(name="servicioUnidadOrganizativa")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioUnidadOrganizativa extends IServicioGenerico<UnidadOrganizativa> {

	public UnidadOrganizativa buscarPorId(int id);

	public UnidadOrganizativa buscarPorNombre(String nombre);

	public List<UnidadOrganizativa> buscarPorNombreComo(String nombre);

	public List<UnidadOrganizativa> buscarPorDescripcionComo(String descripcion);

	public List<UnidadOrganizativa> buscarPorStatusComo(String status);
	
	public List<UnidadOrganizativa> buscarPorX(String parametro);
	
	public List<UnidadOrganizativa> buscarUnidadOrganizativaPorProyectoNulo();
	
}
