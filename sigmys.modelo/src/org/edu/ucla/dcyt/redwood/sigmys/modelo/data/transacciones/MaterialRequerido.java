package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;

@Table(name = "materialrequerido", schema = "sigmys")
@Entity
public class MaterialRequerido implements Comparable<MaterialRequerido>,
		Serializable {

	public static final int ORDENAMIENTO_POR_REQUISICION = 1;
	public static final int ORDENAMIENTO_POR_MATERIAL = 2;
	public static final int ORDENAMIENTO_POR_ESTADOMATERIALREQUERIDO = 3;
	public static final int ORDENAMIENTO_POR_CANTIDAD = 4;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MATERIALREQUERIDO_ID_GENERATOR", sequenceName = "MATERIALREQUERIDO_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATERIALREQUERIDO_ID_GENERATOR")
	@Column(name = "id", length = 4, unique = false)
	private int id;

	@Column(name = "cantidad", length = 4, nullable = false, unique = false)
	private int cantidad;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "requisicion", nullable = false, unique = false)
	private Requisicion requisicion;

	@ManyToOne
	@JoinColumn(name = "material", nullable = false, unique = false)
	private Material material;

	@ManyToOne()
	@JoinColumn(name = "estadomaterialrequerido", nullable = false, unique = false)
	private EstadoMaterialRequerido estadomaterialrequerido;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_REQUISICION;

	public MaterialRequerido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Requisicion getRequisicion() {
		return requisicion;
	}

	public void setRequisicion(Requisicion requisicion) {
		this.requisicion = requisicion;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public EstadoMaterialRequerido getEstadomaterialrequerido() {
		return estadomaterialrequerido;
	}

	public void setEstadomaterialrequerido(
			EstadoMaterialRequerido estadomaterialrequerido) {
		this.estadomaterialrequerido = estadomaterialrequerido;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		return getMaterial() + " - " + getCantidad() + " - "
				+ getMaterial().getMedida().getAbreviacion();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime
				* result
				+ ((estadomaterialrequerido == null) ? 0
						: estadomaterialrequerido.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
		result = prime * result
				+ ((requisicion == null) ? 0 : requisicion.hashCode());
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
		MaterialRequerido other = (MaterialRequerido) obj;
		if (cantidad != other.cantidad)
			return false;
		if (estadomaterialrequerido == null) {
			if (other.estadomaterialrequerido != null)
				return false;
		} else if (!estadomaterialrequerido
				.equals(other.estadomaterialrequerido))
			return false;
		if (id != other.id)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (requisicion == null) {
			if (other.requisicion != null)
				return false;
		} else if (!requisicion.equals(other.requisicion))
			return false;
		return true;
	}

	@Override
	public int compareTo(MaterialRequerido o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_REQUISICION:
			return getRequisicion().compareTo(o.getRequisicion());
		case ORDENAMIENTO_POR_MATERIAL:
			return getMaterial().compareTo(o.getMaterial());
		case ORDENAMIENTO_POR_ESTADOMATERIALREQUERIDO:
			return getEstadomaterialrequerido().compareTo(
					o.getEstadomaterialrequerido());
		case ORDENAMIENTO_POR_CANTIDAD:
			return Integer.valueOf(getCantidad()).compareTo(o.getCantidad());
		default:
			return 0;
		}
	}

	public String getCodigo() {
		return material.getCodigo();
	}

	public String getNombre() {
		return material.getNombre();
	}

	public String getUnidadmedida() {
		return material.getMedida().getAbreviacion();
	}

}
