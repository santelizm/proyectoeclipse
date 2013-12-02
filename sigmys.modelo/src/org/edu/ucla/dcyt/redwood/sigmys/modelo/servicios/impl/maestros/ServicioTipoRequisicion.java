package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.ITipoRequisicionRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioTipoRequisicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import com.sistema.modelo.servicios.maestros.IServicioManipularTipoRequisicion;
@Service("servicioTipoRequisicion")
public class ServicioTipoRequisicion implements IServicioTipoRequisicion{

	
	
	@Autowired
	ITipoRequisicionRepository tipoRequisicionRep;
	@Override
	public List<TipoRequisicion> buscarTodos() {
		// TODO Auto-generated method stub
		return tipoRequisicionRep.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return tipoRequisicionRep.findAll().size();
	}

	@Override
	public TipoRequisicion guardar(TipoRequisicion entidad) {
		// TODO Auto-generated method stub
		return tipoRequisicionRep.save(entidad);
	}

	@Override
	public TipoRequisicion crear() {
		// TODO Auto-generated method stub
		return new TipoRequisicion();
	}

	@Override
	public void eliminar(TipoRequisicion entidad) {
		// TODO Auto-generated method stub
		tipoRequisicionRep.delete(entidad);
		
	}

	@Override
	public void eliminar(Collection<TipoRequisicion> entidades) {
		// TODO Auto-generated method stub
		
		tipoRequisicionRep.delete(entidades);
	}

	@Override
	public TipoRequisicion BuscarRequisicionPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return tipoRequisicionRep.findByNombre(nombre);
		
	}

	@Override
	public List<TipoRequisicion> BuscarRequisicionesPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return tipoRequisicionRep.findByNombreLike(nombre);
		

	}
	public List<TipoRequisicion> buscarPorX(String Parametro){
		return tipoRequisicionRep.buscarPorX(Parametro);
	}
}
