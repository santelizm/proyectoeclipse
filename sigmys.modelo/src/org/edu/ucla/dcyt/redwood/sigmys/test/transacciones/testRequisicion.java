package org.edu.ucla.dcyt.redwood.sigmys.test.transacciones;

import static org.junit.Assert.fail;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IEstadoRequisicionRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.IMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.ITipoMaterialRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.ITipoRequisicionRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones.IRequisiconRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.transacciones.ServicioRequisicion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/applicationContext-modelo-sistema.xml")
public class testRequisicion {
	@Autowired
	IRequisiconRepository iRequisiconRepository;
	@Autowired
	ITipoMaterialRepository iTipoMaterialRepository;
	
	@Autowired
	ITipoRequisicionRepository iTipoRequisicionRepository;
	
	@Autowired
	IEstadoRequisicionRepository iEstadoRequisicionRepository;
	
	@Autowired
	IMaterialRepository iMaterialRepository;
	
	@Autowired
	ServicioRequisicion servicioRequisicion;
	
	@Test
	public void testBuscarTodos() {
		List<Requisicion> list =new ArrayList<Requisicion>(); 
		list=servicioRequisicion.buscarPorStatus("F");
		  System.out.println("tamaño: "+ list.size());
	      for(int j=0; j<list.size(); j++){
	    	  System.out.println("Numero de Requisicion: "+ list.get(j).getNumero()+"  "+list.get(j).getEstadoRequisicion()+"  " + j );
	    	    Set<MaterialRequerido> items=list.get(j).getMaterialesrequeridos();
	    	    for(Iterator<MaterialRequerido> it=items.iterator(); it.hasNext();){
	    	    	MaterialRequerido materialReq=it.next();
	    	    	System.out.println("id: "+materialReq.getId()+"TipoMaterial:" +materialReq.getMaterial().getTipomaterial());
	    	    }
	      }
	}

	@Test
	public void testContarTodos() {
		fail("Not yet implemented");
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
	public void testEliminarRequisicion() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarCollectionOfRequisicion() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarRequisicionPorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarRequisicionPorNumero() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarRequisicionesPorObservacionesSimilares() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarRequisicionesPorTipoRequisicion() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscarRequisicionesPorEstadoRequisicion() {
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
	public void testBuscarPorParametros() {
	//	fail("Not yet implemented");
		/*Map parameters = new HashMap();
		parameters.put("estadorequisicion", iEstadoRequisicionRepository.findAll().get(0));
		parameters.put("tiporequisicion", iTipoRequisicionRepository.findAll().get(0));
		
		List<Requisicion> list =new ArrayList<Requisicion>();
		
		list=servicioRequisicion.buscarPorParametros(parameters);
		System.out.println(list.size());*/
	}
	@Test
	public void testBuscarPorbuscarPorTipoMaterial() {/*
	  List<TipoMaterial> tipo =new ArrayList<TipoMaterial>();
	  tipo.add(iTipoMaterialRepository.findByNombre("FERRETERIA"));
	//  tipo.add(iTipoMaterialRepository.findByNombre("LIMPIEZA"));
	  
	  Map parameters = new HashMap();
	  //parameters.put("tipo", tipo);
	//  parameters.put("desde", iRequisiconRepository.findById(40).getFecha());
	 // parameters.put("hasta", iRequisiconRepository.findById(40).getFecha());
	  parameters.put("material", iMaterialRepository.findById(50));
	  List<Requisicion> list =new ArrayList<Requisicion>();
	  
	  list=servicioRequisicion.buscarPorParametrosEstadisticos(parameters);
	  System.out.println("tamaño: "+ list.size());
      for(int j=0; j<list.size(); j++){
    	  System.out.println("Numero de Requisicion: "+ list.get(j).getNumero()+"  "+list.get(j).getFecha()+"  " + j );
    	    Set<MaterialRequerido> items=list.get(j).getMaterialesrequeridos();
    	    for(Iterator<MaterialRequerido> it=items.iterator(); it.hasNext();){
    	    	MaterialRequerido materialReq=it.next();
    	    	System.out.println("id: "+materialReq.getId()+"TipoMaterial:" +materialReq.getMaterial().getTipomaterial());
    	    }
      }*/
	}
}
