package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Noticia;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;


import com.sinergia.modelo.servicios.IServicioGenerico;

@WebService(name="servicioNoticia")
@SOAPBinding(use=Use.LITERAL, style=Style.DOCUMENT)
public interface IServicioNoticia extends IServicioGenerico<Noticia>{

	public Noticia buscarNoticiaPorId(int id);
	
	public Noticia buscarNoticiaPorTitulo(String titulo);
	
	public Noticia buscarNoticiaPorSubtitulo(String subtitulo);
	
	public Noticia buscarNoticiaPorAutor(String autor);
	
	public Noticia buscarNoticiaPorFechaPublicacion(Date fechapublicacion);
	
	public Noticia buscarNoticiaPorFechaFin(Date fechafin);
	
	public Noticia buscarNoticiaPorStatus(String status);
	
	public Noticia buscarNoticiaPorUnidadOrganizativa(UnidadOrganizativa unidadorganizativa);
	
	
	public List<Noticia> buscarNoticiasPorAutor(String autor);
	
	public List<Noticia> buscarNoticiasPorStatus(String status);
	
	public List<Noticia> buscarNoticiasPorFechaPublicacion(String fechapublicacion);
	
	public List<Noticia> buscarNoticiasPorFechaFin(String fechafin);
	
	public List<Noticia> buscarNoticiasPorUnidadOrganizativa(UnidadOrganizativa unidadorganizativa);

	public List<Noticia> buscarPorX(String parametro);
	
	public List<Noticia> buscarOrdenadoPor();

	
}
