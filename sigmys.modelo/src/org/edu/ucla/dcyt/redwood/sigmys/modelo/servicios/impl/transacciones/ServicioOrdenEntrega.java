package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialOrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.UnidadOrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IOrdenEntregaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IUnidadOrdenEntregaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioOrdenEntrega;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("servicioOrdenEntrega")
public class ServicioOrdenEntrega implements IServicioOrdenEntrega{

	@Autowired
	IOrdenEntregaRepository iOrdenEntregaRepository;
	
	@Autowired
	IUnidadOrdenEntregaRepository iUnidadOrdenEntregaRepository;
	
	@Override
	public List<OrdenEntrega> buscarTodos() {
		// TODO Auto-generated method stub
		return iOrdenEntregaRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iOrdenEntregaRepository.findAll().size();
	}

	@Override
	public OrdenEntrega guardar(OrdenEntrega entidad) {
		// TODO Auto-generated method stub
		return iOrdenEntregaRepository.save(entidad);
	}
	public OrdenEntrega entregar(OrdenEntrega entidad) {
		return iOrdenEntregaRepository.save(entidad);
	}
	@Override
	public OrdenEntrega crear() {
		// TODO Auto-generated method stub
		return new OrdenEntrega();
	}

	@Override
	public void eliminar(OrdenEntrega entidad) {
		// TODO Auto-generated method stub
		iOrdenEntregaRepository.delete(entidad);
		
	}

	@Override
	public void eliminar(Collection<OrdenEntrega> entidades) {
		// TODO Auto-generated method stub
		iOrdenEntregaRepository.delete(entidades);
	}

	@Override
	public OrdenEntrega buscarOrdenEntregaPorId(int id) {
		// TODO Auto-generated method stub
		return iOrdenEntregaRepository.findById(id);
	}

	@Override
	public List<OrdenEntrega> buscarOrdenEntregaPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return iOrdenEntregaRepository.findByFecha(fecha);
	}

	@Override
	public List<OrdenEntrega> buscarOrdenEntregaPorStatus(String status) {
		// TODO Auto-generated method stub
		return iOrdenEntregaRepository.findByStatus(status);
	}
	
	@Override
	public List<OrdenEntrega> buscarPorX(String parametro) {
		return iOrdenEntregaRepository.buscarPorX(parametro);
	}
	
	
	public List<OrdenEntrega> buscarPorMaterial(Material material){
		List<OrdenEntrega> lstOrdenes = buscarTodos();
		List<OrdenEntrega> lstMaterial = new ArrayList<OrdenEntrega>();
		for (int i=0; i<lstOrdenes.size(); i++){
			Set<MaterialOrdenEntrega> setMateriales = lstOrdenes.get(i).getMaterialesordenentrega();
			for(Iterator<MaterialOrdenEntrega> it = setMateriales.iterator(); it.hasNext();)
			{
				Material materialSiguiente = it.next().getMaterial();
				if(materialSiguiente.getId() == material.getId()){
					lstMaterial.add(lstOrdenes.get(i));
					break;
				}
			}
		}
		return lstMaterial;
	}
	


	public List<OrdenEntrega> buscarPorTipoMaterial(TipoMaterial tipoMaterial){
		List<OrdenEntrega> lstOrdenes = buscarTodos();
		List<OrdenEntrega> lstTipoMaterial = new ArrayList<OrdenEntrega>();
		for (int i=0; i<lstOrdenes.size(); i++){
			Set<MaterialOrdenEntrega> setMateriales = lstOrdenes.get(i).getMaterialesordenentrega();
			for(Iterator<MaterialOrdenEntrega> it = setMateriales.iterator(); it.hasNext();)
			{
				Material materialSiguiente = it.next().getMaterial();
				if(materialSiguiente.getTipomaterial().getId() == tipoMaterial.getId()){
					lstTipoMaterial.add(lstOrdenes.get(i));
					break;
				}
			}
		}	
		return lstTipoMaterial;
	}

	
	public List<OrdenEntrega> buscarPorUnidadOrganizativa(UnidadOrganizativa unidadOrganizativa){
		List<OrdenEntrega> lstOrdenes = buscarTodos();
		List<OrdenEntrega> lstUnidadOrganizativa = new ArrayList<OrdenEntrega>();
		for (int i=0; i<lstOrdenes.size(); i++){
			Set<UnidadOrdenEntrega> setUnidades = lstOrdenes.get(i).getUnidadesordenentrega();
			for(Iterator<UnidadOrdenEntrega> it = setUnidades.iterator(); it.hasNext();)
			{
				UnidadOrganizativa unidadSiguiente = it.next().getUnidadorganizativa();
				if(unidadSiguiente.getId() == unidadOrganizativa.getId()){
					lstUnidadOrganizativa.add(lstOrdenes.get(i));
					break;
				}
			}
		}
		return lstUnidadOrganizativa;
	}
	

	
	/**
	 * 
	 * @param parametros parametros de filtrado de Requisiciones
	 * @return lista de Requisiciones filtradas por los parametros enviados
	 * @author Elam Torres
	 */
	public List<OrdenEntrega> buscarPorParametros(Map parametros){
		/*
		 * Aqui debe programar el filtrado de la lista y por ultimo devolverla ya filtrada
		 */
		Material material = (Material) parametros.get("material");
		TipoMaterial tipoMaterial = (TipoMaterial) parametros.get("tipomaterial");
		Date fechaDesde = (Date) parametros.get("desde");
		Date fechaHasta = (Date) parametros.get("hasta");
		UnidadOrganizativa unidadOrganizativa=(UnidadOrganizativa) parametros.get("unidadorganizativa");
		
		List<OrdenEntrega> lstOrdenes = buscarOrdenEntregaPorStatus("B");
		
		//Comp = Comparar
		List<OrdenEntrega> lstCompMaterial = new ArrayList<OrdenEntrega>();
		List<OrdenEntrega> lstCompTipoMat = new ArrayList<OrdenEntrega>();
		List<OrdenEntrega> lstCompFecha = new ArrayList<OrdenEntrega>();
		List<OrdenEntrega> lstCompUnidad = new ArrayList<OrdenEntrega>();
		
		if(material!=null){
			lstCompMaterial = buscarPorMaterial(material);
			lstOrdenes.retainAll(lstCompMaterial);
		}
				
		if(tipoMaterial!=null){
			lstCompTipoMat= buscarPorTipoMaterial(tipoMaterial);
				lstOrdenes.retainAll(lstCompTipoMat);
		}
		
		if((fechaDesde!=null)&& (fechaHasta!=null)){
			lstCompFecha = iOrdenEntregaRepository.findByFechaBetween(fechaDesde, fechaHasta);
				lstOrdenes.retainAll(lstCompFecha);
		}
		if(unidadOrganizativa!=null){
			lstCompUnidad= buscarPorUnidadOrganizativa(unidadOrganizativa);
			lstOrdenes.retainAll(lstCompUnidad);
		}	
			return lstOrdenes;	
	}
	

	
	@Override
	public List<OrdenEntrega> buscarOrdenEntregaPorFechaEntre(
			Date fechaDesde, Date fechaHasta) {
		// TODO Auto-generated method stub
		return iOrdenEntregaRepository.findByFechaBetween(fechaDesde, fechaHasta);
	}
	
	
	public List<String> historicoOrdenEntrega(Date date){
		List<String> inserts=new ArrayList<String>();
		String insert;
		List<OrdenEntrega> ordenesE=iOrdenEntregaRepository.buscarPorFechaHasta(date);
		for(int i=0;i<ordenesE.size();i++){
			OrdenEntrega ordenEntrega=ordenesE.get(i);
			if(ordenEntrega.getObservacionentrega()!=null){
			insert="INSERT INTO sigmys.ordenentrega(id, fecha, numero, status, observacionentrega)"
			    +"VALUES ("+ordenEntrega.getId()+",'"+ordenEntrega.getNumero()+"','"+ordenEntrega.getNumero()+"','"+ordenEntrega.getStatus()+"','"+ordenEntrega.getObservacionentrega()+"');";
			}else{
				insert="INSERT INTO sigmys.ordenentrega(id, fecha, numero, status)"
				    +"VALUES ("+ordenEntrega.getId()+",'"+ordenEntrega.getFecha()+"','"+ordenEntrega.getNumero()+"','"+ordenEntrega.getStatus()+"');";
			}
		    inserts.add(insert);
		    Set<MaterialOrdenEntrega> materialOrdenEntregas=ordenEntrega.getMaterialesordenentrega();
		    for(Iterator<MaterialOrdenEntrega> it=materialOrdenEntregas.iterator();it.hasNext();){
		    	MaterialOrdenEntrega materialOrdenEntrega=it.next();
		    	insert="INSERT INTO sigmys.materialordenentrega(id, cantidadentregada, material, ordenentrega)"
		    	+"VALUES ("+materialOrdenEntrega.getId()+","+materialOrdenEntrega.getCantidadentregada()+","+materialOrdenEntrega.getMaterial().getId()+","+materialOrdenEntrega.getOrdenentrega().getId()+");";
		        inserts.add(insert);  
		    }
		    List<UnidadOrdenEntrega> unidadOrdenEntregas=iUnidadOrdenEntregaRepository.findByOrdenentrega(ordenEntrega);
		    for(int j=0;j<unidadOrdenEntregas.size();j++){
		    UnidadOrdenEntrega unidadOrdenEntrega=unidadOrdenEntregas.get(j);
		    insert="INSERT INTO sigmys.unidadordenentrega(id, destino, ordenentrega, unidadorganizativa)"
		    +"VALUES ("+unidadOrdenEntrega.getId()+","+unidadOrdenEntrega.getDestino().getId()+","+unidadOrdenEntrega.getOrdenEntrega().getId()+","+unidadOrdenEntrega.getUnidadorganizativa().getId()+");";
		    inserts.add(insert);   
		    }
		    iOrdenEntregaRepository.delete(ordenEntrega);
		}
		return inserts;
	}

	
}
