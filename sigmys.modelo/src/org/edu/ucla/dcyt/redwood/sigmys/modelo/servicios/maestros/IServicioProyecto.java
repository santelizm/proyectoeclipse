package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proyecto;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioProyecto")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioProyecto extends IServicioGenerico<Proyecto>{
	
	public Proyecto buscarProyectoPorNombre (String nombre);
	public List<Proyecto> buscarProyectosPorNombre(String nombre);	
	public List<Proyecto> buscarPorX(String parametro);

}
