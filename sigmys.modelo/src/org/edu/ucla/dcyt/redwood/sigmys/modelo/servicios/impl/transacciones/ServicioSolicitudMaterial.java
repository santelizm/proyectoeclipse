package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.ISolicitudMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones.IServicioSolicitudMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioSolicitudMaterial")
public class ServicioSolicitudMaterial implements IServicioSolicitudMaterial{

	@Autowired
	ISolicitudMaterialRepository ISolicitudMaterialRepository;
	
	@Override
	public List<SolicitudMaterial> buscarTodos() {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findAll();
	}
	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findAll().size();
	}

	@Override
	public SolicitudMaterial guardar(SolicitudMaterial entidad) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.save(entidad);
	}

	@Override
	public SolicitudMaterial crear() {
		// TODO Auto-generated method stub
		return new SolicitudMaterial();
	}

	@Override
	public void eliminar(SolicitudMaterial entidad) {
		// TODO Auto-generated method stub
		ISolicitudMaterialRepository.delete(entidad);
		
	}

	@Override
	public void eliminar(Collection<SolicitudMaterial> entidades) {
		// TODO Auto-generated method stub
		ISolicitudMaterialRepository.delete(entidades);
		
	}

	@Override
	public SolicitudMaterial buscarSolicitudMaterialPorId(int id) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findById(id);
	}


	@Override
	public List<SolicitudMaterial> buscarSolicitudMaterialPorFechaemision(
			Date fechaemision) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findByFechaemision(fechaemision);
	}

	@Override
	public List<SolicitudMaterial> buscarSolicitudMaterialPorUnidadorganizativa(
			UnidadOrganizativa unidadorganizativa) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findByUnidadorganizativa(unidadorganizativa);
	}

	@Override
	public List<SolicitudMaterial> buscarSolicitudMaterialPorDestino(
			EspacioFisico destino) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findByDestino(destino);
	}
	@Override
	public List<SolicitudMaterial> buscarPorX(String parametro) {
		return ISolicitudMaterialRepository.buscarPorX(parametro);
	}
	@Override
	public List<SolicitudMaterial> buscarPorStatus(String status) {
		return ISolicitudMaterialRepository.findByStatus(status);
	}

	
	
	@Override
	public List<SolicitudMaterial> buscarPorSolicitudPendiente() {
		// TODO Auto-generated method stub
		List<SolicitudMaterial> solicitudes = ISolicitudMaterialRepository
				.findByStatus("E");
		List<SolicitudMaterial> porPendiente = ISolicitudMaterialRepository
				.findByStatus("E");
		porPendiente.clear();
		for (int i = 0; i < solicitudes.size(); i++) {
			Set<MaterialSolicitado> items = solicitudes.get(i).getDetalles();
			for (Iterator<MaterialSolicitado> it = items.iterator(); it
					.hasNext();) {
				if (it.next().getEstadoMaterialSolicitado().getNombre().equals("PENDIENTE")) {
					porPendiente.add(solicitudes.get(i));
					break;
				}
			}
		}
		return porPendiente;
	}

	@Override
	public List<SolicitudMaterial> buscarPorSolicitudNoProcesado() {
		// TODO Auto-generated method stub
		List<SolicitudMaterial> solicitudes = ISolicitudMaterialRepository
				.findByStatus("E");
		List<SolicitudMaterial> porRevisar = ISolicitudMaterialRepository
				.findByStatus("E");
		porRevisar.clear();
		for (int i = 0; i < solicitudes.size(); i++) {
			Set<MaterialSolicitado> items = solicitudes.get(i).getDetalles();
			for (Iterator<MaterialSolicitado> it = items.iterator(); it
					.hasNext();) {
				if (it.next().getEstadoMaterialSolicitado().getNombre().equals("NO PROCESADO")) {
					porRevisar.add(solicitudes.get(i));
					break;
				}
			}
		}
		return porRevisar;
	}
	/**
	 * 
	 * @param parametros parametros de filtrado de Solicitudes de Material
	 * @return lista de Solicitudes de Material filtradas por los parametros enviados
	 * @author  Ana Gallardo
	 */
	public List<SolicitudMaterial> buscarPorParametros(Map parametros){
		/*
		 * Aqui debe programar el filtrado de la lista y por ultimo devolverla ya filtrada
		 */
		String numerosolicitud = (String) parametros.get("numerosolicitud");	
		EspacioFisico espacioFisico = (EspacioFisico) parametros.get("destino");
		Material material = (Material) parametros.get("material");
		TipoMaterial tipoMaterial = (TipoMaterial) parametros.get("tipomaterial");
		EstadoMaterialSolicitado estadoMatSolicitado = (EstadoMaterialSolicitado) parametros.get("estadomaterialsolicitado");
		Date fechaDesde = (Date) parametros.get("desde");
		Date fechaHasta = (Date) parametros.get("hasta");
		UnidadOrganizativa unidadOrganizativa=(UnidadOrganizativa) parametros.get("unidadorganizativa");
		
		List<SolicitudMaterial> lstSolicitudes = buscarPorStatus("E");
		int tamannoLista = lstSolicitudes.size();
		
		//Comp = Comparar
		List<SolicitudMaterial> lstCompNumero = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompDestino = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompMaterial = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompTipoMat = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompEstado = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompFecha = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompUnidad = new ArrayList<SolicitudMaterial>();
		
		if(numerosolicitud!= null)
		{
			SolicitudMaterial solMaterial = new SolicitudMaterial();
			solMaterial= ISolicitudMaterialRepository.findByNumero(numerosolicitud);
				lstCompNumero.add(solMaterial);
				lstSolicitudes.retainAll(lstCompNumero);	
		}
		
		if(espacioFisico!=null){
			lstCompDestino = ISolicitudMaterialRepository.findByDestino(espacioFisico);
				lstSolicitudes.retainAll(lstCompDestino);
		
		}
		
		if(material!=null){
			lstCompMaterial = buscarPorMaterial(material);
			
				lstSolicitudes.retainAll(lstCompMaterial);
		}
		
		if(tipoMaterial!=null){
			lstCompTipoMat= buscarPorTipoMaterial(tipoMaterial);
				lstSolicitudes.retainAll(lstCompTipoMat);
		}
		
		if(estadoMatSolicitado!=null){
			lstCompEstado = buscarPorEstadoMat(estadoMatSolicitado);
				lstSolicitudes.retainAll(lstCompEstado);
		}
		
		if((fechaDesde!=null)&& (fechaHasta!=null)){
			lstCompFecha = ISolicitudMaterialRepository.findByFechaemisionBetween(fechaDesde, fechaHasta);
				lstSolicitudes.retainAll(lstCompFecha);
		}
		if(unidadOrganizativa!=null){
			lstCompUnidad= ISolicitudMaterialRepository.findByUnidadorganizativa(unidadOrganizativa);
			lstSolicitudes.retainAll(lstCompUnidad);
		}	
			return lstSolicitudes;	
	}
	
	public List<SolicitudMaterial> buscarPorMaterial(Material material){
		List<SolicitudMaterial> lstSolicitudes = buscarTodos();
		List<SolicitudMaterial> lstMaterial = new ArrayList<SolicitudMaterial>();
		for (int i=0; i<lstSolicitudes.size(); i++){
			Set<MaterialSolicitado> setMateriales = lstSolicitudes.get(i).getDetalles();
			for(Iterator<MaterialSolicitado> it = setMateriales.iterator(); it.hasNext();)
			{
				Material materialSiguiente = it.next().getMaterial();
				if(materialSiguiente.getId() == material.getId()){
					lstMaterial.add(lstSolicitudes.get(i));
					break;
				}
			}
		}
		return lstMaterial;
	}
	
	
	public List<SolicitudMaterial> buscarPorTipoMaterial(TipoMaterial tipoMaterial){
		List<SolicitudMaterial> lstSolicitudes = buscarTodos();
		List<SolicitudMaterial> lstTipoMaterial = new ArrayList<SolicitudMaterial>();
		for (int i=0; i<lstSolicitudes.size(); i++){
			Set<MaterialSolicitado> setMateriales = lstSolicitudes.get(i).getDetalles();
			for(Iterator<MaterialSolicitado> it = setMateriales.iterator(); it.hasNext();)
			{
				Material materialSiguiente = it.next().getMaterial();
				if(materialSiguiente.getTipomaterial().getId() == tipoMaterial.getId()){
					lstTipoMaterial.add(lstSolicitudes.get(i));
					break;
				}
			}
		}	
		return lstTipoMaterial;
	}
	
	public List<SolicitudMaterial> buscarPorEstadoMat(EstadoMaterialSolicitado estadoMaterialSol){
		List<SolicitudMaterial> lstSolicitudes = buscarTodos();
		List<SolicitudMaterial> lstEstadoMaterial = new ArrayList<SolicitudMaterial>();
		for (int i=0; i<lstSolicitudes.size(); i++){
			Set<MaterialSolicitado> setMateriales = lstSolicitudes.get(i).getDetalles();
			for(Iterator<MaterialSolicitado> it = setMateriales.iterator(); it.hasNext();)
			{
				EstadoMaterialSolicitado estadoMatSiguiente = it.next().getEstadoMaterialSolicitado();
				if(estadoMatSiguiente.getId() == estadoMaterialSol.getId()){
					lstEstadoMaterial.add(lstSolicitudes.get(i));
					break;
				}
			}
		}	
		return lstEstadoMaterial;
	}
	
	@Override
	public SolicitudMaterial buscarSolicitudMaterialPorNumero(String numero) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findByNumero(numero);
	}
	@Override
	public List<SolicitudMaterial> buscarSolicitudMaterialPorFechaemisionEntre(
			Date fechaDesde, Date fechaHasta) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.findByFechaemisionBetween(fechaDesde, fechaHasta);
	}
	
	//La explicacion de porque comente esto esta en el repository de SolicitudMaterial
/*	@Override
	public List<SolicitudMaterial> buscarPorFechaEmisionAntes(Date fechaAntes) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.buscarPorFechaEmisionAntes(fechaAntes);
	}
	@Override
	public List<SolicitudMaterial> buscarPorFechaEmisionDespues(
			Date fechaDespues) {
		// TODO Auto-generated method stub
		return ISolicitudMaterialRepository.buscarPorFechaEmisionDespues(fechaDespues);
	}*/
	
	/**
	 * 
	 * @param parametros
	 *            parametros de filtrado de Requisiciones
	 * @return lista de Solicitudes de Materiales filtradas por los parametros enviados
	 * @author Xavier Chavez
	 */
	public List<SolicitudMaterial> buscarPorParametrosEstadisticos(Map parametros) {
		
		List<SolicitudMaterial> solicitudes=buscarPorStatus("E");
		int tamannoLista = solicitudes.size();
		
		Date desde = (Date) parametros.get("desde");
		Date hasta = (Date) parametros.get("hasta");
		Material material = (Material) parametros.get("material");
		
		List<TipoMaterial> tipo=(List<TipoMaterial>) parametros.get("tipo");
		
		UnidadOrganizativa unidadOrganizativa=(UnidadOrganizativa) parametros.get("unidadorganizativa");
		String estadoSolicitud=(String) parametros.get("estadoSolicitud");
		
		List<SolicitudMaterial> lstCompFecha= new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompUnidad = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompEstadoSolicitud = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompTipoMat = new ArrayList<SolicitudMaterial>();
		List<SolicitudMaterial> lstCompMat = new ArrayList<SolicitudMaterial>();
		if((desde!=null)&& (hasta!=null)){
			lstCompFecha = ISolicitudMaterialRepository.findByFechaemisionBetween(desde, hasta);
				solicitudes.retainAll(lstCompFecha);
		}
		
		if(unidadOrganizativa!=null){
			lstCompUnidad=buscarSolicitudMaterialPorUnidadorganizativa(unidadOrganizativa);
				solicitudes.retainAll(lstCompUnidad);
		}
		
		if(estadoSolicitud!=null){
			lstCompEstadoSolicitud=buscarPorEstadoSolicitud(estadoSolicitud);
			solicitudes.retainAll(lstCompEstadoSolicitud);
		}
		if(material!=null){
			lstCompMat=buscarPorMaterial(material);
			solicitudes.retainAll(lstCompMat);
		}
		if(tipo!=null){
			lstCompTipoMat=buscarPorTipoMaterial(tipo);
					 solicitudes.retainAll(lstCompTipoMat);
			   for(int i=0; i<lstCompTipoMat.size(); i++){
					if(solicitudes.indexOf(lstCompTipoMat.get(i))!=-1){
						int index=solicitudes.indexOf(lstCompTipoMat.get(i));
						solicitudes.get(index).setDetalles(lstCompTipoMat.get(i).getDetalles());
					}
				}
		}
		
			return solicitudes;	
	}
	
	public List<SolicitudMaterial> buscarPorEstadoSolicitud(String estadoSolicitud){	
		List<SolicitudMaterial> solicitudes =buscarPorStatus("E");
		List<SolicitudMaterial> solicitudes1=new ArrayList<SolicitudMaterial>();
		for(int i=0; i<solicitudes.size(); i++){
			if(solicitudes.get(i).getEstadosolicitud().equals(estadoSolicitud)){
				solicitudes1.add(solicitudes.get(i));
			}
		}
		return solicitudes1;
	}
	
	
	public List<SolicitudMaterial> buscarPorTipoMaterial(List<TipoMaterial> tipo){
		List<SolicitudMaterial> solicitudes = buscarPorStatus("E");
		List<SolicitudMaterial> solicitudes1 =new ArrayList<SolicitudMaterial>();
		for(int i=0; i<solicitudes.size();i++){
			Set<MaterialSolicitado> items=solicitudes.get(i).getDetalles();
			Set<MaterialSolicitado> items2=new HashSet<MaterialSolicitado>();
			for(int j=0; j<tipo.size();j++){
				for(Iterator<MaterialSolicitado> it=items.iterator();it.hasNext();){
					MaterialSolicitado materialSolicitado=it.next();
					if(materialSolicitado.getMaterial().getTipomaterial().getId()==tipo.get(j).getId()){
						items2.add(materialSolicitado);		
					}
				}
			}
			if(items2.size()>0){
				solicitudes.get(i).setDetalles(items2);
				
				solicitudes1.add(solicitudes.get(i));
			}
		}
		
		return solicitudes1;	
	}
	
	
	public List<String> historicoSolicitudMaterial(Date date){
		List<String> inserts=new ArrayList<String>();
		String insert;
		List<SolicitudMaterial> solicitudes=ISolicitudMaterialRepository.buscarPorFechaHasta(date);		
		List<SolicitudMaterial> solicitudesH=new ArrayList<SolicitudMaterial>();
		for(int i=0; i<solicitudes.size();i++){
			if(solicitudes.get(i).getEstadosolicitud().equals("TOTALMENTE APROBADA")||solicitudes.get(i).getEstadosolicitud().equals("RECHAZADA")){
				solicitudesH.add(solicitudes.get(i));		
			}
			if(solicitudes.get(i).getEstadosolicitud().equals("PARCIALMENTE APROBADA")){
				SolicitudMaterial solicitud=solicitudes.get(i);
				Set<MaterialSolicitado> items=solicitud.getDetalles();
			       int j=0;
				   for(Iterator<MaterialSolicitado> it=items.iterator();it.hasNext();){
					   MaterialSolicitado materialsolicitado=it.next();
					   if(materialsolicitado.getEstadoMaterialSolicitado().getNombre().equals("PENDIENTE")){
						   j=1;
						   break;
					   }
			       }
				   if(j==0){
					   solicitudesH.add(solicitudes.get(i)); 
				   }
			}
		}
		
		for(int i=0;i<solicitudesH.size();i++){
			SolicitudMaterial solicitud=solicitudesH.get(i);
		       insert="INSERT INTO sigmys.solicitudmaterial(id, estadosolicitud, fechaemision, numero, status, destino, unidadorganizativa)"
		            +"VALUES ("+solicitud.getId()+",'','" + solicitud.getFechaemision()+"','"+solicitud.getNumero()+"','"+solicitud.getStatus()+"'," +solicitud.getDestino().getId()+","+solicitud.getUnidadorganizativa().getId()+");";
		       inserts.add(insert);
		       Set<MaterialSolicitado> items=solicitud.getDetalles();
		       for(Iterator<MaterialSolicitado> it=items.iterator();it.hasNext();){
			       MaterialSolicitado materialsolicitado=it.next();
			       if(materialsolicitado.getMotivo()!=null){
			    	   insert="INSERT INTO sigmys.materialsolicitado(id, cantidad, cantidadaprobada, status, estadomaterialsolicitadoid, materialid, motivoid, solicitudmaterialid)"
					       +"VALUES ("+materialsolicitado.getId()+","+materialsolicitado.getCantidad()+","+materialsolicitado.getCantidadAprobada()+",'"+materialsolicitado.isStatus()+"',"+materialsolicitado.getEstadoMaterialSolicitado().getId()+","+materialsolicitado.getMaterial().getId()+","+materialsolicitado.getMotivo().getId()+","+materialsolicitado.getSolicitudMaterial().getId()+");";  
			    	   inserts.add(insert);
			       }else{
		    	   insert="INSERT INTO sigmys.materialsolicitado(id, cantidad, cantidadaprobada, status, estadomaterialsolicitadoid, materialid, solicitudmaterialid)"
				       +"VALUES ("+materialsolicitado.getId()+","+materialsolicitado.getCantidad()+","+materialsolicitado.getCantidadAprobada()+",'"+materialsolicitado.isStatus()+"',"+materialsolicitado.getEstadoMaterialSolicitado().getId()+","+materialsolicitado.getMaterial().getId()+","+materialsolicitado.getSolicitudMaterial().getId()+");";  
		    	   inserts.add(insert);
		    	   }
		       }
		     ISolicitudMaterialRepository.delete(solicitud);
		}
		return inserts;
	}
	
}
