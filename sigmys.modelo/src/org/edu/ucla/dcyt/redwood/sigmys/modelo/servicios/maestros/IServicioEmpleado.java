package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Empleado;


import com.sinergia.modelo.data.seguridad.Usuario;
import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioEmpleado")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioEmpleado extends IServicioGenerico<Empleado> {

	public Empleado buscarEmpleadoPorId(int id);

	public Empleado buscarEmpleadoPorUsuario(Usuario usuario);

	public List<Empleado> buscarEmpleadoPorStatusLike(String status);

	public List<Empleado> buscarPorX(String parametro);

}
