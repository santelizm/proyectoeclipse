package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proveedor;
import com.sinergia.modelo.servicios.IServicioGenerico;


@WebService(name = "servicioProveedor")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioProveedor extends IServicioGenerico<Proveedor>{

	public Proveedor BuscarPorId(int id);
	
	public List<Proveedor> buscarProveedorPorNombre(String nombre); 
	
	public List<Proveedor> buscarProveedorPorDescripcion(String descripcion);
	
	public List<Proveedor> buscarProveedorPorDireccion(String direccion);
	
	public List<Proveedor> buscarProveedorPorStatus(String status);
	
	public List<Proveedor> buscarPorX(String parametro);

}
