package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Medida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IMedidaRepository extends JpaRepository<Medida, Integer> {
	
	public Medida findById(int id);

	public Medida findByNombre(String nombre);


	public List<Medida> findByNombreLike(String nombre);
	
	@Query("select med from Medida med where (upper(med.nombre) like upper(?1)) " +
			  "or (upper(med.abreviacion) like upper(?1)) ")
			  
	public List<Medida> buscarPorX(String parametro);
}
