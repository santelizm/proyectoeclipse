package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;


/*
 Creacion de Servicio EstadoMaterialSolicitado
 Autor: Greg y Mariangel
 Fecha: 18/12/2012 5pm;
 */

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEstadoMaterialSolicitadoReposository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioEstadoMaterialSolicitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioEstadoMaterialSolicitado")
public class ServicioEstadoMaterialSolicitado implements IServicioEstadoMaterialSolicitado{

	@Autowired 
	IEstadoMaterialSolicitadoReposository iEstadoMaterialSolicitadoReposository;
	
	@Override
	public List<EstadoMaterialSolicitado> buscarTodos() {
		// TODO Auto-generated method stub
		return iEstadoMaterialSolicitadoReposository.findAll() ;
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iEstadoMaterialSolicitadoReposository.findAll().size();
	}

	@Override
	public EstadoMaterialSolicitado guardar(EstadoMaterialSolicitado entidad) {
		// TODO Auto-generated method stub
		return iEstadoMaterialSolicitadoReposository.save(entidad);
	}

	@Override
	public EstadoMaterialSolicitado crear() {
		// TODO Auto-generated method stub
		return new EstadoMaterialSolicitado();
	}

	@Override
	public void eliminar(EstadoMaterialSolicitado entidad) {
		// TODO Auto-generated method stud
		iEstadoMaterialSolicitadoReposository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<EstadoMaterialSolicitado> entidades) {
		// TODO Auto-generated method stub
		iEstadoMaterialSolicitadoReposository.delete(entidades);
	}

	@Override
	public EstadoMaterialSolicitado buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iEstadoMaterialSolicitadoReposository.findByNombre(nombre);
	}

	@Override
	public List<EstadoMaterialSolicitado> buscarPorNombreComo(String nombre) {
		// TODO Auto-generated method stub
		return iEstadoMaterialSolicitadoReposository.findByNombreLike(nombre);
	}

	@Override
	public EstadoMaterialSolicitado buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iEstadoMaterialSolicitadoReposository.findById(id);
	}

	/* (non-Javadoc)
	 * @see org.edu.ucla.dcyt.redwood.sigmys.modelo.estadomaterialsolicitado.IServicioEstadoMaterialSolicitado#buscarPorX(java.lang.String)
	 */
	@Override
	public List<EstadoMaterialSolicitado> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iEstadoMaterialSolicitadoReposository.buscarPorX(parametro);
	}

}
