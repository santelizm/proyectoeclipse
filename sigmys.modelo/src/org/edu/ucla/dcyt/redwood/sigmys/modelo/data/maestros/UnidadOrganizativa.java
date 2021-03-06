package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name = "unidadorganizativa", schema = "sigmys")
@Entity
public class UnidadOrganizativa implements Comparable<UnidadOrganizativa>,
		Serializable {

	public static final int ORDENAMIENTO_POR_NOMBRE = 1;
	public static final int ORDENAMIENTO_POR_DESCRIPCION = 2;
	public static final int ORDENAMIENTO_POR_PROYECTO = 3;

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 4)
	@SequenceGenerator(name = "ID_UNIDADORGANIZATIVA_GENERATOR", sequenceName = "UNIDADORGANIZATIVA_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_UNIDADORGANIZATIVA_GENERATOR")
	private int id;

	@Column(name = "nombre", length = 30, nullable = false, unique = true)
	private String nombre;

	@Column(name = "descripcion", length = 80, nullable = false)
	private String descripcion;

	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proyecto", nullable = true)
	private Proyecto proyecto;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "unidadorganizativa")
	private List<EspacioFisicoUnidadO> espaciosfisicosunidado = new ArrayList<EspacioFisicoUnidadO>();

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NOMBRE;

	public UnidadOrganizativa() {
		super();
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

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
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
		UnidadOrganizativa other = (UnidadOrganizativa) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(UnidadOrganizativa o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NOMBRE:
			return getNombre().compareTo(o.getNombre());
		case ORDENAMIENTO_POR_DESCRIPCION:
			return getDescripcion().compareTo(o.getDescripcion());
		case ORDENAMIENTO_POR_PROYECTO:
			return getProyecto().compareTo(o.getProyecto());
		default:
			return 0;
		}
	}

	public void setEspaciosfisicosunidado(List<EspacioFisicoUnidadO> espaciofisicounidado) {
		this.espaciosfisicosunidado = espaciosfisicosunidado;
	}

	public List<EspacioFisicoUnidadO> getEspaciosfisicosunidado() {
		return espaciosfisicosunidado;
	}

}
