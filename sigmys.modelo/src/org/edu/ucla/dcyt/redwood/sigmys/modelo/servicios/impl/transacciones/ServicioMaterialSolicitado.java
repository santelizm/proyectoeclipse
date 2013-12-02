package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IMaterialSolicitadoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioMaterialSolicitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioMaterialSolicitado")
public class ServicioMaterialSolicitado implements IServicioMaterialSolicitado {
	@Autowired
	IMaterialSolicitadoRepository materialSolicitadoRepository;	
	
	@Override
	public List<MaterialSolicitado> buscarTodos() {
		// TODO Auto-generated method stub
		return materialSolicitadoRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return materialSolicitadoRepository.findAll().size();
	}

	@Override
	public MaterialSolicitado guardar(MaterialSolicitado entidad) {
		// TODO Auto-generated method stub
		return materialSolicitadoRepository.save(entidad);
	}

	@Override
	public MaterialSolicitado crear() {
		// TODO Auto-generated method stub
		return new MaterialSolicitado();
	}

	@Override
	public void eliminar(MaterialSolicitado entidad) {
		// TODO Auto-generated method stub
		materialSolicitadoRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<MaterialSolicitado> entidades) {
		// TODO Auto-generated method stub
		materialSolicitadoRepository.delete(entidades);
	}

	

	@Override
	public List<MaterialSolicitado> buscarPorMaterialComo(Material material) {
		// TODO Auto-generated method stub
		return materialSolicitadoRepository.findByMaterial(material);
	}

	@Override
	public List<MaterialSolicitado> buscarPorSolicitudMaterialComo(
			SolicitudMaterial solicitud) {
		// TODO Auto-generated method stub
		return materialSolicitadoRepository.findBySolicitudMaterial(solicitud);
	}

	@Override
	public List<MaterialSolicitado> buscarPorEstadoMaterialSolicitadoComo(
			EstadoMaterialSolicitado estadoMaterialSolicitado) {
		// TODO Auto-generated method stub
		return materialSolicitadoRepository.findByEstadoMaterialSolicitado(estadoMaterialSolicitado);
	}
	

	
}
