package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IRequisiconRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioRequisicion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioRequisicion")
public class ServicioRequisicion implements IServicioRequisicion {

	@Autowired
	IRequisiconRepository iRequisiconRepository;

	@Override
	public List<Requisicion> buscarTodos() {
		return iRequisiconRepository.findAll();
	}

	@Override
	public int contarTodos() {
		return iRequisiconRepository.findAll().size();
	}

	@Override
	public Requisicion guardar(Requisicion entidad) {
		return iRequisiconRepository.save(entidad);
	}

	@Override
	public Requisicion crear() {
		return new Requisicion();
	}

	@Override
	public void eliminar(Requisicion entidad) {
		iRequisiconRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<Requisicion> entidades) {
		iRequisiconRepository.delete(entidades);
	}

	@Override
	public Requisicion buscarRequisicionPorId(int id) {
		return iRequisiconRepository.findById(id);
	}

	@Override
	public Requisicion buscarRequisicionPorNumero(String numero) {
		return iRequisiconRepository.findByNumero(numero);
	}

	@Override
	public List<Requisicion> buscarRequisicionesPorObservacionesSimilares(
			String observacion) {
		return iRequisiconRepository.findByObservacionLike(observacion);
	}

	@Override
	public List<Requisicion> buscarRequisicionesPorTipoRequisicion(
			TipoRequisicion tiporequisicion) {
		return iRequisiconRepository.findByTiporequisicion(tiporequisicion);
	}

	@Override
	public List<Requisicion> buscarRequisicionesPorEstadoRequisicion(
			EstadoRequisicion estadorequisicion) {
		return iRequisiconRepository.findByEstadorequisicion(estadorequisicion);
	}

	@Override
	public List<Requisicion> buscarPorX(String parametro) {
		return iRequisiconRepository.buscarPorX(parametro);
	}

	@Override
	public List<Requisicion> buscarPorStatus(String status) {
		// TODO Auto-generated method stub
		return iRequisiconRepository.findByStatus(status);
	}

	/**
	 * 
	 * @param parametros
	 *            parametros de filtrado de Requisiciones
	 * @return lista de Requisiciones filtradas por los parametros enviados
	 * @author Xavier Chavez
	 */
	public List<Requisicion> buscarPorParametros(Map parametros) {
		/*
		 * Aqui debe programar el filtrado de la lista y por ultimo devolverla
		 * ya filtrada
		 */
		List<Requisicion> requisiciones = iRequisiconRepository.buscarPorStatusRoF();
		
		List<Requisicion> lstCompNro= new ArrayList<Requisicion>();
		List<Requisicion> lstCompEstReq = new ArrayList<Requisicion>();
		List<Requisicion> lstCompTipoReq = new ArrayList<Requisicion>();
		List<Requisicion> lstCompTipoMat = new ArrayList<Requisicion>();
		List<Requisicion> lstCompEstMat = new ArrayList<Requisicion>();
		List<Requisicion> lstCompFecha = new ArrayList<Requisicion>();		
		
		String nrorequisicion = (String) parametros.get("nrorequisicion");
		EstadoRequisicion estadorequisicion = (EstadoRequisicion) parametros.get("estadorequisicion");
		TipoRequisicion tiporequisicion = (TipoRequisicion) parametros.get("tiporequisicion");
		TipoMaterial tipomaterial = (TipoMaterial) parametros.get("tipomaterial");
		EstadoMaterialRequerido estadomaterialrequerido = (EstadoMaterialRequerido) parametros.get("estadomaterialrequerido");
		Date desde = (Date) parametros.get("desde");
		Date hasta = (Date) parametros.get("hasta");
		
		if(nrorequisicion!=null){
			Requisicion requisicion=new Requisicion();
			requisicion=iRequisiconRepository.findByNumero(nrorequisicion);
			lstCompNro.add(requisicion);
			requisiciones.retainAll(lstCompNro);
		}
		if (tiporequisicion != null) {
			lstCompTipoReq = iRequisiconRepository.findByTiporequisicion(tiporequisicion);
			requisiciones.retainAll(lstCompTipoReq);
		}
		if (estadorequisicion != null) {
			lstCompEstReq = iRequisiconRepository.findByEstadorequisicion(estadorequisicion);
			requisiciones.retainAll(lstCompEstReq);	
		}

		if (tipomaterial != null) {
			lstCompTipoMat = buscarPorTipoMaterial(tipomaterial);
			requisiciones.retainAll(lstCompTipoMat);
		}
		if (estadomaterialrequerido != null) {
			lstCompEstMat = buscarPorEstadoMaterialRequerido(estadomaterialrequerido);	
			requisiciones.retainAll(lstCompEstMat);
		}

		if (desde != null && hasta != null) {
			lstCompFecha = iRequisiconRepository.findByFechaBetween(desde, hasta);
			requisiciones.retainAll(lstCompFecha);
		}
		return requisiciones;		
	}

	public List<Requisicion> buscarPorEstadoMaterialRequerido(
			EstadoMaterialRequerido estadomaterial) {

		List<Requisicion> requisicion = buscarTodos();
		List<Requisicion> listaestados = new ArrayList<Requisicion>();
		for (int i = 0; i < requisicion.size(); i++) {
			Set<MaterialRequerido> items = requisicion.get(i)
					.getMaterialesrequeridos();
			for (Iterator<MaterialRequerido> it = items.iterator(); it
					.hasNext();) {
				EstadoMaterialRequerido estadomaterial1 = it.next()
						.getEstadomaterialrequerido();
				if (estadomaterial1.getId() == estadomaterial.getId()) {
					listaestados.add(requisicion.get(i));
					break;
				}
			}
		}
		return listaestados;
	}
	
	@Override
	public List<Requisicion> buscarRequisicionPorFechaEntre(
			Date fechaDesde, Date fechaHasta) {
		// TODO Auto-generated method stub
		return iRequisiconRepository.findByFechaBetween(fechaDesde, fechaHasta);
	}

	public List<Requisicion> buscarPorTipoMaterial(TipoMaterial tipomaterial) {
		List<Requisicion> requisicion = buscarTodos();
		List<Requisicion> listatipos = new ArrayList<Requisicion>();
		for (int i = 0; i < requisicion.size(); i++) {
			Set<MaterialRequerido> items = requisicion.get(i)
					.getMaterialesrequeridos();
			for (Iterator<MaterialRequerido> it = items.iterator(); it
					.hasNext();) {
				Material material = it.next().getMaterial();
				if (material.getTipomaterial().getId() == tipomaterial.getId()) {
					listatipos.add(requisicion.get(i));
					break;
				}
			}
		}
		return listatipos;
	}
	public List<Requisicion> buscarPorFechaEntre(Date desde, Date hasta) {
	   return iRequisiconRepository.findByFechaBetween(desde, hasta);
	}	
	public List<Requisicion> buscarPorFechaDesde(Date hasta) {
		   return iRequisiconRepository.buscarPorFechaAntes(hasta);
		}
	public List<Requisicion> buscarPorFechaHasta(Date desde) {
		   return iRequisiconRepository.buscarPorFechaDespues(desde);
		}
	
	/**
	 * 
	 * @param parametros
	 *            parametros de filtrado de Requisiciones
	 * @return lista de Requisiciones filtradas por los parametros enviados
	 * @author Xavier Chavez
	 */
	public List<Requisicion> buscarPorParametrosEstadisticos(Map parametros) {		
		List<Requisicion> requisiciones = iRequisiconRepository.buscarPorStatusRoF();
		
		List<Requisicion> lstCompTipoMat = new ArrayList<Requisicion>();
		List<Requisicion> lstCompFecha = new ArrayList<Requisicion>();
		List<Requisicion> lstCompMaterial=new ArrayList<Requisicion>();
		Date desde = (Date) parametros.get("desde");
		Date hasta = (Date) parametros.get("hasta");
		List<TipoMaterial> tipo=(List<TipoMaterial>) parametros.get("tipo");
		
		Material material=(Material) parametros.get("material");
		
		if (desde != null && hasta != null) {
			lstCompFecha = iRequisiconRepository.findByFechaBetween(desde, hasta);
			requisiciones.retainAll(lstCompFecha);
		}
		
		if(material!=null){
			lstCompMaterial=buscarPorMaterial(material);
			requisiciones.retainAll(lstCompMaterial);
		}
		
		if (tipo!=null) {
			lstCompTipoMat = buscarPorTipoMaterial(tipo);
			requisiciones.retainAll(lstCompTipoMat);
				for(int i=0; i<lstCompTipoMat.size(); i++){
					if(requisiciones.indexOf(lstCompTipoMat.get(i))!=-1){
						int index=requisiciones.indexOf(lstCompTipoMat.get(i));
						requisiciones.get(index).setMaterialesrequeridos(lstCompTipoMat.get(i).getMaterialesrequeridos());
					}
				}
		}
		return requisiciones;
	}
    public List<Requisicion> buscarPorMaterial(Material material){
    	List<Requisicion> requisiciones=iRequisiconRepository.buscarPorStatusRoF();
    	List<Requisicion> requisiciones1 =new ArrayList<Requisicion>();
    	for(int i=0; i<requisiciones.size();i++){
			Set<MaterialRequerido> items=requisiciones.get(i).getMaterialesrequeridos();
		    	for(Iterator<MaterialRequerido> it=items.iterator();it.hasNext();){
					MaterialRequerido materialRequerido=it.next();
					if(materialRequerido.getMaterial().getId()==material.getId()){
						requisiciones1.add(requisiciones.get(i));
						break;
					}
			}
		}
    	return requisiciones1;
	}
    
	public List<Requisicion> buscarPorTipoMaterial(List<TipoMaterial> tipo){
		List<Requisicion> requisiciones = iRequisiconRepository.buscarPorStatusRoF();
		List<Requisicion> requisiciones1 =new ArrayList<Requisicion>();
		List<MaterialRequerido> materiales= new ArrayList<MaterialRequerido>();
		for(int i=0; i<requisiciones.size();i++){
			Set<MaterialRequerido> items=requisiciones.get(i).getMaterialesrequeridos();
			Set<MaterialRequerido> items2=new HashSet<MaterialRequerido>();
			for(int j=0; j<tipo.size();j++){
				for(Iterator<MaterialRequerido> it=items.iterator();it.hasNext();){
					MaterialRequerido materialRequerido=it.next();
					if(materialRequerido.getMaterial().getTipomaterial().getId()==tipo.get(j).getId()){
						items2.add(materialRequerido);		
					}
				}
			}
			if(items2.size()>0){
				requisiciones.get(i).setMaterialesrequeridos(items2);
				requisiciones1.add(requisiciones.get(i));
			}
		}
		
		return requisiciones1;
	}
	
	public List<String> historicoRequisicion(Date date){
		List<String> inserts=new ArrayList<String>();
		String insert;
		List<Requisicion> requisiciones = iRequisiconRepository.buscarPorFechaHasta(date);
		for(int i=0; i<requisiciones.size();i++){
			Requisicion requisicion=requisiciones.get(i);
			if(requisicion.getObservacion()!=null){
			insert="INSERT INTO sigmys.requisicion(id, fecha, numero, observacion, status, estadorequisicion, tiporequisicion)"
			    +"VALUES ("+requisicion.getId()+",'"+requisicion.getFecha()+"','"+requisicion.getNumero()+"','"+requisicion.getObservacion()+"','"+requisicion.getStatus()+"',"+requisicion.getEstadorequisicion().getId()+","+requisicion.getTiporequisicion().getId()+");";
			}else{
				insert="INSERT INTO sigmys.requisicion(id, fecha, numero, status, estadorequisicion, tiporequisicion)"
				    +"VALUES ("+requisicion.getId()+",'"+requisicion.getFecha()+"','"+requisicion.getNumero()+"','"+requisicion.getStatus()+"',"+requisicion.getEstadorequisicion().getId()+","+requisicion.getTiporequisicion().getId()+");";
			}
			inserts.add(insert);
			Set<MaterialRequerido> materialRequeridos=requisicion.getMaterialesrequeridos();
			for(Iterator<MaterialRequerido> it=materialRequeridos.iterator();it.hasNext();){
				MaterialRequerido materialRequerido=it.next();
				insert="INSERT INTO sigmys.materialrequerido(id, cantidad, estadomaterialrequerido, material, requisicion)"
		            +"VALUES ("+materialRequerido.getId()+","+materialRequerido.getCantidad()+","+materialRequerido.getEstadomaterialrequerido().getId()+","+materialRequerido.getMaterial().getId()+","+materialRequerido.getRequisicion().getId()+");";
				inserts.add(insert);
			}
			iRequisiconRepository.delete(requisicion);
		}
		return inserts;
	}
	
	public List<Requisicion> buscarTodosExceptoTotalmenteAprobada(){
		List<Requisicion> todos = buscarTodos();
		List<Requisicion> resultado = new ArrayList<Requisicion>();

	   for(int i = 0;i < todos.size();i++)
	       if( ! todos.get(i).getEstadorequisicion().getNombre().equals("TOTALMENTE APROBADA") && todos.get(i).getStatus().equals("F"))
	            resultado.add(todos.get(i));

	    return resultado;
	}

	@Override
	public List<Requisicion> buscarPorStatusNoIgualA(String status) {
		// TODO Auto-generated method stub
		return iRequisiconRepository.findByStatusNotLike(status);
	}
	
}
