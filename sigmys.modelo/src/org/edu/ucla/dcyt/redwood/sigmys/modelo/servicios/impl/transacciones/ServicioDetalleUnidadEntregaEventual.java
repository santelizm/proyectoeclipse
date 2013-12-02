package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.DetalleUnidadEntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IDetalleUnidadEntregaEventualRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioDetalleUnidadEntregaEventual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioDetalleUnidadEntregaEventual")
public class ServicioDetalleUnidadEntregaEventual implements
		IServicioDetalleUnidadEntregaEventual {

	@Autowired
	IDetalleUnidadEntregaEventualRepository iDetalleUnidadEntregaEventualRepository;
	
	@Override
	public List<DetalleUnidadEntregaEventual> buscarTodos() {
		return iDetalleUnidadEntregaEventualRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iDetalleUnidadEntregaEventualRepository.findAll().size();
	}

	@Override
	public DetalleUnidadEntregaEventual guardar(DetalleUnidadEntregaEventual entidad) {
		return iDetalleUnidadEntregaEventualRepository.save(entidad);
	}

	@Override
	public DetalleUnidadEntregaEventual crear() {
		return new DetalleUnidadEntregaEventual();
	}

	@Override
	public void eliminar(DetalleUnidadEntregaEventual entidad) {
		iDetalleUnidadEntregaEventualRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<DetalleUnidadEntregaEventual> entidades) {
		iDetalleUnidadEntregaEventualRepository.delete(entidades);
	}

	@Override
	public DetalleUnidadEntregaEventual buscarPorId(int id) {
		return iDetalleUnidadEntregaEventualRepository.findById(id);
	}

	@Override
	public List<DetalleUnidadEntregaEventual> buscarPorUnidadOrganizativa(
			UnidadOrganizativa unidadorganizativa) {
		return iDetalleUnidadEntregaEventualRepository.findByUnidadorganizativa(unidadorganizativa);
	}

	@Override
	public List<DetalleUnidadEntregaEventual> buscarPorDestino(
			EspacioFisico destino) {
		// TODO Auto-generated method stub
		return iDetalleUnidadEntregaEventualRepository.findByDestino(destino);
	}

	@Override
	public List<DetalleUnidadEntregaEventual> buscarPorEntregaEventual(
			EntregaEventual entregaeventual) {
		// TODO Auto-generated method stub
		return iDetalleUnidadEntregaEventualRepository.findByEntregaeventual(entregaeventual);
	}

}
