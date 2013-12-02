package org.edu.ucla.dcyt.redwood.sigmys.modelo.repository.maestros;

import java.util.List;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sinergia.modelo.data.seguridad.Usuario;

public interface IEmpleadoRepository extends JpaRepository<Empleado, Integer> {

	public Empleado findById(int id);

	public Empleado findByUsuario(Usuario usuario);

	public List<Empleado> findByStatusLike(String status);

	@Query("select emp from Empleado emp "
			+ "where (upper(emp.unidadorganizativa.nombre) like upper(?1)) "
			+ "or (upper(emp.unidadorganizativa.proyecto.nombre) like upper(?1)) "
			+ "or (upper(emp.unidadorganizativa.descripcion) like upper(?1))"
			+ "or (upper(emp.usuario.login) like upper(?1)) "
			+ "or (upper(emp.usuario.nombrecompleto) like upper(?1))")
	public List<Empleado> buscarPorX(String parametro);

}
