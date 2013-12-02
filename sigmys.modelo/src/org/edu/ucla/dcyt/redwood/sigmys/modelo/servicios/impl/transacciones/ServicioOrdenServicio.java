package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.OrigenCompra;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRecibido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IOrdenServicioRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioOrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("servicioOrdenServicio")
public  class ServicioOrdenServicio implements IServicioOrdenServicio {

	@Autowired
	IOrdenServicioRepository iOrdenServicioRepository;
	
	@Override
	public List<OrdenServicio> buscarTodos() {
		return iOrdenServicioRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iOrdenServicioRepository.findAll().size();
	}

	@Override
	public OrdenServicio guardar(OrdenServicio entidad) {
		return iOrdenServicioRepository.save(entidad);
	}

	@Override
	public OrdenServicio crear() {
		return new OrdenServicio();
	}

	@Override
	public void eliminar(OrdenServicio entidad) {
		iOrdenServicioRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<OrdenServicio> entidades) {
		iOrdenServicioRepository.delete(entidades);
	}

	@Override
	public OrdenServicio buscarOrdenServicioPorId(int id) {
		return iOrdenServicioRepository.findById(id);
	}

	@Override
	public OrdenServicio buscarOrdenServicioPorDescripcion(String descripcion) {
		return iOrdenServicioRepository.findByDescripcion(descripcion);
	}
	@Override
	public OrdenServicio buscarOrdenServicioPorStatus(String Status) {
		return iOrdenServicioRepository.findByStatus(Status);
	}

	@Override
	public List<OrdenServicio> buscarOrdenServicioPorDescripcionSimilares(String descripcion) {
		return iOrdenServicioRepository.findByDescripcionLike(descripcion);
	}

	/*@Override
	public List<OrdenServicio> buscarOrdenServicioPorFecha(Date fecha){
		List<OrdenServicio> OrdenServiciofecha = iOrdenServicioRepository.findAll();
		return null;
	}*/

	@Override
	public List<OrdenServicio> buscarOrdenServicioPorOrigencompra(OrigenCompra origencompra){
		return iOrdenServicioRepository.findByOrigencompra(origencompra);
	}

	@Override
	public List<OrdenServicio> buscarOrdenServicioPorFecha(Date fecha) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<OrdenServicio> buscarPorX(String parametro) {
		return iOrdenServicioRepository.buscarPorX(parametro);
	}

	@Override
	public OrdenServicio buscarOrdenServicioPorNumeroCompromiso(
			String numerocompromiso) {
		// TODO Auto-generated method stub
		return iOrdenServicioRepository.findByNumerocompromiso(numerocompromiso);
	}
	/**
	 * 
	 * @param parametros parametros de filtrado de Ordenes de Servicio
	 * @return lista de Ordenes de servicios filtradas por los parametros enviados
	 * @author Xavier Chavez
	 */
	public List<OrdenServicio> buscarPorParametros(Map parametros){
		/*
		 * Aqui debe programar el filtrado de la lista y por ultimo devolverla ya filtrada
		 */
		List<OrdenServicio>  ordenesServicio= buscarTodos();
		List<OrdenServicio> lstCompNro = new ArrayList<OrdenServicio>();
		List<OrdenServicio> lstCompTipoMat = new ArrayList<OrdenServicio>();
		List<OrdenServicio> lstCompOrigenCom = new ArrayList<OrdenServicio>();
		List<OrdenServicio> lstCompFecha = new ArrayList<OrdenServicio>();
		
		String nrocompromiso = (String) parametros.get("nrorequisicion");
		TipoMaterial tipomaterial = (TipoMaterial) parametros.get("tipomaterial");
		OrigenCompra origencompra = (OrigenCompra) parametros.get("origencompra");
		Date desde = (Date) parametros.get("desde");
		Date hasta = (Date) parametros.get("hasta");
		
		if(nrocompromiso!=null){
			OrdenServicio ordenServicio=new OrdenServicio();
			ordenServicio=iOrdenServicioRepository.findByNumerocompromiso(nrocompromiso);
			lstCompNro.add(ordenServicio);
			ordenesServicio.retainAll(lstCompNro);
		}
		if (tipomaterial != null) {
			lstCompTipoMat = buscarPorTipoMaterial(tipomaterial);
				ordenesServicio.retainAll(lstCompTipoMat);
		}
		if (origencompra != null) {
			lstCompOrigenCom = iOrdenServicioRepository.findByOrigencompra(origencompra);	
				ordenesServicio.retainAll(lstCompOrigenCom);
		}

		if (desde != null && hasta != null) {
			lstCompFecha = iOrdenServicioRepository.findByFechaBetween(desde, hasta);
				ordenesServicio.retainAll(lstCompFecha);
		}

	
			return ordenesServicio;
	}
	
	public List<OrdenServicio> buscarPorTipoMaterial(TipoMaterial tipomaterial) {
		List<OrdenServicio> ordenservicio = buscarTodos();
		List<OrdenServicio> listatipos = new ArrayList<OrdenServicio>();
		for (int i = 0; i < ordenservicio.size(); i++) {
			List<MaterialRecibido> items = ordenservicio.get(i).getMaterialesrecibidos();
			for (int j=0; j<items.size();j++) {
				Material material = items.get(j).getMaterial();
			if (material.getTipomaterial().getId() == tipomaterial.getId()) {
					listatipos.add(ordenservicio.get(i));
					break;
				}
			}
		}
		return listatipos;
	}
	
	public List<OrdenServicio> buscarPorFechaEntre(Date desde, Date hasta){
	 return iOrdenServicioRepository.findByFechaBetween(desde, hasta);
	}
	public List<OrdenServicio> buscarPorFechaDesde(Date desde){
		 return iOrdenServicioRepository.buscarPorFechaDesde(desde);
		}
	public List<OrdenServicio> buscarPorFechaHasta(Date hasta){
		 return iOrdenServicioRepository.buscarPorFechaHasta(hasta);
		}

	@Override
	public OrdenServicio buscarOrdenServicioPorNumero(String numero) {
		// TODO Auto-generated method stub
		return iOrdenServicioRepository.findByNumero(numero);
	}
	
	/**
	 * 
	 * @param parametros
	 *            parametros de filtrado de Requisiciones
	 * @return lista de Ordenes de Servicio filtradas por los parametros enviados
	 * @author Xavier Chavez
	 */
	public List<OrdenServicio> buscarPorParametrosEstadisticos(Map parametros) {
		List<OrdenServicio> ordenesServicio = iOrdenServicioRepository.findAll();
		
		List<OrdenServicio> lstCompFecha = new ArrayList<OrdenServicio>();
		List<OrdenServicio> lstCompTipoMat = new ArrayList<OrdenServicio>();
		List<OrdenServicio> lstCompMat = new ArrayList<OrdenServicio>();
		Date desde = (Date) parametros.get("desde");
		Date hasta = (Date) parametros.get("hasta");
		Material material=(Material) parametros.get("material");
		List<TipoMaterial> tipo=(List<TipoMaterial>) parametros.get("tipo");
		
		if (desde != null && hasta != null) {
			lstCompFecha = iOrdenServicioRepository.findByFechaBetween(desde, hasta);
			ordenesServicio.retainAll(lstCompFecha);
		}
		if(material!=null){
			lstCompMat=buscarPorMaterial(material);
		    ordenesServicio.retainAll(lstCompMat);
		}
		if (tipo!=null) {
			lstCompTipoMat = buscarPorTipoMaterial(tipo);
			ordenesServicio.retainAll(lstCompTipoMat);
				for(int i=0; i<lstCompTipoMat.size(); i++){
					if(ordenesServicio.indexOf(lstCompTipoMat.get(i))!=-1){
						int index=ordenesServicio.indexOf(lstCompTipoMat.get(i));
						ordenesServicio.get(index).setMaterialesrecibidos(lstCompTipoMat.get(i).getMaterialesrecibidos());
					}
				}
		}
		
		return ordenesServicio;
	}
	public List<OrdenServicio> buscarPorMaterial(Material material){
		List<OrdenServicio> ordenes=iOrdenServicioRepository.findAll();
    	List<OrdenServicio> ordenes1 =new ArrayList<OrdenServicio>();
    	for(int i=0; i<ordenes.size();i++){
			List<MaterialRecibido> items=ordenes.get(i).getMaterialesrecibidos();
		    	for(int it=0;it<items.size();it++){
					MaterialRecibido materialRecibido=items.get(it);
					if(materialRecibido.getMaterial().getId()==material.getId()){
						ordenes1.add(ordenes.get(i));
						break;
					}
			}
		}
    	return ordenes1;
	}

	public List<OrdenServicio> buscarPorTipoMaterial(List<TipoMaterial> tipo){
		List<OrdenServicio> ordenes = iOrdenServicioRepository.findAll();
		List<OrdenServicio> ordenes1 =new ArrayList<OrdenServicio>();
		List<MaterialRecibido> materiales= new ArrayList<MaterialRecibido>();
		for(int i=0; i<ordenes.size();i++){
			List<MaterialRecibido> items=ordenes.get(i).getMaterialesrecibidos();
			List<MaterialRecibido> items2=new ArrayList<MaterialRecibido>();
			for(int j=0; j<tipo.size();j++){
				for(int k=0;k<items.size();k++){
					MaterialRecibido materialRecibido=items.get(k);
					if(materialRecibido.getMaterial().getTipomaterial().getId()==tipo.get(j).getId()){
						items2.add(materialRecibido);		
					}
				}
			}
			if(items2.size()>0){
				ordenes.get(i).setMaterialesrecibidos(items2);
				ordenes1.add(ordenes.get(i));
			}
		}	
		return ordenes1;		
	}
	
	public List<String> historicoOrdenServicio(Date date){
		List<String> inserts=new ArrayList<String>();
		String insert;
		List<OrdenServicio> ordenServicios=iOrdenServicioRepository.buscarPorFechaHasta(date);
	    for(int i=0;i<ordenServicios.size();i++){
	    	OrdenServicio ordenServicio=ordenServicios.get(i);
	    	if(ordenServicio.getDescripcion()!=null){
	    		insert="INSERT INTO sigmys.ordenservicio(id, descripcion, fecha, numero, numerocompromiso, status, origencompra,  proveedor)"
	    			+"VALUES ("+ordenServicio.getId()+",'"+ordenServicio.getDescripcion()+"','"+ordenServicio.getFecha()+"','"+ordenServicio.getNumero()+"','"+ordenServicio.getNumerocompromiso()+"','"+ordenServicio.getStatus()+"',"+ordenServicio.getOrigencompra().getId()+","+ordenServicio.getProveedor().getId()+");";
	    	}else{
	    		insert="INSERT INTO sigmys.ordenservicio(id, fecha, numero, numerocompromiso, status, origencompra,  proveedor)"
	    	        +"VALUES ("+ordenServicio.getId()+",'"+ordenServicio.getFecha()+"','"+ordenServicio.getNumero()+"','"+ordenServicio.getNumerocompromiso()+"','"+ordenServicio.getStatus()+"',"+ordenServicio.getOrigencompra().getId()+","+ordenServicio.getProveedor().getId()+");";
	    	}
	    	inserts.add(insert);
	    	List<MaterialRecibido> materialRecibidos=ordenServicio.getMaterialesrecibidos();
	    	for(int j=0; j<materialRecibidos.size();j++){
	    		MaterialRecibido materialRecibido=materialRecibidos.get(j);
	    		insert="INSERT INTO sigmys.materialrecibido( id, cantidad, material, ordendeservicio)"
	    	     +"VALUES ("+materialRecibido.getId()+","+materialRecibido.getCantidad()+","+materialRecibido.getMaterial().getId()+","+materialRecibido.getOrdendeservicio().getId()+");";
	    		inserts.add(insert);
	    	}
	    	iOrdenServicioRepository.delete(ordenServicio);
	    }
	    return inserts;
	}

}
