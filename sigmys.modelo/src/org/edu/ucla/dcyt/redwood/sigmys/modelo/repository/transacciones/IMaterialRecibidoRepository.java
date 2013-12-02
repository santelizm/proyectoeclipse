package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialRecibido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMaterialRecibidoRepository extends
		JpaRepository<MaterialRecibido, Integer> {

	public MaterialRecibido findById(int id);

	public List<MaterialRecibido> findByOrdendeservicio(OrdenServicio ordendeservicio);

	public List<MaterialRecibido> findByMaterial(int material);

	public List<MaterialRecibido> findByCantidad(int cantidad);

	/*
	 * Query comentado hasta que no se mapee nuevamente requisicion y
	 * se cambie el tipo de dato de numero y numero precompromiso a String
	 * */
	 @Query("select mre from MaterialRecibido mre where (upper(mre.material.nombre) like upper(?1))")
	public List<MaterialRecibido> buscarPorX(String parametro);
}
