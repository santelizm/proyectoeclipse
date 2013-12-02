package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proyecto;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProyectoProgramacionAnual;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioProyectoProgramacionAnual")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioProyectoProgramacionAnual extends
		IServicioGenerico<ProyectoProgramacionAnual> {

	public ProyectoProgramacionAnual buscarPorId(int id);
	
	public ProyectoProgramacionAnual buscarPorCodigoopsu(String codigoopsu);
	
	public List<ProyectoProgramacionAnual> buscarPorProyecto(Proyecto proyecto);
	
	public List<ProyectoProgramacionAnual> buscarPorProyectoAndProgramacionanual(Proyecto proyecto, ProgramacionAnual programacionanual);
	
	public List<ProyectoProgramacionAnual> buscarPorProgramacionanual(ProgramacionAnual programacionanual);
	
}
