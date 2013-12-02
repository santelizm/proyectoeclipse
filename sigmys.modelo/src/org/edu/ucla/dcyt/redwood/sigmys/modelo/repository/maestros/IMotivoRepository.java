package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Motivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMotivoRepository extends JpaRepository<Motivo, Integer> {

	public Motivo findById(int id);
	
	public List<Motivo> findByNombreLike(String nombre); 
	
	public List<Motivo> findByDescripcionLike(String descripcion);
	
	public List<Motivo> findByStatusLike(String status);
}
