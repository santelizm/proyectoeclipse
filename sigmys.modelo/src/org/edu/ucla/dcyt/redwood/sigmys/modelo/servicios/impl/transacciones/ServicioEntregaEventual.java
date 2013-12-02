package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IEntregaEventualRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioEntregaEventual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioEntregaEventual")
public class ServicioEntregaEventual implements IServicioEntregaEventual{
	
	@Autowired
	IEntregaEventualRepository iEntregaEventualRepository;
		
	@Override
	public List<EntregaEventual> buscarTodos() {
		// TODO Auto-generated method stub
		return iEntregaEventualRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iEntregaEventualRepository.findAll().size();
	}

	@Override
	public EntregaEventual guardar(EntregaEventual entidad) {
		// TODO Auto-generated method stub
		return iEntregaEventualRepository.save(entidad);
	}

	@Override
	public EntregaEventual crear() {
		// TODO Auto-generated method stub
		return new EntregaEventual();
	}

	@Override
	public void eliminar(EntregaEventual entidad) {
		// TODO Auto-generated method stub
		iEntregaEventualRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<EntregaEventual> entidades) {
		// TODO Auto-generated method stub
		iEntregaEventualRepository.delete(entidades);
	}
	
	@Override
	public EntregaEventual buscarEntregaEventualPorId(int id) {
		// TODO Auto-generated method stub
		return iEntregaEventualRepository.findById(id);
	}

	@Override
	public List<EntregaEventual> buscarEntregaEventualPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return iEntregaEventualRepository.findByFecha(fecha);
	}

	@Override
	public List<EntregaEventual> buscarEntregaEventualPorStatus(String status) {
		// TODO Auto-generated method stub
		return iEntregaEventualRepository.findByStatus(status);
	}
	
	@Override
	public List<EntregaEventual> buscarPorX(String parametro) {
		return iEntregaEventualRepository.buscarPorX(parametro);
	}
	
	public List<EntregaEventual> buscarPorRangoFecha(Date desde,Date hasta) {
		return iEntregaEventualRepository.findByFechaBetween(desde, hasta);
	}

}
