package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ClasificacionObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ReferenciaObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRecibido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ObservacionEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IObservacionEntregaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioObservacionEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioObservacionEntrega")
public class ServicioObservacionEntrega implements IServicioObservacionEntrega {

	
	@Autowired
	IObservacionEntregaRepository iObservacionEntregaRepository;	
	
	@Override
	public List<ObservacionEntrega> buscarTodos() {
		// TODO Auto-generated method stub
		return iObservacionEntregaRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iObservacionEntregaRepository.findAll().size();
	}

	@Override
	public ObservacionEntrega guardar(ObservacionEntrega entidad) {
		// TODO Auto-generated method stub
		return iObservacionEntregaRepository.save(entidad);
	}

	@Override
	public ObservacionEntrega crear() {
		// TODO Auto-generated method stub
		return new ObservacionEntrega();
	}

	@Override
	public void eliminar(ObservacionEntrega entidad) {
		// TODO Auto-generated method stub
		iObservacionEntregaRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<ObservacionEntrega> entidades) {
		// TODO Auto-generated method stub
		iObservacionEntregaRepository.delete(entidades);
		
	}

	@Override
	public ObservacionEntrega buscarPorId(int id) {
		// TODO Auto-generated method stub
		return iObservacionEntregaRepository.findById(id);
	}

	@Override
	public List<ObservacionEntrega> buscarPorTipoobservacioncomo(
			TipoObservacion tipoobservacion) {
		// TODO Auto-generated method stub
		return iObservacionEntregaRepository.findByTipoobservacion(tipoobservacion);
	}
	
	@Override
	public List<ObservacionEntrega> buscarPorUnidadorganizativacomo(
			UnidadOrganizativa unidadorganizativa) {
		// TODO Auto-generated method stub
		return iObservacionEntregaRepository.findByUnidadorganizativa(unidadorganizativa);
	}

	@Override
	public List<ObservacionEntrega> buscarPorReferenciaObservacioncomo (ReferenciaObservacion referenciaobservacion)
	{
		return iObservacionEntregaRepository.findByReferenciaobservacion(referenciaobservacion);
	}
	
	@Override
	public List<ObservacionEntrega> buscarPorClasificacionObservacioncomo (ClasificacionObservacion clasificacionobservacion)
	{	
		return iObservacionEntregaRepository.findByClasificacionobservacion(clasificacionobservacion);
	}
	
	

	@Override
	public List<ObservacionEntrega> buscarPorX(String parametro){
		return iObservacionEntregaRepository.buscarPorX(parametro);
	}
	
	public List<ObservacionEntrega> buscarPorFechaEntre(Date desde, Date hasta){
		 return iObservacionEntregaRepository.findByFechaBetween(desde, hasta);
		}
	
	public List<ObservacionEntrega> buscarPorFechaDesde(Date desde){
		 return iObservacionEntregaRepository.buscarPorFechaDesde(desde);
		}
	public List<ObservacionEntrega> buscarPorFechaHasta(Date hasta){
		 return iObservacionEntregaRepository.buscarPorFechaHasta(hasta);
		}
	@Override
	public List<ObservacionEntrega> buscarPorStatus(String status) {
		// TODO Auto-generated method stub
		return iObservacionEntregaRepository.findByStatus(status);
	}
	
	

	@Override
	public List<ObservacionEntrega> buscarPorClasificacionYStatus (ClasificacionObservacion clasificacionobservacion, String status){
		return iObservacionEntregaRepository.findByClasificacionobservacionAndStatus(clasificacionobservacion, status);
	}
	
	

}
