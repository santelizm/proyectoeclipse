package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.Date;
import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Noticia;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface INoticiaRepository extends JpaRepository<Noticia, String> {

	public Noticia findById(int id);

	public Noticia findByTitulo(String titulo);

	public Noticia findBySubtitulo(String subtitulo);

	public Noticia findByAutor(String autor);

	public Noticia findByFechapublicacion(Date fechapublicacion);

	public Noticia findByFechafin(Date fechafin);

	public Noticia findByStatus(String status);

	public Noticia findByUnidadorganizativa(
			UnidadOrganizativa unidadorganizativa);

	public List<Noticia> findByAutorLike(String autor);

	public List<Noticia> findByStatusLike(String status);

	public List<Noticia> findByFechapublicacionLike(String fechapublicacion);

	public List<Noticia> findByFechafinLike(String fechafin);

	public List<Noticia> findByUnidadorganizativaLike(
			UnidadOrganizativa unidadorganizativa);

	@Query("select noti from Noticia noti where (upper(noti.titulo) like upper(?1))")
	public List<Noticia> buscarPorX(String parametro);

	@Query("select noti from Noticia noti "
			+ "where now() <= noti.fechafin "
			+ "order by noti.fechapublicacion desc limit 3")
	public List<Noticia> buscarOrdenadoPor();

}
