package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRecibido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IMaterialRecibidoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioMaterialRecibido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("servicioMaterialRecibido")
public class ServicioMaterialRecibido implements IServicioMaterialRecibido{

	@Autowired
	IMaterialRecibidoRepository iMaterialRecibidoRep;
	
	@Override
	public List<MaterialRecibido> buscarTodos() {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.findAll().size();
	}

	@Override
	public MaterialRecibido guardar(MaterialRecibido entidad) {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.save(entidad);
	}

	@Override
	public MaterialRecibido crear() {
		// TODO Auto-generated method stub
		return new MaterialRecibido();
	}

	@Override
	public void eliminar(MaterialRecibido entidad) {
		// TODO Auto-generated method stub
		iMaterialRecibidoRep.delete(entidad);
	}

	@Override
	public void eliminar(Collection<MaterialRecibido> entidades) {
		// TODO Auto-generated method stub
		iMaterialRecibidoRep.delete(entidades);
		
	}

	@Override
	public MaterialRecibido buscarMaterialRecibidoPorId(int id) {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.findById(id);
	}

	@Override
	public List<MaterialRecibido> buscarMaterialRecibidoPorOrdenDeServicio(
			OrdenServicio ordendeservicio) {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.findByOrdendeservicio(ordendeservicio);
	}

	@Override
	public List<MaterialRecibido> buscarMaterialRecibidoPorMaterial(int material) {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.findByMaterial(material);
	}

	@Override
	public List<MaterialRecibido> buscarMaterialRecibidoPorCantidad(int cantidad) {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.findByCantidad(cantidad);
	}


	@Override
	public List<MaterialRecibido> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iMaterialRecibidoRep.buscarPorX(parametro);
	}

	

}
