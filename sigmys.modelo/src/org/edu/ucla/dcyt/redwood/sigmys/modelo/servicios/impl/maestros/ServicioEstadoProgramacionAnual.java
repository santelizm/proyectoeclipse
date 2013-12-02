package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEstadoProgramacionAnualRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioEstadoProgramacionAnual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioEstadoProgramacionAnual")
public class ServicioEstadoProgramacionAnual implements IServicioEstadoProgramacionAnual {
	
	@Autowired
	IEstadoProgramacionAnualRepository iEstadoProgramacionAnualRepository;
	
	@Override
	public List<EstadoProgramacionAnual> buscarTodos() {
		return iEstadoProgramacionAnualRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iEstadoProgramacionAnualRepository.findAll().size();
	}

	@Override
	public EstadoProgramacionAnual guardar(EstadoProgramacionAnual entidad) {
		return iEstadoProgramacionAnualRepository.save(entidad);
	}

	@Override
	public EstadoProgramacionAnual crear() {
		return new EstadoProgramacionAnual();
	}

	@Override
	public void eliminar(EstadoProgramacionAnual entidad) {
		iEstadoProgramacionAnualRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<EstadoProgramacionAnual> entidades) {
		iEstadoProgramacionAnualRepository.delete(entidades);
	}

	@Override
	public EstadoProgramacionAnual buscarEstadoProgramacionAnualPorId(int id) {
		return iEstadoProgramacionAnualRepository.findById(id);
	}

	@Override
	public List<EstadoProgramacionAnual> buscarEstadosProgramacionAnualPorNombre(String nombre) {
		return iEstadoProgramacionAnualRepository.findByNombreLike(nombre);
	}

	@Override
	public List<EstadoProgramacionAnual> buscarEstadosProgramacionAnualPorDescripcion(String descripcion) {
		return iEstadoProgramacionAnualRepository.findByDescripcionLike(descripcion);
	}

	@Override
	public List<EstadoProgramacionAnual> buscarEstadosProgramacionAnualPorStatus(String status) {
		return iEstadoProgramacionAnualRepository.findByStatusLike(status);
	}

	@Override
	public List<EstadoProgramacionAnual> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iEstadoProgramacionAnualRepository.buscarPorX(parametro);
	}

}