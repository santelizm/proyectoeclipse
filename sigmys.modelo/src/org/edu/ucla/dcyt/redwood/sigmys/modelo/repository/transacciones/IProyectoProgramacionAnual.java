package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proyecto;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProyectoProgramacionAnual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProyectoProgramacionAnual extends
		JpaRepository<ProyectoProgramacionAnual, Integer> {

	public ProyectoProgramacionAnual findById(int id);
	
	public List<ProyectoProgramacionAnual> findByProyecto(Proyecto proyecto);
	
	public List<ProyectoProgramacionAnual> findByProyectoAndProgramacionanual(Proyecto proyecto,ProgramacionAnual programacionanual);
	
	public List<ProyectoProgramacionAnual> findByProgramacionanual(ProgramacionAnual programacionanual);
	
	public ProyectoProgramacionAnual findByCodigoopsu(String codigoopsu);
}
