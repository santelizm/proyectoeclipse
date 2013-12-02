package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEspacioFisicoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioEspacioFisico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioEspacioFisico")
public class ServicioEspacioFisico implements IServicioEspacioFisico {

	@Autowired
	IEspacioFisicoRepository iEspacioFisicoRepository;
	
	@Override
	public List<EspacioFisico> buscarTodos() {
		return iEspacioFisicoRepository.findAll();
		
	}

	@Override
	public int contarTodos() {
		return iEspacioFisicoRepository.findAll().size();
		
	}

	@Override
	public EspacioFisico guardar(EspacioFisico entidad) {
		return iEspacioFisicoRepository.save(entidad);
	}

	@Override
	public EspacioFisico crear() {
		return new EspacioFisico();
	}

	@Override
	public void eliminar(EspacioFisico entidad) {
		iEspacioFisicoRepository.delete(entidad);
		
	}

	@Override
	public void eliminar(Collection<EspacioFisico> entidades) {
		iEspacioFisicoRepository.delete(entidades);
		
	}

	@Override
	public EspacioFisico buscarEspacioFisicoPorId(int id) {
		return iEspacioFisicoRepository.findById(id);
	}

	@Override
	public EspacioFisico buscarEspacioFisicoPorNombre(String nombre) {
		return iEspacioFisicoRepository.findByNombre(nombre);
	}

	@Override
	public List<EspacioFisico> buscarEspacioFisicoPorModulo(String modulo) {
		return iEspacioFisicoRepository.findByModuloLike(modulo);
	}


	@Override
	public List<EspacioFisico> buscarEspacioFisicoPorStatus(String status) {
		return iEspacioFisicoRepository.findByStatus(status);
	}

	@Override
	public List<EspacioFisico> buscarPorX(String parametro) {
		return iEspacioFisicoRepository.buscarPorX(parametro);
	}


}