package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMaterialRequeridoRepository extends JpaRepository<MaterialRequerido, Integer> {

	
	public MaterialRequerido findById(int id);
	
	public MaterialRequerido findByCantidad(int cantidad);
	
	public List<MaterialRequerido> findByRequisicion(Requisicion requisicion);
	
	public List<MaterialRequerido> findByMaterial(Material material);
	
	public List<MaterialRequerido> findByEstadomaterialrequerido(EstadoMaterialRequerido estadomaterialrequerido);
	
	@Query("select mr from MaterialRequerido mr where (upper(mr.cantidad) like upper(?1)) " +
	   "or (upper(mr.requisicion.numero) like upper(?1)) " + 
	   "or (upper(mr.material.nombre) like upper(?1)) " +
	   "or (upper(mr.estadomaterialrequerido.nombre) like upper(?1)) ")
	
	public List<MaterialRequerido> buscarPorX(String parametro);

}
