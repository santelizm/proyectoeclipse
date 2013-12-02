package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "referenciaobservacion", schema = "sigmys")
@Entity
public class ReferenciaObservacion implements
		Comparable<ReferenciaObservacion>, Serializable {

	public static final int ORDENAMIENTO_POR_NOMBRE = 1;

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(name = "REFERENCIA_ID_GENERATOR", sequenceName = "REFERENCIA_CODIGO_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REFERENCIA_ID_GENERATOR")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "status")
	private String status;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NOMBRE;

	public ReferenciaObservacion() {
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

	public String getNombre() {
		return nombre;
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
		return this.getNombre();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		ReferenciaObservacion other = (ReferenciaObservacion) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(ReferenciaObservacion o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NOMBRE:
			return getNombre().compareTo(o.getNombre());
		default:
			return 0;
		}
	}
}
