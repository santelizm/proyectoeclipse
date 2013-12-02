package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;


import com.sinergia.modelo.servicios.IServicioGenerico;


@WebService(name="servicioEntregaEventual")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioEntregaEventual extends IServicioGenerico<EntregaEventual>{

    public EntregaEventual buscarEntregaEventualPorId(int id);
    
    public List<EntregaEventual> buscarEntregaEventualPorFecha(Date fecha);
	
	public List<EntregaEventual> buscarEntregaEventualPorStatus(String status);
	
	public List<EntregaEventual> buscarPorX(String parametro);

		
}
