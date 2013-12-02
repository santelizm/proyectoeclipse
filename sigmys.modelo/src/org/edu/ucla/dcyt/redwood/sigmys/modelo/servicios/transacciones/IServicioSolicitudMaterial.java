package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;


import com.sinergia.modelo.servicios.IServicioGenerico;


@WebService(name="servicioSolicitudMaterial")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)

public interface IServicioSolicitudMaterial extends IServicioGenerico<SolicitudMaterial> {
    
	public SolicitudMaterial buscarSolicitudMaterialPorId(int id);
	
	public SolicitudMaterial buscarSolicitudMaterialPorNumero(String numero);
	
	public List<SolicitudMaterial> buscarSolicitudMaterialPorFechaemision(Date fechaemision);
	
	public List<SolicitudMaterial> buscarSolicitudMaterialPorFechaemisionEntre(Date fechaDesde, Date fechaHasta);
	
	//La explicacion de porque comente esto esta en el repository de SolicitudMaterial
	/*public List<SolicitudMaterial> buscarPorFechaEmisionAntes (Date fechaAntes);
	
	public List<SolicitudMaterial> buscarPorFechaEmisionDespues(Date fechaDespues);
	*/
	public List<SolicitudMaterial> buscarSolicitudMaterialPorUnidadorganizativa(UnidadOrganizativa unidadorganizativa);
	
	public List<SolicitudMaterial> buscarSolicitudMaterialPorDestino(EspacioFisico destino);
	
	public List<SolicitudMaterial> buscarPorX(String parametro);
	
	public List<SolicitudMaterial> buscarPorStatus(String status);
	
	public List<SolicitudMaterial> buscarPorSolicitudPendiente();
	
	public List<SolicitudMaterial> buscarPorSolicitudNoProcesado();
	

}
