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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;

@Table(name = "materialordenentrega", schema = "sigmys")
@Entity
public class MaterialOrdenEntrega implements Comparable<MaterialOrdenEntrega>,
		Serializable {

	public static final int ORDENAMIENTO_POR_ORDENENTREGA = 1;
	public static final int ORDENAMIENTO_POR_MATERIAL = 2;
	public static final int ORDENAMIENTO_POR_CANTIDADENTREGADA = 3;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MATERIALORDENENTREGA_ID_GENERATOR", sequenceName = "MATERIALORDENENTREGA_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATERIALORDENENTREGA_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false, unique = true)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ordenentrega", nullable = false, unique = false)
	private OrdenEntrega ordenentrega;

	@ManyToOne
	@JoinColumn(name = "material", nullable = false, unique = false)
	private Material material;

	@Column(name = "cantidadentregada", nullable = false, unique = false)
	private int cantidadentregada;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_ORDENENTREGA;

	public MaterialOrdenEntrega() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrdenEntrega getOrdenentrega() {
		return ordenentrega;
	}

	public void setOrdenentrega(OrdenEntrega ordenentrega) {
		this.ordenentrega = ordenentrega;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public int getCantidadentregada() {
		return cantidadentregada;
	}

	public void setCantidadentregada(int cantidadentregada) {
		this.cantidadentregada = cantidadentregada;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidadentregada;
		result = prime * result + id;
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
		result = prime * result
				+ ((ordenentrega == null) ? 0 : ordenentrega.hashCode());
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
		MaterialOrdenEntrega other = (MaterialOrdenEntrega) obj;
		if (cantidadentregada != other.cantidadentregada)
			return false;
		if (id != other.id)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (ordenentrega == null) {
			if (other.ordenentrega != null)
				return false;
		} else if (!ordenentrega.equals(other.ordenentrega))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getMaterial() + " - " + getCantidadentregada() + " - "
				+ getMaterial().getMedida().getAbreviacion();
	}

	@Override
	public int compareTo(MaterialOrdenEntrega o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_ORDENENTREGA:
			return getOrdenentrega().compareTo(o.getOrdenentrega());
		case ORDENAMIENTO_POR_MATERIAL:
			return getMaterial().compareTo(o.getMaterial());
		case ORDENAMIENTO_POR_CANTIDADENTREGADA:
			return Integer.valueOf(getCantidadentregada()).compareTo(
					o.getCantidadentregada());
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
