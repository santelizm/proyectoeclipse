package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoObservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ITipoObservacionRepository extends
		JpaRepository<TipoObservacion, String> {

		public TipoObservacion findById(int id);
		
		public TipoObservacion findByNombre(String nombre);
		
		public List<TipoObservacion> findByNombreLike(String nombre);

		public List<TipoObservacion> findByStatusLike(String status);
		
		@Query("select tpo from TipoObservacion tpo where (upper(tpo.nombre) like upper(?1))")
		  
		public List<TipoObservacion> buscarPorX(String parametro);
	
}
