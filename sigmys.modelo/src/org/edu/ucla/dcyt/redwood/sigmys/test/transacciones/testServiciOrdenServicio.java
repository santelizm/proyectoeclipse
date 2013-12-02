package org.edu.ucla.dcyt.redwood.sigmys.test.transacciones;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRecibido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.ITipoMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IOrdenServicioRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones.ServicioOrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones.ServicioOrdenServicio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/applicationContext-modelo-sistema.xml")
public class testServiciOrdenServicio {

	@Autowired
	ServicioOrdenServicio servicioOrdenServicio;
	
	@Autowired
	IOrdenServicioRepository iOrdenServicioRepository;
	
	@Autowired
	ITipoMaterialRepository iTipoMaterialRepository;
	
	@Autowired
	IMaterialRepository iMaterialRepository;
	
	@Test
	public void testBuscarOrdenServicioPorNumeroCompromiso() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorParametros() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorTipoMaterialTipoMaterial() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorFechaEntre() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorFechaDesde() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorFechaHasta() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarOrdenServicioPorNumero() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarPorParametrosEstadisticos() {
		  List<TipoMaterial> tipo =new ArrayList<TipoMaterial>();
		  tipo.add(iTipoMaterialRepository.findByNombre("FERRETERIA"));
		  //tipo.add(iTipoMaterialRepository.findByNombre("LIMPIEZA"));
		  
		  Map parameters = new HashMap();
		  parameters.put("material",iMaterialRepository.findById(68));
		//  parameters.put("desde", iOrdenServicioRepository.findById(13).getFecha());
		  //parameters.put("hasta", iOrdenServicioRepository.findById(24).getFecha());
		  
		  List<OrdenServicio> list =new ArrayList<OrdenServicio>();
		  
		  list=servicioOrdenServicio.buscarPorParametrosEstadisticos(parameters);
		  System.out.println("tamaño: "+ list.size());
	      for(int j=0; j<list.size(); j++){
	    	  System.out.println("Numero de Orden Servicio: "+ list.get(j).getNumero()+"  "+list.get(j).getFecha()+"  " + j );
	    	    List<MaterialRecibido> items=list.get(j).getMaterialesrecibidos();
	    	    for(int k=0;k<items.size();k++){
	    	    	MaterialRecibido materialRe=items.get(k);
	    	    	System.out.println("id: "+materialRe.getId()+" "+"TipoMaterial:" +materialRe.getMaterial().getId());
	    	    }
	      }
		  
	}

	@Test
	public void testBuscarPorTipoMaterialListOfTipoMaterial() {
		fail("Not yet implemented");
	}

}
