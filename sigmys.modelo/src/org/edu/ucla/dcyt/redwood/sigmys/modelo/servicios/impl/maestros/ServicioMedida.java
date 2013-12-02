package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Medida;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IMedidaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("servicioMedida")
public class ServicioMedida implements IServicioMedida {

	
	@Autowired
	IMedidaRepository medidaRep;
	@Override
	
	public List<Medida> buscarTodos() {
		// TODO Auto-generated method stub
		return medidaRep.findAll();
	}

	@Override
	
	public int contarTodos() {
		// TODO Auto-generated method stub
		return medidaRep.findAll().size();
	}

	@Override
	
	public Medida guardar(Medida entidad) {
		// TODO Auto-generated method stub
		return medidaRep.save(entidad);
	}

	@Override

	public Medida crear() {
		// TODO Auto-generated method stub
		return new Medida();
	}

	@Override
	
	public void eliminar(Medida entidad) {
		// TODO Auto-generated method stub
		medidaRep.delete(entidad);
	}

	@Override
	
	public void eliminar(Collection<Medida> entidades) {
		// TODO Auto-generated method stub
		medidaRep.delete(entidades);
	}

	@Override

	public Medida BuscarMedidaPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return medidaRep.findByNombre(nombre);
	}

	@Override
	public List<Medida> BuscarMedidasPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return medidaRep.findByNombreLike(nombre);
	}

	@Override
	public Medida BuscarMedidaPorId(int id) {
		// TODO Auto-generated method stub
		return medidaRep.findById(id);
	}
	
	@Override
	public List<Medida> buscarPorX(String parametro) {
		return medidaRep.buscarPorX(parametro);
	}

}
