package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EnlaceInteres;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEnlaceInteresRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioEnlaceInteres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("servicioEnlaceIneteres")
public class ServicioEnlaceInteres implements IServicioEnlaceInteres {

	@Autowired
	IEnlaceInteresRepository iEnlaceInteresRepository;

	@Override
	public List<EnlaceInteres> buscarTodos() {
		return iEnlaceInteresRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iEnlaceInteresRepository.findAll().size();
	}

	@Override
	public EnlaceInteres guardar(EnlaceInteres entidad) {
		return iEnlaceInteresRepository.save(entidad);
	}

	@Override
	public EnlaceInteres crear() {
		return new EnlaceInteres();
	}

	@Override
	public void eliminar(EnlaceInteres entidad) {
		iEnlaceInteresRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<EnlaceInteres> entidades) {
		iEnlaceInteresRepository.delete(entidades);
	}

	@Override
	public EnlaceInteres buscarEnlaceInteresPorId(int id) {
		return iEnlaceInteresRepository.findById(id);
	}

	@Override
	public List<EnlaceInteres> buscarEnlaceInteresPorUnidadOrganizativa(
			UnidadOrganizativa unidadOrganizativa) {
		return iEnlaceInteresRepository
				.findByUnidadorganizativa(unidadOrganizativa);
	}

	@Override
	public List<EnlaceInteres> buscarEnlaceInteresPorStatus(String status) {
		return iEnlaceInteresRepository.findByStatus(status);
	}

	@Override
	public EnlaceInteres buscarEnlaceInteresPorLinkenlace(
			String linkenlace) {
		// TODO Auto-generated method stub
		return iEnlaceInteresRepository.findByLinkenlace(linkenlace);
	}

	@Override
	public List<EnlaceInteres> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iEnlaceInteresRepository.buscarPorX(parametro);
	}

	@Override
	public List<EnlaceInteres> buscarEnlacesOrdenados() {
		// TODO Auto-generated method stub
		return iEnlaceInteresRepository.buscarEnlacesOrdenados();
	}
}