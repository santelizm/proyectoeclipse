package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "proveedor", schema = "sigmys")
@Entity
public class Proveedor implements Comparable<Proveedor>, Serializable{

	

	public static final int ORDENAMIENTO_POR_NOMBRE = 1;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROVEEDOR_ID_GENERATOR", sequenceName = "PROVEEDOR_CODIGO_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROVEEDOR_ID_GENERATOR")
	@Column(name = "id", length = 4)
	private int id;

	@Column(name = "nombre", length = 80, nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "descripcion", length = 80, nullable = false, unique = false)
	private String descripcion;
	
	@Column(name = "direccion", length = 80, nullable = false, unique = true)
	private String direccion;


	@Column(name = "status",length = 1, nullable = false, unique = false)
	private String status;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NOMBRE;

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
	public int compareTo(Proveedor o) {
		// TODO Auto-generated method stub
		switch (getTipoOrdenamiento()) {
			case 1: return getNombre().compareTo(o.getNombre());
		default:
			return 0;
		}
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((direccion == null) ? 0 : direccion.hashCode());
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
		Proveedor other = (Proveedor) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
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
}
