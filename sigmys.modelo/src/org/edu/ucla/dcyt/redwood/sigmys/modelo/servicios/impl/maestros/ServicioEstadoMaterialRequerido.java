package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEstadoMaterialRequeridoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioEstadoMaterialRequerido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioEstadoMaterialRequerido")
public class ServicioEstadoMaterialRequerido implements IServicioEstadoMaterialRequerido {
	
	@Autowired
	IEstadoMaterialRequeridoRepository iEstadoMaterialRequeridoRepository;
	
	@Override
	public List<EstadoMaterialRequerido> buscarTodos() {
		return iEstadoMaterialRequeridoRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iEstadoMaterialRequeridoRepository.findAll().size();
	}

	@Override
	public EstadoMaterialRequerido guardar(EstadoMaterialRequerido entidad) {
		return iEstadoMaterialRequeridoRepository.save(entidad);
	}

	@Override
	public EstadoMaterialRequerido crear() {
		return new EstadoMaterialRequerido();
	}

	@Override
	public void eliminar(EstadoMaterialRequerido entidad) {
		iEstadoMaterialRequeridoRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<EstadoMaterialRequerido> entidades) {
		iEstadoMaterialRequeridoRepository.delete(entidades);
	}

	@Override
	public EstadoMaterialRequerido buscarEstadoMaterialRequeridoPorId(int id) {
		return iEstadoMaterialRequeridoRepository.findById(id);
	}

	@Override
	public List<EstadoMaterialRequerido> buscarEstadosMaterialRequeridoPorNombre(String nombre) {
		return iEstadoMaterialRequeridoRepository.findByNombreLike(nombre);
	}

	@Override
	public List<EstadoMaterialRequerido> buscarEstadosMaterialRequeridoPorDescripcion(String descripcion) {
		return iEstadoMaterialRequeridoRepository.findByDescripcionLike(descripcion);
	}

	@Override
	public List<EstadoMaterialRequerido> buscarEstadosMaterialRequeridoPorStatus(String status) {
		return iEstadoMaterialRequeridoRepository.findByStatusLike(status);
	}

	@Override
	public List<EstadoMaterialRequerido> buscarPorX(String parametro) {
		return iEstadoMaterialRequeridoRepository.buscarPorX(parametro);
	}

}
