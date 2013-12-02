package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoProgramacionAnual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.ProgramacionAnual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProgramacionAnualRepository extends
		JpaRepository<ProgramacionAnual, Integer> {

	public ProgramacionAnual findById(int id);

	public List<ProgramacionAnual> findByEstadoprogramacionanual(
			EstadoProgramacionAnual estadoprogramacionanual);
	
	public ProgramacionAnual findByAno(String ano);
	
	public ProgramacionAnual findByStatus(String status);

	@Query("select pra from ProgramacionAnual pra where (upper(pra.estadoprogramacionanual.nombre)) like upper(?1)" +
			"or pra.ano like ?1") 
	public List<ProgramacionAnual> buscarPorX(String parametro);
	
	@Query("SELECT pra FROM ProgramacionAnual pra ORDER BY pra.ano DESC")
	public List<ProgramacionAnual> buscarOrdenadoPorAnno();

}
