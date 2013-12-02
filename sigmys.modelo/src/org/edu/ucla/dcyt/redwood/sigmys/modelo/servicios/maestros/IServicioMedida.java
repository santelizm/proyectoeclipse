package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Medida;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioMedida")


@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)


public interface IServicioMedida extends IServicioGenerico<Medida>{


	public Medida BuscarMedidaPorId(int id);
	
	public Medida BuscarMedidaPorNombre(String nombre);
	
	public List<Medida> BuscarMedidasPorNombre(String nombre);
	
	public List<Medida> buscarPorX(String parametro);
	
	 
}
