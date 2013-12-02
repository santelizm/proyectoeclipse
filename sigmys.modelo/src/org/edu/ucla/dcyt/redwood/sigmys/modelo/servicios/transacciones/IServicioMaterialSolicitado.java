package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;


import com.sinergia.modelo.servicios.IServicioGenerico;


@WebService(name="servicioMaterialSolicitado")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioMaterialSolicitado extends
		IServicioGenerico<MaterialSolicitado> {
	
	public List<MaterialSolicitado> buscarPorMaterialComo(Material material);
	public List<MaterialSolicitado> buscarPorSolicitudMaterialComo(SolicitudMaterial solicitud);
	public List<MaterialSolicitado> buscarPorEstadoMaterialSolicitadoComo(EstadoMaterialSolicitado estadoMaterialSolicitado);

}
