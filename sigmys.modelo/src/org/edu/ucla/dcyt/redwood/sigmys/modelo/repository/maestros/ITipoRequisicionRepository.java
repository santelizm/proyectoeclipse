package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoRequisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ITipoRequisicionRepository extends JpaRepository<TipoRequisicion, Integer> {

    public TipoRequisicion findByNombre(String nombre);
	
	public List<TipoRequisicion> findByNombreLike(String nombre);
		
	@Query("select tr from TipoRequisicion tr where (upper(tr.nombre) like upper(?1))"
			+"or (upper(tr.status) like upper(?1))")
	public List<TipoRequisicion> buscarPorX(String Parametro);

}
