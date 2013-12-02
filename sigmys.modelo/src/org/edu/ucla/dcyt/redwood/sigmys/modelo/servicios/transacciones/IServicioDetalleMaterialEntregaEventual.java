package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.DetalleMaterialEntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioDetalleMaterialEntregaEventual")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioDetalleMaterialEntregaEventual extends
		IServicioGenerico<DetalleMaterialEntregaEventual> {
	
	public DetalleMaterialEntregaEventual buscarPorId(int id);

	public List<DetalleMaterialEntregaEventual> buscarPorEntregaEventual(EntregaEventual entregaeventual);
	
	public List<DetalleMaterialEntregaEventual> buscarPorMaterial(Material material);

	public List<DetalleMaterialEntregaEventual> buscarPorCantidad(int cantidad);
}
