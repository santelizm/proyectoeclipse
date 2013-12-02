package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.DetalleMaterialEntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IDetalleMaterialEntregaEventualRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioDetalleMaterialEntregaEventual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioDetalleMaterialEntregaEventual")
public class ServicioDetalleMaterialEntregaEventual implements
		IServicioDetalleMaterialEntregaEventual {

	@Autowired
	IDetalleMaterialEntregaEventualRepository iDetalleMaterialEntregaEventualRepository;
	
	@Override
	public List<DetalleMaterialEntregaEventual> buscarTodos() {
		// TODO Auto-generated method stub
		return iDetalleMaterialEntregaEventualRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iDetalleMaterialEntregaEventualRepository.findAll().size();
	}

	@Override
	public DetalleMaterialEntregaEventual guardar(
			DetalleMaterialEntregaEventual entidad) {
		// TODO Auto-generated method stub
		return iDetalleMaterialEntregaEventualRepository.save(entidad);
	}

	@Override
	public DetalleMaterialEntregaEventual crear() {
		// TODO Auto-generated method stub
		return new DetalleMaterialEntregaEventual();
	}

	@Override
	public void eliminar(DetalleMaterialEntregaEventual entidad) {
		// TODO Auto-generated method stub
		iDetalleMaterialEntregaEventualRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<DetalleMaterialEntregaEventual> entidades) {
		// TODO Auto-generated method stub
		iDetalleMaterialEntregaEventualRepository.delete(entidades);
	}

	@Override
	public DetalleMaterialEntregaEventual buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iDetalleMaterialEntregaEventualRepository.findById(id);
	}

	@Override
	public List<DetalleMaterialEntregaEventual> buscarPorEntregaEventual(
			EntregaEventual entregaeventual) {
		// TODO Auto-generated method stub
		return iDetalleMaterialEntregaEventualRepository.findByEntregaeventual(entregaeventual);
	}

	@Override
	public List<DetalleMaterialEntregaEventual> buscarPorMaterial(
			Material material) {
		// TODO Auto-generated method stub
		return iDetalleMaterialEntregaEventualRepository.findByMaterial(material);
	}

	@Override
	public List<DetalleMaterialEntregaEventual> buscarPorCantidad(int cantidad) {
		// TODO Auto-generated method stub
		return iDetalleMaterialEntregaEventualRepository.findByCantidad(cantidad);
	}

}
