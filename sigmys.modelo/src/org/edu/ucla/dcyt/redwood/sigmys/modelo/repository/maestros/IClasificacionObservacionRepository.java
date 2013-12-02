package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ClasificacionObservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClasificacionObservacionRepository extends JpaRepository<ClasificacionObservacion, String> {
	
	public ClasificacionObservacion findById(int id);

	public ClasificacionObservacion findByNombre(String nombre);

	public List<ClasificacionObservacion> findByStatus(String status);

}
