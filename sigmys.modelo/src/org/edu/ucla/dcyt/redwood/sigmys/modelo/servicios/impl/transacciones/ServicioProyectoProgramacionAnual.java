package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proyecto;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProyectoProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IProyectoProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioProyectoProgramacionAnual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioProyectoProgramacionAnual")
public class ServicioProyectoProgramacionAnual implements
		IServicioProyectoProgramacionAnual {

	@Autowired
	IProyectoProgramacionAnual iProyectoProgramacionAnual;
	
	@Override
	public List<ProyectoProgramacionAnual> buscarTodos() {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.findAll().size();
	}

	@Override
	public ProyectoProgramacionAnual guardar(ProyectoProgramacionAnual entidad) {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.save(entidad);
	}

	@Override
	public ProyectoProgramacionAnual crear() {
		// TODO Auto-generated method stub
		return new ProyectoProgramacionAnual();
	}

	@Override
	public void eliminar(ProyectoProgramacionAnual entidad) {
		// TODO Auto-generated method stub
		iProyectoProgramacionAnual.delete(entidad);
	}

	@Override
	public void eliminar(Collection<ProyectoProgramacionAnual> entidades) {
		// TODO Auto-generated method stub
		iProyectoProgramacionAnual.delete(entidades);
	}

	@Override
	public ProyectoProgramacionAnual buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.findById(id);
	}

	@Override
	public ProyectoProgramacionAnual buscarPorCodigoopsu(String codigoopsu) {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.findByCodigoopsu(codigoopsu);
	}

	@Override
	public List<ProyectoProgramacionAnual> buscarPorProyecto(Proyecto proyecto) {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.findByProyecto(proyecto);
	}

	@Override
	public List<ProyectoProgramacionAnual> buscarPorProgramacionanual(
			ProgramacionAnual programacionanual) {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.findByProgramacionanual(programacionanual);
	}

	@Override
	public List<ProyectoProgramacionAnual> buscarPorProyectoAndProgramacionanual(
			Proyecto proyecto, ProgramacionAnual programacionanual) {
		// TODO Auto-generated method stub
		return iProyectoProgramacionAnual.findByProyectoAndProgramacionanual(proyecto, programacionanual);
	}

}
