package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.ITipoMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioTipoMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioTipoMaterial")
public class ServicioTipoMaterial implements IServicioTipoMaterial {

	@Autowired
	ITipoMaterialRepository iTipoMaterialRepository;

	@Override
	public List<TipoMaterial> buscarTodos() {
		// TODO Auto-generated method stub
		return iTipoMaterialRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iTipoMaterialRepository.findAll().size();
	}

	@Override
	public TipoMaterial guardar(TipoMaterial entidad) {
		// TODO Auto-generated method stub
		return iTipoMaterialRepository.save(entidad);
	}

	@Override
	public TipoMaterial crear() {
		// TODO Auto-generated method stub
		return new TipoMaterial();
	}

	@Override
	public void eliminar(TipoMaterial entidad) {
		// TODO Auto-generated method stub
		iTipoMaterialRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<TipoMaterial> entidades) {
		// TODO Auto-generated method stub
		iTipoMaterialRepository.delete(entidades);
	}

	@Override
	public TipoMaterial buscarMaterialPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iTipoMaterialRepository.findByNombre(nombre);
	}

	@Override
	public List<TipoMaterial> buscarMaterialesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iTipoMaterialRepository.findByNombreLike(nombre);
	}

	@Override
	public List<TipoMaterial> buscarPorX(String parametro) {
		return iTipoMaterialRepository.buscarPorX(parametro);
	}

}
