package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioEspacioFisico")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioEspacioFisico extends IServicioGenerico<EspacioFisico>{ 

	public EspacioFisico buscarEspacioFisicoPorId(int id);
	
	public EspacioFisico buscarEspacioFisicoPorNombre(String nombre);
	
	public List<EspacioFisico> buscarEspacioFisicoPorModulo(String modulo);
	
	
	public List<EspacioFisico> buscarEspacioFisicoPorStatus(String status);
	
	public List<EspacioFisico> buscarPorX(String parametro);
}
