package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;


import com.sinergia.modelo.servicios.IServicioGenerico;


@WebService(name="servicioMaterialRequerido")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioMaterialRequerido extends IServicioGenerico<MaterialRequerido>{

    public MaterialRequerido buscarMaterialRequeridoPorId(int id);
    
    public MaterialRequerido buscarMaterialRequeridoPorCantidad(int cantidad);
	
    public List<MaterialRequerido> buscarMaterialRequeridoPorRequisicion(Requisicion requisicion);

    public List<MaterialRequerido> buscarMaterialRequeridoPorMaterial(Material material);
	
    public List<MaterialRequerido> buscarMaterialRequeridoPorEstadoMaterialRequerido(EstadoMaterialRequerido estadoMaterialRequerido);
	
	public List<MaterialRequerido> buscarPorX(String parametro);
}
