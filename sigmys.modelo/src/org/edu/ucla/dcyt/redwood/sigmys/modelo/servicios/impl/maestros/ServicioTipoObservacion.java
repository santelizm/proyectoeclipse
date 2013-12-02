package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.ITipoObservacionRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioTipoObservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("servicioTipoObservacion")

public class ServicioTipoObservacion implements IServicioTipoObservacion {

	@Autowired
	ITipoObservacionRepository iTipoObservacionRep;
	
	
	@Override
	public List<TipoObservacion> buscarTodos() {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.findAll();
	}
	

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.findAll().size();
	}
	
	@Override
	public TipoObservacion guardar(TipoObservacion entidad) {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.save(entidad);
	}

	@Override
	public TipoObservacion crear() {
		// TODO Auto-generated method stub
		return new TipoObservacion();
	}

	@Override
	public void eliminar(TipoObservacion entidad) {
		// TODO Auto-generated method stub
		iTipoObservacionRep.delete(entidad);
	}

	@Override
	public void eliminar(Collection<TipoObservacion> entidades) {
		// TODO Auto-generated method stub
		iTipoObservacionRep.delete(entidades);
	}	
	
	@Override
	public TipoObservacion buscarTipoObservacionPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.findByNombre(nombre);
	}

	@Override
	public List<TipoObservacion> buscarTipoObservacionesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.findByNombreLike(nombre);
	}


	@Override
	public TipoObservacion buscarTipoObservacionPorId(int id) {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.findById(id);
	}


	@Override
	public List<TipoObservacion> buscarTipoObservacionPorStatus(String status) {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.findByStatusLike(status);
	}


	@Override
	public List<TipoObservacion> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iTipoObservacionRep.buscarPorX(parametro);
	}

	
	
}
