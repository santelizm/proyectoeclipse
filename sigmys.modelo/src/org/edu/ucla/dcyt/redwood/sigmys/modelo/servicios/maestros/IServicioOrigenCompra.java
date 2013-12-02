package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.OrigenCompra;


import com.sinergia.modelo.servicios.IServicioGenerico;


@WebService(name="servicioOrigenCompra")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioOrigenCompra extends IServicioGenerico<OrigenCompra>{
	
	public OrigenCompra buscarServicioOrigenCompraPorId(int id);
	
	public List<OrigenCompra> buscarOrigenCompraPorNombre(String nombre);
	
	public List<OrigenCompra> buscarOrigenCompraPorDescripcion(String descripcion);
	
	public List<OrigenCompra> buscarOrigenCompraPorStatus(String status);
	
	public List<OrigenCompra> buscarPorX(String parametro);
	
}
