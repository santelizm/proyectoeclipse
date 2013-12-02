package org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.impl.maestros;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Noticia;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros.INoticiaRepository;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.servicios.maestros.IServicioNoticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("servicioNoticia")
public class ServicioNoticia implements IServicioNoticia{

	@Autowired
	INoticiaRepository iNoticiaRepository;
	
	@Override
	public List<Noticia> buscarTodos() {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findAll();
	}

	@Override
	public int contarTodos() {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findAll().size();
	}

	@Override
	public Noticia guardar(Noticia entidad) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.save(entidad);
	}

	@Override
	public Noticia crear() {
		// TODO Auto-generated method stub
		return new Noticia();
	}

	@Override
	public void eliminar(Noticia entidad) {
		// TODO Auto-generated method stub
		iNoticiaRepository.delete(entidad);
	}

	@Override
	public void eliminar(Collection<Noticia> entidades) {
		// TODO Auto-generated method stub
		iNoticiaRepository.delete(entidades);
	}

	@Override
	public Noticia buscarNoticiaPorId(int id) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findById(id);
	}

	@Override
	public Noticia buscarNoticiaPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByTitulo(titulo);
	}

	@Override
	public Noticia buscarNoticiaPorSubtitulo(String subtitulo) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findBySubtitulo(subtitulo);
	}

	@Override
	public Noticia buscarNoticiaPorAutor(String autor) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByAutor(autor);
	}

	@Override
	public Noticia buscarNoticiaPorFechaPublicacion(Date fechapublicacion) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByFechapublicacion(fechapublicacion);
	}

	@Override
	public Noticia buscarNoticiaPorFechaFin(Date fechafin) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByFechafin(fechafin);
	}

	@Override
	public Noticia buscarNoticiaPorStatus(String status) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByStatus(status);
	}

	@Override
	public Noticia buscarNoticiaPorUnidadOrganizativa(
			UnidadOrganizativa unidadorganizativa) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByUnidadorganizativa(unidadorganizativa);
	}

	@Override
	public List<Noticia> buscarNoticiasPorAutor(String autor) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByAutorLike(autor);
	}

	@Override
	public List<Noticia> buscarNoticiasPorStatus(String status) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByStatusLike(status);
	}

	@Override
	public List<Noticia> buscarNoticiasPorFechaPublicacion(
			String fechapublicacion) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByFechapublicacionLike(fechapublicacion);
	}

	@Override
	public List<Noticia> buscarNoticiasPorFechaFin(String fechafin) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByFechafinLike(fechafin);
	}

	@Override
	public List<Noticia> buscarNoticiasPorUnidadOrganizativa(
			UnidadOrganizativa unidadorganizativa) {
		// TODO Auto-generated method stub
		return iNoticiaRepository.findByUnidadorganizativaLike(unidadorganizativa);
	}
	@Override
	public List<Noticia> buscarPorX(String parametro) {
		return iNoticiaRepository.buscarPorX(parametro);
	}

	@Override
	public List<Noticia> buscarOrdenadoPor() {
		// TODO Auto-generated method stub
		return iNoticiaRepository.buscarOrdenadoPor();
	}

}
