package org.edu.ucla.dcyt.redwood.sigmys.test.transacciones;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.SolicitudMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.ITipoMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IUnidadOrganizativaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.ISolicitudMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones.ServicioSolicitudMaterial;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/applicationContext-modelo-sistema.xml")
public class testServicioSolicitudMaterial {
	@Autowired
	ISolicitudMaterialRepository iSolicitudMaterialRepository;

	@Autowired
	ServicioSolicitudMaterial servicioSolicitudMaterial;
	
	@Autowired
	ITipoMaterialRepository iTipoMaterialRepository;
	
	@Autowired
	IUnidadOrganizativaRepository iUnidadOrganizativaRepository;

	@Autowired
	IMaterialRepository iMaterialRepository;
	@Test
	public void testBuscarTodos() {
		fail("Not yet implemented");
	}

	@Test
	public void testContarTodos() {

		List<SolicitudMaterial> porRevisar = servicioSolicitudMaterial
				.buscarPorSolicitudNoProcesado();
		List<SolicitudMaterial> porMaterial = servicioSolicitudMaterial
				.buscarPorSolicitudPendiente();
		System.out.println("Por Revisar " + porRevisar.size());
		System.out.println("Pendiente " + porMaterial.size());
	}

	@Test
	public void testGuardar() {
		fail("Not yet implemented");
	}

	@Test
	public void testCrear() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarSolicitudMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarCollectionOfSolicitudMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarSolicitudMaterialPorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarSolicitudMaterialPorFechaemision() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarSolicitudMaterialPorUnidadorganizativa() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarSolicitudMaterialPorDestino() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorX() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorStatus() {
		fail("Not yet implemented");
	}
	@Test
	public void testBuscarPorParametrosEstadisticos(){
		  List<TipoMaterial> tipo =new ArrayList<TipoMaterial>();
		  tipo.add(iTipoMaterialRepository.findByNombre("FERRETERIA"));
	//	  tipo.add(iTipoMaterialRepository.findByNombre("OFICINA"));
		  
		  Map parameters = new HashMap();
		  parameters.put("material", iMaterialRepository.findById(50));
		// parameters.put("tipo", tipo);
	    //parameters.put("desde", iSolicitudMaterialRepository.findById(84).getFechaemision());
		//parameters.put("hasta", iSolicitudMaterialRepository.findById(84).getFechaemision());
		//  parameters.put("estadoSolicitud", "NO PROCESADA");
		//	  parameters.put("unidadorganizativa", iSolicitudMaterialRepository.findById(75).getUnidadorganizativa());
		  List<SolicitudMaterial> list =new ArrayList<SolicitudMaterial>();
		  
		  list=servicioSolicitudMaterial.buscarPorParametrosEstadisticos(parameters);
		  System.out.println("tamaño: "+ list.size());
	      for(int j=0; j<list.size(); j++){
	    	  System.out.println("Numero de Solicitud: "+ list.get(j).getNumero()+"  "+list.get(j).getFechaemision()+"  " + j );
	    	    Set<MaterialSolicitado> items=list.get(j).getDetalles();
	    	    for(Iterator<MaterialSolicitado> it=items.iterator(); it.hasNext();){
	    	    	MaterialSolicitado materialSoli=it.next();
	    	    	System.out.println("id: "+materialSoli.getId()+"TipoMaterial:" +materialSoli.getMaterial().getTipomaterial());
	    	    }
	      }
	}

}
