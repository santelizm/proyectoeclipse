package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialProgramado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProyectoProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IMaterialProgramadoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioMaterialProgramado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("servicioMaterialProgramado")
public class ServicioMaterialProgramado implements IServicioMaterialProgramado {

	@Autowired
	IMaterialProgramadoRepository iMaterialProgramadoRepository;

	@Override
	public List<MaterialProgramado> buscarTodos() {
		// TODO Auto-generated method stub
		return iMaterialProgramadoRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iMaterialProgramadoRepository.findAll().size();
	}

	@Override
	public MaterialProgramado guardar(MaterialProgramado entidad) {
		// TODO Auto-generated method stub
		return iMaterialProgramadoRepository.save(entidad);
	}

	@Override
	public MaterialProgramado crear() {
		// TODO Auto-generated method stub
		return new MaterialProgramado();
	}

	@Override
	public void eliminar(MaterialProgramado entidad) {
		// TODO Auto-generated method stub
		iMaterialProgramadoRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<MaterialProgramado> entidades) {
		// TODO Auto-generated method stub
		iMaterialProgramadoRepository.delete(entidades);
	}

	@Override
	public MaterialProgramado buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iMaterialProgramadoRepository.findById(id);
	}

	@Override
	public List<MaterialProgramado> buscarPorMaterial(Material material) {
		// TODO Auto-generated method stub
		return iMaterialProgramadoRepository.findByMaterial(material);
	}

	@Override
	public List<MaterialProgramado> buscarPorProyectoProgramacionAnual(
			ProyectoProgramacionAnual proyectoprogramacionanual) {
		// TODO Auto-generated method stub
		return iMaterialProgramadoRepository
				.findByProyectoprogramacionanual(proyectoprogramacionanual);
	}

	public List<MaterialProgramado> buscarTodosOrdenados() {
		return iMaterialProgramadoRepository
				.findAll(sortByProyectoProgramacionAnualAsc());
	}

	/**
	 * Retorna un Orden con objetos de tipo MaterialProgramado ordenado por
	 * proyectoprogramacionanual en forma ascendente
	 * 
	 * @return
	 */
	private Sort sortByProyectoProgramacionAnualAsc() {
		return new Sort(Sort.Direction.ASC, "proyectoprogramacionanual");
	}

	public List<MaterialProgramado> buscarPorParametros(Map parametros) {
		List<MaterialProgramado> materiales = buscarTodosOrdenados();
		List<MaterialProgramado> materialesTodos = new ArrayList<MaterialProgramado>();
		List<MaterialProgramado> materialesPorProyecto = new ArrayList<MaterialProgramado>();
		String anio = (String) parametros.get("anio");
		String proyecto = (String) parametros.get("proyecto");
		MaterialProgramado materialProgramado = new MaterialProgramado();
		for (int i = 0; i < materiales.size(); i++) {
			materialProgramado = materiales.get(i);
			if (materialProgramado.getProyectoprogramacionanual()
					.getProgramacionanual().getAno().equals(anio)
					&& materialProgramado.getProyectoprogramacionanual()
							.getProyecto().getNombre().equals(proyecto))
				materialesPorProyecto.add(materialProgramado);
			else if (materialProgramado.getProyectoprogramacionanual()
					.getProgramacionanual().getAno().equals(anio)
					&& proyecto.equals("TODOS"))
				materialesTodos.add(materialProgramado);
		}
		if (materialesTodos.size() != 0)
			return materialesTodos;
		else
			return materialesPorProyecto;
	}

}
