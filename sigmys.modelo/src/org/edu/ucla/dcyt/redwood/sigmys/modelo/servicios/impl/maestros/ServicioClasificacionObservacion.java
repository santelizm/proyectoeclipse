package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ClasificacionObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IClasificacionObservacionRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioClasificacionObservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("servicioClasificacionObservacion")
public class ServicioClasificacionObservacion implements
		IServicioClasificacionObservacion {

	@Autowired
	IClasificacionObservacionRepository iClasificacionRepository;
	
	@Override
	public List<ClasificacionObservacion> buscarTodos() {
		// TODO Auto-generated method stub
		return iClasificacionRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iClasificacionRepository.findAll().size();
	}

	@Override
	public ClasificacionObservacion guardar(ClasificacionObservacion entidad) {
		// TODO Auto-generated method stub
		return iClasificacionRepository.save(entidad);
	}

	@Override
	public ClasificacionObservacion crear() {
		// TODO Auto-generated method stub
		return new ClasificacionObservacion();
	}

	@Override
	public void eliminar(ClasificacionObservacion entidad) {
		// TODO Auto-generated method stub
		iClasificacionRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<ClasificacionObservacion> entidades) {
		// TODO Auto-generated method stub
		iClasificacionRepository.delete(entidades);
	}

	@Override
	public ClasificacionObservacion buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iClasificacionRepository.findById(id);
	}

	@Override
	public ClasificacionObservacion buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iClasificacionRepository.findByNombre(nombre);
	}

	@Override
	public List<ClasificacionObservacion> buscarPorStatus(String status) {
		// TODO Auto-generated method stub
		return iClasificacionRepository.findByStatus(status);
	}
	
}
