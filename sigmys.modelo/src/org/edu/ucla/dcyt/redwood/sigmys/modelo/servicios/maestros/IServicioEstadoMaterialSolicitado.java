package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

/*
 Creacion de Servicio EstadoMaterialSolicitado
 Autor: Greg y Mariangel
 Fecha: 18/12/2012 5pm;
 */

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioEstadoMaterialSolicitado")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioEstadoMaterialSolicitado extends
		IServicioGenerico<EstadoMaterialSolicitado> {

	public EstadoMaterialSolicitado buscarPorId(int id);

	public EstadoMaterialSolicitado buscarPorNombre(String nombre);

	public List<EstadoMaterialSolicitado> buscarPorNombreComo(String nombre);
	
	public List<EstadoMaterialSolicitado> buscarPorX(String parametro);

}
