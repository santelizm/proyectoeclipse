package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialProgramado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProyectoProgramacionAnual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IMaterialProgramadoRepository extends
		JpaRepository<MaterialProgramado, Integer> {

	public MaterialProgramado findById(int id);

	public List<MaterialProgramado> findByMaterial(Material material);

	public List<MaterialProgramado> findByProyectoprogramacionanual(
			ProyectoProgramacionAnual proyectoprogramacionanual);
	
}
