package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

/*
 Creacion de Servicio EstadoMaterialSolicitado
 Autor: Greg y Mariangel
 Fecha: 18/12/2012 5pm;
 */

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEstadoMaterialSolicitadoReposository extends
		JpaRepository<EstadoMaterialSolicitado, Integer> {

	public EstadoMaterialSolicitado findById(int id);

	public EstadoMaterialSolicitado findByNombre(String nombre);

	public List<EstadoMaterialSolicitado> findByNombreLike(String nombre);

	@Query("select ems from EstadoMaterialSolicitado ems "
			+ "where (upper(ems.nombre) like upper(?1)) "
			+ "or (upper(ems.descripcion) like upper(?1))")
	public List<EstadoMaterialSolicitado> buscarPorX(String parametro);

}
