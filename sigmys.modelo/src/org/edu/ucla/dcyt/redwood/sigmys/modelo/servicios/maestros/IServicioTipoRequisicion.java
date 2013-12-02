package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoRequisicion;


import com.sinergia.modelo.servicios.IServicioGenerico;


@WebService(name="servicioTipoRequisicion")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)


public interface IServicioTipoRequisicion extends IServicioGenerico<TipoRequisicion> {

	public TipoRequisicion BuscarRequisicionPorNombre(String nombre);
	public List<TipoRequisicion> BuscarRequisicionesPorNombre(String nombre);
	public List<TipoRequisicion> buscarPorX(String Parametro);

}
