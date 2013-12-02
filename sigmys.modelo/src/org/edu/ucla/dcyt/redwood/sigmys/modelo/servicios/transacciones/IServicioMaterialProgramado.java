package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialProgramado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProyectoProgramacionAnual;

import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioMaterialProgramado")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioMaterialProgramado extends
		IServicioGenerico<MaterialProgramado> {

	public MaterialProgramado buscarPorId(int id);

	public List<MaterialProgramado> buscarPorMaterial(Material material);

	public List<MaterialProgramado> buscarPorProyectoProgramacionAnual(
			ProyectoProgramacionAnual proyectoprogramacionanual);
		
}
