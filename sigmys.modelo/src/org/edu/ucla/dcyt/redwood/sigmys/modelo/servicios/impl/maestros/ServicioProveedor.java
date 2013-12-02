package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;


import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proveedor;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IProveedorRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioProveedor")
public class ServicioProveedor implements IServicioProveedor{
	@Autowired
	IProveedorRepository iProveedorRepository;
	@Override
	public List<Proveedor> buscarTodos() {
		// TODO Auto-generated method stub
		return iProveedorRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iProveedorRepository.findAll().size();
	}

	@Override
	public Proveedor guardar(Proveedor entidad) {
		// TODO Auto-generated method stub
		return iProveedorRepository.save(entidad);
	}

	@Override
	public Proveedor crear() {
		// TODO Auto-generated method stub
		return new Proveedor();
	}

	@Override
	public void eliminar(Proveedor entidad) {
		iProveedorRepository.delete(entidad);
		
	}

	@Override
	public void eliminar(Collection<Proveedor> entidades) {
		// TODO Auto-generated method stub
		iProveedorRepository.delete(entidades);
		
	}

	@Override
	public Proveedor BuscarPorId(int id) {
		// TODO Auto-generated method stub
		return iProveedorRepository.findById(id);
	}

	@Override
	public List<Proveedor> buscarProveedorPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return iProveedorRepository.findByNombreLike(nombre);
	}

	@Override
	public List<Proveedor> buscarProveedorPorDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return iProveedorRepository.findByDescripcionLike(descripcion);
	}

	@Override
	public List<Proveedor> buscarProveedorPorDireccion(String direccion) {
		// TODO Auto-generated method stub
		return iProveedorRepository.findByDireccionLike(direccion);
	}

	@Override
	public List<Proveedor> buscarProveedorPorStatus(String status) {
		// TODO Auto-generated method stub
		return iProveedorRepository.findByStatusLike(status);
	}

	@Override
	public List<Proveedor> buscarPorX(String parametro){
		return iProveedorRepository.buscarPorX(parametro);
	}
}
