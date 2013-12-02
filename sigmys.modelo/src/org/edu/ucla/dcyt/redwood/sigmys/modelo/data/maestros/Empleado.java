package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sinergia.modelo.data.seguridad.Usuario;

@Table(name = "empleado", schema = "sigmys")
@Entity
public class Empleado implements Comparable<Empleado>, Serializable {

	public static final int ORDENAMIENTO_POR_USUARIO = 1;
	public static final int ORDENAMIENTO_POR_UNIDAD = 2;

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 4, nullable = false)
	@SequenceGenerator(name = "EMPLEADO_ID_GENERATOR", sequenceName = "EMPLEADO_CODIGO_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLEADO_ID_GENERATOR")
	private int id;

	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@OneToOne
	@JoinColumn(name = "loginusuario", nullable = false, unique = true)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idunidadorganizativa", nullable = false)
	private UnidadOrganizativa unidadorganizativa;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_USUARIO;

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UnidadOrganizativa getUnidadorganizativa() {
		return unidadorganizativa;
	}

	public void setUnidadorganizativa(UnidadOrganizativa unidadorganizativa) {
		this.unidadorganizativa = unidadorganizativa;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		return this.getUsuario().getNombrecompleto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime
				* result
				+ ((unidadorganizativa == null) ? 0 : unidadorganizativa
						.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (unidadorganizativa == null) {
			if (other.unidadorganizativa != null)
				return false;
		} else if (!unidadorganizativa.equals(other.unidadorganizativa))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	@Override
	public int compareTo(Empleado o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_USUARIO:
			return getUsuario().getNombrecompleto().compareTo(
					o.getUsuario().getNombrecompleto());
		case ORDENAMIENTO_POR_UNIDAD:
			return getUnidadorganizativa().compareTo(o.getUnidadorganizativa());

		default:
			return 0;
		}
	}

}
