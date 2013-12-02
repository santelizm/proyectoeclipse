package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.transacciones;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.DetalleMaterialEntregaEventual;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.EntregaEventual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleMaterialEntregaEventualRepository extends
		JpaRepository<DetalleMaterialEntregaEventual, Integer> {
	
	public DetalleMaterialEntregaEventual findById(int id);
	
	public List<DetalleMaterialEntregaEventual> findByMaterial(Material material);
	
	public List<DetalleMaterialEntregaEventual> findByEntregaeventual(EntregaEventual entregaeventual);
	
	public List<DetalleMaterialEntregaEventual> findByCantidad(int cantidad);
}
