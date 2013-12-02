package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IMaterialRequeridoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioMaterialRequerido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioMaterialRequerido")
public class ServicioMaterialRequerido implements IServicioMaterialRequerido{

	
	@Autowired
	IMaterialRequeridoRepository iMaterialRequeridoRepository;
	
	
	@Override
	public List<MaterialRequerido> buscarTodos() {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.findAll().size();
	}

	@Override
	public MaterialRequerido guardar(MaterialRequerido entidad) {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.save(entidad);
	}

	@Override
	public MaterialRequerido crear() {
		// TODO Auto-generated method stub
		return new MaterialRequerido();
	}

	@Override
	public void eliminar(MaterialRequerido entidad) {
		// TODO Auto-generated method stub
		iMaterialRequeridoRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<MaterialRequerido> entidades) {
		// TODO Auto-generated method stub
		iMaterialRequeridoRepository.delete(entidades);
	}

	@Override
	public MaterialRequerido buscarMaterialRequeridoPorId(int id) {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.findById(id);
	}

	@Override
	public MaterialRequerido buscarMaterialRequeridoPorCantidad(int cantidad) {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.findByCantidad(cantidad);
	}

	@Override
	public List<MaterialRequerido> buscarMaterialRequeridoPorRequisicion(
			Requisicion requisicion) {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.findByRequisicion(requisicion);
	}

	
	@Override
	public List<MaterialRequerido> buscarMaterialRequeridoPorMaterial(
			Material material) {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.findByMaterial(material);
	}
	
	@Override
	public List<MaterialRequerido> buscarMaterialRequeridoPorEstadoMaterialRequerido(
			EstadoMaterialRequerido estadoMaterialRequerido) {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.findByEstadomaterialrequerido(estadoMaterialRequerido);
	}

	@Override
	public List<MaterialRequerido> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iMaterialRequeridoRepository.buscarPorX(parametro);
	}
	
	
	

}
