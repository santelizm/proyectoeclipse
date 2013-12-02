package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ReferenciaObservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReferenciaObservacionRepository extends JpaRepository<ReferenciaObservacion, String> {
	
	public ReferenciaObservacion findById(int id);

	public ReferenciaObservacion findByNombre(String nombre);

	public List<ReferenciaObservacion> findByStatus(String status);

}
