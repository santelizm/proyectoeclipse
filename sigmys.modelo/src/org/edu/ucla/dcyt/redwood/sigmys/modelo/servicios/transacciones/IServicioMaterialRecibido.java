package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRecibido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioMaterialRecibido")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioMaterialRecibido extends IServicioGenerico<MaterialRecibido> {

	public MaterialRecibido buscarMaterialRecibidoPorId(int id);
	public List<MaterialRecibido> buscarMaterialRecibidoPorOrdenDeServicio(OrdenServicio ordendeservicio);
	public List<MaterialRecibido> buscarMaterialRecibidoPorMaterial(int material);
	public List<MaterialRecibido> buscarMaterialRecibidoPorCantidad (int cantidad);
	public List<MaterialRecibido> buscarPorX(String parametro);
	
}
