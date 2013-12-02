package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.MaterialOrdenEntrega;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.OrdenEntrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMaterialOrdenEntregaRepository extends
		JpaRepository<MaterialOrdenEntrega, Integer> {
	public MaterialOrdenEntrega findById(int id);
	
	public List<MaterialOrdenEntrega> findByOrdenentrega(OrdenEntrega ordenentrega);
	
	public List<MaterialOrdenEntrega> findByMaterial(Material material);
	
	public List<MaterialOrdenEntrega> findByCantidadentregada(int cantidadentregada);
}
