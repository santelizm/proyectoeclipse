package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;


import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEstadoRequisicionRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioEstadoRequisicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("servicioEstadoRequisicion")
public class ServicioEstadoRequisicion implements IServicioEstadoRequisicion{

	
	@Autowired
	IEstadoRequisicionRepository iEstadoRequisicionRepository;
	
	@Override
	public List<EstadoRequisicion> buscarTodos() {
		// TODO Auto-generated method stub
		return iEstadoRequisicionRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iEstadoRequisicionRepository.findAll().size();
	}

	@Override
	public EstadoRequisicion guardar(EstadoRequisicion entidad) {
		// TODO Auto-generated method stub
		return iEstadoRequisicionRepository.save(entidad);
	}

	@Override
	public EstadoRequisicion crear() {
		// TODO Auto-generated method stub
		return new EstadoRequisicion();
	}

	@Override
	public void eliminar(EstadoRequisicion entidad) {
		// TODO Auto-generated method stub
		iEstadoRequisicionRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<EstadoRequisicion> entidades) {
		// TODO Auto-generated method stub
		iEstadoRequisicionRepository.delete(entidades);
	}


	@Override
	public List<EstadoRequisicion> buscarEstadoRequisiconPorNombreComo(
			String nombre) {
		// TODO Auto-generated method stub
		return iEstadoRequisicionRepository.findByNombreLike(nombre);
	}

	@Override
	public EstadoRequisicion buscarEstadoRequisicionPorId(int id) {
		// TODO Auto-generated method stub
		return iEstadoRequisicionRepository.findById(id);
	}

	@Override
	public EstadoRequisicion buscarEstadoRequisicionPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iEstadoRequisicionRepository.findByNombre(nombre);
	}

	@Override
	public List<EstadoRequisicion> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iEstadoRequisicionRepository.buscarPorX(parametro);
	}

}
