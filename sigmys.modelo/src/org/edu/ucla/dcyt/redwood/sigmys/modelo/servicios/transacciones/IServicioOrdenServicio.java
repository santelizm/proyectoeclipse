package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.transacciones;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.OrigenCompra;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;

import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioOrdenServicio")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioOrdenServicio extends
		IServicioGenerico<OrdenServicio> {

	public OrdenServicio buscarOrdenServicioPorId(int id);

	public OrdenServicio buscarOrdenServicioPorNumeroCompromiso(
			String numerocompromiso);

	public OrdenServicio buscarOrdenServicioPorDescripcion(String descripcion);

	public OrdenServicio buscarOrdenServicioPorStatus(String Status);

	public List<OrdenServicio> buscarOrdenServicioPorDescripcionSimilares(
			String descripcion);

	public List<OrdenServicio> buscarOrdenServicioPorFecha(Date fecha);

	public List<OrdenServicio> buscarPorFechaEntre(Date desde, Date hasta);

	public List<OrdenServicio> buscarOrdenServicioPorOrigencompra(
			OrigenCompra origencompra);

	public List<OrdenServicio> buscarPorX(String parametro);

	public OrdenServicio buscarOrdenServicioPorNumero(String numero);
}
