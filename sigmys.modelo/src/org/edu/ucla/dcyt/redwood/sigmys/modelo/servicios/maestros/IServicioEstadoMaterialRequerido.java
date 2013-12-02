package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioEstadoMaterialRequerido")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioEstadoMaterialRequerido extends IServicioGenerico<EstadoMaterialRequerido>{
	
	public EstadoMaterialRequerido buscarEstadoMaterialRequeridoPorId(int id);
	
	public List<EstadoMaterialRequerido> buscarEstadosMaterialRequeridoPorNombre(String nombre);
	
	public List<EstadoMaterialRequerido> buscarEstadosMaterialRequeridoPorDescripcion(String descripcion);
	
	public List<EstadoMaterialRequerido> buscarEstadosMaterialRequeridoPorStatus(String status);
	
	public List<EstadoMaterialRequerido> buscarPorX(String parametro);
}
