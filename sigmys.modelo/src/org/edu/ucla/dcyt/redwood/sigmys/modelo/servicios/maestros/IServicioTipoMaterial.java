package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name = "servicioTipoMaterial")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public interface IServicioTipoMaterial extends IServicioGenerico<TipoMaterial> {

	public TipoMaterial buscarMaterialPorNombre(String nombre);

	public List<TipoMaterial> buscarMaterialesPorNombre(String nombre);

	public List<TipoMaterial> buscarPorX(String parametro);
}
