package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Empleado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEmpleadoRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinergia.modelo.data.seguridad.Usuario;

@Service("servicioEmpleado")
public class ServicioEmpleado implements IServicioEmpleado {

	@Autowired
	IEmpleadoRepository iEmpleadoRepository;

	@Override
	public List<Empleado> buscarTodos() {
		// TODO Auto-generated method stub
		return iEmpleadoRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iEmpleadoRepository.findAll().size();
	}

	@Override
	public Empleado guardar(Empleado entidad) {
		// TODO Auto-generated method stub
		return iEmpleadoRepository.save(entidad);
	}

	@Override
	public Empleado crear() {
		// TODO Auto-generated method stub
		return new Empleado();
	}

	@Override
	public void eliminar(Empleado entidad) {
		// TODO Auto-generated method stub
		iEmpleadoRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<Empleado> entidades) {
		// TODO Auto-generated method stub
		iEmpleadoRepository.delete(entidades);
	}

	@Override
	public Empleado buscarEmpleadoPorId(int id) {
		// TODO Auto-generated method stub
		return iEmpleadoRepository.findById(id);
	}

	@Override
	public Empleado buscarEmpleadoPorUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return iEmpleadoRepository.findByUsuario(usuario);
	}

	@Override
	public List<Empleado> buscarEmpleadoPorStatusLike(String status) {
		// TODO Auto-generated method stub
		return iEmpleadoRepository.findByStatusLike(status);
	}

	@Override
	public List<Empleado> buscarPorX(String parametro) {
		// TODO Auto-generated method stub
		return iEmpleadoRepository.buscarPorX(parametro);
	}

}
