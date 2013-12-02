package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEspacioFisicoRepository extends	JpaRepository<EspacioFisico, Integer> {

	public EspacioFisico findById(int id);
	
	public EspacioFisico findByNombre(String nombre);
	
	public EspacioFisico findByModulo(String modulo);
	
	public List<EspacioFisico> findByNombreLike(String nombre);
	
	public List<EspacioFisico> findByModuloLike(String modulo);
	
	public List<EspacioFisico> findByStatus(String status);
	
	@Query("select ef from EspacioFisico ef where (upper(ef.nombre) like upper(?1)) " +
											  "or (upper(ef.modulo) like upper(?1)) " )
	public List<EspacioFisico> buscarPorX(String parametro);
	
}