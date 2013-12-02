package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialOrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioMaterialOrdenEntrega")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioMaterialOrdenEntrega extends IServicioGenerico<MaterialOrdenEntrega> {
	public MaterialOrdenEntrega buscarPorId(int id);
	
	public List<MaterialOrdenEntrega> buscarPorOrdenentrega(OrdenEntrega ordenentrega);

	public List<MaterialOrdenEntrega> buscarPorMaterial(Material material);
	
	public List<MaterialOrdenEntrega> buscarPorCantidadentregada(int cantidadentregada);
}
