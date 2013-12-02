package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioMaterial")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioMaterial extends IServicioGenerico<Material> {

	public Material buscarPorId(int id);

	public Material buscarPorNombre(String nombre);
	
	public Material buscarPorCodigo(String codigo);

	public List<Material> buscarPorNombreComo(String nombre);

	public List<Material> buscarPorDescripcionComo(String descripcion);

	public List<Material> buscarPorStatusComo(String status);
	
	public List<Material> buscarPorX(String parametro);
}
