package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProyectoRepository extends JpaRepository<Proyecto, String>{
	  
  public Proyecto findByNombre(String nombre);
  public List<Proyecto> findByNombreLike(String nombre);
  
  @Query("select pro from Proyecto pro where (upper(pro.nombre) like upper(?1)) " +
  "or (upper(pro.descripcion) like upper(?1)) ")
  
public List<Proyecto> buscarPorX(String parametro);
}

