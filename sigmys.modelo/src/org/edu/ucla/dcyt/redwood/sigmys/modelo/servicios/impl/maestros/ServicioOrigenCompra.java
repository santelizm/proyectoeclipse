package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.OrigenCompra;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IOrigenCompraRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioOrigenCompra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioOrigenCompra")
public class ServicioOrigenCompra implements IServicioOrigenCompra {
	
	@Autowired
	IOrigenCompraRepository iOrigenCompraRepository;
	
	@Override
	public List<OrigenCompra> buscarTodos() {
		return iOrigenCompraRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iOrigenCompraRepository.findAll().size();
	}

	@Override
	public OrigenCompra guardar(OrigenCompra entidad) {
		return iOrigenCompraRepository.save(entidad);
	}

	@Override
	public OrigenCompra crear() {
		return new OrigenCompra();
	}

	@Override
	public void eliminar(OrigenCompra entidad) {
		iOrigenCompraRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<OrigenCompra> entidades) {
		iOrigenCompraRepository.delete(entidades);
	}

	@Override
	public List<OrigenCompra> buscarOrigenCompraPorNombre(String nombre) {
		return iOrigenCompraRepository.findByNombreLike(nombre);
	}

	@Override
	public List<OrigenCompra> buscarOrigenCompraPorDescripcion(String descripcion) {
		return iOrigenCompraRepository.findByDescripcionLike(descripcion);
	}

	@Override
	public List<OrigenCompra> buscarOrigenCompraPorStatus(String status) {
		return iOrigenCompraRepository.findByStatusLike(status);
	}

	@Override
	public OrigenCompra buscarServicioOrigenCompraPorId(int id) {
		// TODO Auto-generated method stub
		return iOrigenCompraRepository.findById(id);
	}
	
	@Override
	public List<OrigenCompra> buscarPorX(String parametro) {
		return iOrigenCompraRepository.buscarPorX(parametro);
	}

}
