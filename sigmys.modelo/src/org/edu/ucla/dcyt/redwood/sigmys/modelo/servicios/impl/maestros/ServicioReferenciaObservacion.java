package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ReferenciaObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IReferenciaObservacionRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioReferenciaObservacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioReferenciaObservacion")
public class ServicioReferenciaObservacion implements IServicioReferenciaObservacion {

	@Autowired
	IReferenciaObservacionRepository iReferenciaRepository;

	@Override
	public List<ReferenciaObservacion> buscarTodos() {
		// TODO Auto-generated method stub
		return iReferenciaRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iReferenciaRepository.findAll().size();
	}

	@Override
	public ReferenciaObservacion guardar(ReferenciaObservacion entidad) {
		// TODO Auto-generated method stub
		return iReferenciaRepository.save(entidad);
	}

	@Override
	public ReferenciaObservacion crear() {
		// TODO Auto-generated method stub
		return new ReferenciaObservacion();
	}

	@Override
	public void eliminar(ReferenciaObservacion entidad) {
		// TODO Auto-generated method stub
		iReferenciaRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<ReferenciaObservacion> entidades) {
		// TODO Auto-generated method stub
		iReferenciaRepository.delete(entidades);
	}

	@Override
	public ReferenciaObservacion buscarReferenciaPorId(int id) {
		// TODO Auto-generated method stub
		return iReferenciaRepository.findById(id);
	}

	@Override
	public ReferenciaObservacion buscarReferenciaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iReferenciaRepository.findByNombre(nombre);
	}

	@Override
	public List<ReferenciaObservacion> buscarReferenciaPorStatus(String status) {
		// TODO Auto-generated method stub
		return iReferenciaRepository.findByStatus(status);
	}


}
