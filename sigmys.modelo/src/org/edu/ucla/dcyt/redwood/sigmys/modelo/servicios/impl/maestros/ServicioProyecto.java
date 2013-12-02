package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proyecto;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IProyectoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioProyecto")
public class ServicioProyecto implements IServicioProyecto {

	@Autowired
	IProyectoRepository iProyectoRepository;
	
	@Override
	public List<Proyecto> buscarTodos() {
		return iProyectoRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iProyectoRepository.findAll().size();
	}

	@Override
	public Proyecto guardar(Proyecto entidad) {
		return iProyectoRepository.save(entidad);
	}

	@Override
	public Proyecto crear() {
		return new Proyecto();
	}

	@Override
	public void eliminar(Proyecto entidad) {
		iProyectoRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<Proyecto> entidades) {
		iProyectoRepository.delete(entidades);
	}

	@Override
	public Proyecto buscarProyectoPorNombre(String nombre) {
		return iProyectoRepository.findByNombre(nombre);
	}

	@Override
	public List<Proyecto> buscarProyectosPorNombre(String nombre) {
		return iProyectoRepository.findByNombreLike(nombre);
	}

	@Override
	public List<Proyecto> buscarPorX(String parametro) {
		return iProyectoRepository.buscarPorX(parametro);
	}
}
