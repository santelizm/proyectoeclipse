package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "estadomaterialrequerido", schema = "sigmys")
@Entity
public class EstadoMaterialRequerido implements
		Comparable<EstadoMaterialRequerido>, Serializable {

	public static final int ORDENAMIENTO_POR_NOMBRE = 1;
	public static final int ORDENAMIENTO_POR_DESCRIPCION = 2;

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", length = 4)
	@SequenceGenerator(name = "ID_ESTADOMATERIALREQUERIDO_GENERATOR", sequenceName = "ESTADOMATERIALREQUERIDO_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ESTADOMATERIALREQUERIDO_GENERATOR")
	private int id;

	@Column(name = "nombre", length = 30, nullable = false, unique = true)
	private String nombre;

	@Column(name = "descripcion", length = 80, nullable = false)
	private String descripcion;

	@Column(name = "status", length = 1, nullable = false)
	private String status;
	
	@Column(name = "imagen")
	private String imagen;
	

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NOMBRE;

	public EstadoMaterialRequerido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		//return this.getNombre() + " - " + this.getDescripcion();
		return this.getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		EstadoMaterialRequerido other = (EstadoMaterialRequerido) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(EstadoMaterialRequerido o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NOMBRE:
			return getNombre().compareTo(o.getNombre());
		case ORDENAMIENTO_POR_DESCRIPCION:
			return getDescripcion().compareTo(o.getDescripcion());
		default:
			return 0;
		}
	}

}
