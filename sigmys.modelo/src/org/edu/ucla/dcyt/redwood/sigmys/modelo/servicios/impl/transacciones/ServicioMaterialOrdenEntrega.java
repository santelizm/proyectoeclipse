package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialOrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IMaterialOrdenEntregaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioMaterialOrdenEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioMaterialOrdenEntrega")
public class ServicioMaterialOrdenEntrega implements
		IServicioMaterialOrdenEntrega {

	@Autowired
	IMaterialOrdenEntregaRepository iMaterialOrdenEntregaRepository;
	
	@Override
	public List<MaterialOrdenEntrega> buscarTodos() {
		// TODO Auto-generated method stub
		return iMaterialOrdenEntregaRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iMaterialOrdenEntregaRepository.findAll().size();
	}

	@Override
	public MaterialOrdenEntrega guardar(MaterialOrdenEntrega entidad) {
		// TODO Auto-generated method stub
		return iMaterialOrdenEntregaRepository.save(entidad);
	}

	@Override
	public MaterialOrdenEntrega crear() {
		// TODO Auto-generated method stub
		return new MaterialOrdenEntrega();
	}

	@Override
	public void eliminar(MaterialOrdenEntrega entidad) {
		// TODO Auto-generated method stub
		iMaterialOrdenEntregaRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<MaterialOrdenEntrega> entidades) {
		// TODO Auto-generated method stub
		iMaterialOrdenEntregaRepository.delete(entidades);
	}

	@Override
	public MaterialOrdenEntrega buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iMaterialOrdenEntregaRepository.findById(id);
	}

	@Override
	public List<MaterialOrdenEntrega> buscarPorOrdenentrega(
			OrdenEntrega ordenentrega) {
		// TODO Auto-generated method stub
		return iMaterialOrdenEntregaRepository.findByOrdenentrega(ordenentrega);
	}

	@Override
	public List<MaterialOrdenEntrega> buscarPorMaterial(Material material) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MaterialOrdenEntrega> buscarPorCantidadentregada(
			int cantidadentregada) {
		// TODO Auto-generated method stub
		return iMaterialOrdenEntregaRepository.findByCantidadentregada(cantidadentregada);
	}

}
