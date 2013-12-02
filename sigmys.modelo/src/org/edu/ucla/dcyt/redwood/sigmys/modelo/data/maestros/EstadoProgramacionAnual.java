package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "estadoprogramacionanual", schema = "sigmys")
@Entity
public class EstadoProgramacionAnual implements
		Comparable<EstadoProgramacionAnual>, Serializable {

	public static final int ORDENAMIENTO_POR_NOMBRE = 1;
	public static final int ORDENAMIENTO_POR_DESCRIPCION = 2;

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", length = 4)
	@SequenceGenerator(name = "ID_ESTADOPROGRAMACIONANUAL_GENERATOR", sequenceName = "ESTADOPROGRAMACIONANUAL_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_ESTADOPROGRAMACIONANUAL_GENERATOR")
	private int id;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 80, nullable = false)
	private String descripcion;

	@Column(name = "status", length = 1, nullable = false)
	private String status;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NOMBRE;

	public EstadoProgramacionAnual() {
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		return this.getNombre() + " - " + this.getDescripcion();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		EstadoProgramacionAnual other = (EstadoProgramacionAnual) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(EstadoProgramacionAnual o) {
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
