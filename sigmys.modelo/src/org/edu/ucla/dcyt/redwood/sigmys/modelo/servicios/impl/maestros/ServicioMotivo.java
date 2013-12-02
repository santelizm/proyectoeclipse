package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Motivo;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IMotivoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioMotivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("servicioMotivo")
public class ServicioMotivo implements IServicioMotivo{
	@Autowired
	IMotivoRepository iMotivoRepository;
	
	@Override
	public List<Motivo> buscarTodos() {
		// TODO Auto-generated method stub
		return iMotivoRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iMotivoRepository.findAll().size();
	}

	@Override
	public Motivo guardar(Motivo entidad) {
		// TODO Auto-generated method stub
		return iMotivoRepository.save(entidad);
	}

	@Override
	public Motivo crear() {
		// TODO Auto-generated method stub
		return new Motivo();
	}

	@Override
	public void eliminar(Motivo entidad) {
		// TODO Auto-generated method stub
		iMotivoRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<Motivo> entidades) {
		// TODO Auto-generated method stub
		iMotivoRepository.delete(entidades);
	}

	@Override
	public Motivo BuscarPorId(int id) {
		// TODO Auto-generated method stub
		return iMotivoRepository.findById(id);
	}

	@Override
	public List<Motivo> buscarMotivoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iMotivoRepository.findByNombreLike(nombre);
	}

	@Override
	public List<Motivo> buscarMotivoPorDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return iMotivoRepository.findByDescripcionLike(descripcion);
	}

	@Override
	public List<Motivo> buscarMotivoPorStatus(String status) {
		// TODO Auto-generated method stub
		return iMotivoRepository.findByStatusLike(status);
	}

}
