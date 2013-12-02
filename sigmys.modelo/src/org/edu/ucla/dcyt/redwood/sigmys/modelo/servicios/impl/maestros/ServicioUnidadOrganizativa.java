package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IUnidadOrganizativaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioUnidadOrganizativa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioUnidadOrganizativa")
public class ServicioUnidadOrganizativa implements IServicioUnidadOrganizativa {

	@Autowired
	IUnidadOrganizativaRepository iUnidadOrganizativaRepository;
	
	@Override
	public List<UnidadOrganizativa> buscarTodos() {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.findAll().size();
	}

	@Override
	public UnidadOrganizativa guardar(UnidadOrganizativa entidad) {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.save(entidad);
	}

	@Override
	public UnidadOrganizativa crear() {
		// TODO Auto-generated method stub
		return new UnidadOrganizativa();
	}

	@Override
	public void eliminar(UnidadOrganizativa entidad) {
		// TODO Auto-generated method stub
		iUnidadOrganizativaRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<UnidadOrganizativa> entidades) {
		// TODO Auto-generated method stub
		iUnidadOrganizativaRepository.delete(entidades);
	}

	@Override
	public UnidadOrganizativa buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.findById(id);
	}

	@Override
	public UnidadOrganizativa buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.findByNombre(nombre);
	}

	@Override
	public List<UnidadOrganizativa> buscarPorNombreComo(String nombre) {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.findByNombreLike(nombre);
	}

	@Override
	public List<UnidadOrganizativa> buscarPorDescripcionComo(String descripcion) {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.findByDescripcionLike(descripcion);
	}

	@Override
	public List<UnidadOrganizativa> buscarPorStatusComo(String status) {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.findByStatusLike(status);
	}

	@Override
	public List<UnidadOrganizativa> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iUnidadOrganizativaRepository.buscarPorX(parametro);
	}
	
	@Override
	public List<UnidadOrganizativa> buscarUnidadOrganizativaPorProyectoNulo() {
		// TODO Auto-generated method stub
	return iUnidadOrganizativaRepository.findByProyectoIsNull();
	}
}
