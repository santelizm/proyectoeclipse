package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.UnidadOrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IUnidadOrdenEntregaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioUnidadOrdenEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioUnidadOrdenEntrega")
public class ServicioUnidadOrdenEntrega implements IServicioUnidadOrdenEntrega {

	@Autowired
	IUnidadOrdenEntregaRepository iUnidadOrdenEntregaRepository;
	
	@Override
	public List<UnidadOrdenEntrega> buscarTodos() {
		// TODO Auto-generated method stub
		return iUnidadOrdenEntregaRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iUnidadOrdenEntregaRepository.findAll().size();
	}

	@Override
	public UnidadOrdenEntrega guardar(UnidadOrdenEntrega entidad) {
		// TODO Auto-generated method stub
		return iUnidadOrdenEntregaRepository.save(entidad);
	}

	@Override
	public UnidadOrdenEntrega crear() {
		// TODO Auto-generated method stub
		return new UnidadOrdenEntrega();
	}

	@Override
	public void eliminar(UnidadOrdenEntrega entidad) {
		// TODO Auto-generated method stub
		iUnidadOrdenEntregaRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<UnidadOrdenEntrega> entidades) {
		// TODO Auto-generated method stub
		iUnidadOrdenEntregaRepository.delete(entidades);
	}

	@Override
	public UnidadOrdenEntrega buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iUnidadOrdenEntregaRepository.findById(id);
	}

	@Override
	public List<UnidadOrdenEntrega> buscarPorUnidadorganizativa(
			UnidadOrganizativa unidadorganizativa) {
		// TODO Auto-generated method stub
		return iUnidadOrdenEntregaRepository.findByUnidadorganizativa(unidadorganizativa);
	}

	@Override
	public List<UnidadOrdenEntrega> buscarPorOrdenentrega(
			OrdenEntrega ordenentrega) {
		// TODO Auto-generated method stub
		return iUnidadOrdenEntregaRepository.findByOrdenentrega(ordenentrega);
	}

	@Override
	public List<UnidadOrdenEntrega> buscarPorDestino(EspacioFisico destino) {
		// TODO Auto-generated method stub
		return iUnidadOrdenEntregaRepository.findByDestino(destino);
	}

}
