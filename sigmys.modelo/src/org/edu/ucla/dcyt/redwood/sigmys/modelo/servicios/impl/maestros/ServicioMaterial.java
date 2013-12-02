package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioMaterial")
public class ServicioMaterial implements IServicioMaterial {

	@Autowired
	IMaterialRepository iMaterialRepository;
	
	@Override
	public List<Material> buscarTodos() {
		// TODO Auto-generated method stub
		return iMaterialRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iMaterialRepository.findAll().size();
	}

	@Override
	public Material guardar(Material entidad) {
		// TODO Auto-generated method stub
		return iMaterialRepository.save(entidad);
	}

	@Override
	public Material crear() {
		// TODO Auto-generated method stub
		return new Material();
	}

	@Override
	public void eliminar(Material entidad) {
		// TODO Auto-generated method stub
		iMaterialRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<Material> entidades) {
		// TODO Auto-generated method stub
		iMaterialRepository.delete(entidades);
	}

	@Override
	public Material buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iMaterialRepository.findById(id);
	}

	@Override
	public Material buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iMaterialRepository.findByNombre(nombre);
	}
	
	@Override
	public Material buscarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		return iMaterialRepository.findByCodigo(codigo);
	}

	@Override
	public List<Material> buscarPorNombreComo(String nombre) {
		// TODO Auto-generated method stub
		return iMaterialRepository.findByNombreLike(nombre);
	}

	@Override
	public List<Material> buscarPorDescripcionComo(String descripcion) {
		// TODO Auto-generated method stub
		return iMaterialRepository.findByDescripcionLike(descripcion);
	}

	@Override
	public List<Material> buscarPorStatusComo(String status) {
		// TODO Auto-generated method stub
		return iMaterialRepository.findByStatusLike(status);
	}

	@Override
	public List<Material> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iMaterialRepository.buscarPorX(parametro);
	}

	public List<Material> buscarPorParametros(Map parametros) {

		List<Material> materiales = buscarTodos();
		List<Material> materialesTodos = new ArrayList<Material>();
		List<Material> materialesTipo = new ArrayList<Material>();

		String tipomat = (String) parametros.get("tipomat");

		Material material;
		for (int i = 0; i < materiales.size(); i++) {
			material = new Material();
			material = materiales.get(i);
			if (material.getTipomaterial().getNombre().equals(tipomat))
				materialesTipo.add(material);
			else
				materialesTodos.add(material);
		}
		if (materialesTipo.size() != 0)
			return materialesTipo;
		else
			return materialesTodos;
	}

	public Material descontarExistencia(Material material, int cantidad){
		int existencia=material.getExistencia();
		if(cantidad<=existencia){
		existencia=existencia-cantidad;
		material.setExistencia(existencia);
		return iMaterialRepository.save(material);
		}else{
			return material;
		}
	}

}
