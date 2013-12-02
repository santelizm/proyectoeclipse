package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.DetalleUnidadEntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioDetalleUnidadEntregaEventual")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioDetalleUnidadEntregaEventual extends IServicioGenerico<DetalleUnidadEntregaEventual>{
	
	public DetalleUnidadEntregaEventual buscarPorId(int id);
	
	public List<DetalleUnidadEntregaEventual> buscarPorUnidadOrganizativa(UnidadOrganizativa unidadorganizativa);
	
	public List<DetalleUnidadEntregaEventual> buscarPorDestino(EspacioFisico destino);
	
	public List<DetalleUnidadEntregaEventual> buscarPorEntregaEventual(EntregaEventual entregaeventual);
	
}
