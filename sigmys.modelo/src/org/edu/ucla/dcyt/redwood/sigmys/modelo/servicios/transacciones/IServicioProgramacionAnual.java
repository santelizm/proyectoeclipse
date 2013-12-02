package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProgramacionAnual;


import com.sinergia.modelo.servicios.IServicioGenerico;
@WebService(name="servicioProgramacionAnual")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioProgramacionAnual extends IServicioGenerico<ProgramacionAnual> {

	public ProgramacionAnual buscarPorIdProgramacion(int id);
	public List<ProgramacionAnual> buscarProgramacionPorEstado(EstadoProgramacionAnual estadoprogramacionanual);
	public ProgramacionAnual buscarProgramacionStatus(String status);
	public ProgramacionAnual buscarPorAno(String ano);
	public List<ProgramacionAnual> buscarPorX(String parametro);
	public List<ProgramacionAnual> buscarOrdenadoPorAnno();

}
