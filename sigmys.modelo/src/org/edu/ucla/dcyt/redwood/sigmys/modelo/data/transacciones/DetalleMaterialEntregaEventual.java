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

@Table(name = "detallematerialentregaeventual", schema = "sigmys")
@Entity
public class DetalleMaterialEntregaEventual implements
		Comparable<DetalleMaterialEntregaEventual>, Serializable {

	public static final int ORDENAMIENTO_POR_ENTREGAEVENTUAL = 1;
	public static final int ORDENAMIENTO_POR_MATERIAL = 2;
	public static final int ORDENAMIENTO_POR_CANTIDAD = 3;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DETALLEMATERIALENTREGAEVENTUAL_ID_GENERATOR", sequenceName = "DETALLEMATERIALENTREGAEVENTUAL_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETALLEMATERIALENTREGAEVENTUAL_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false)
	private int id;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "identregaeventual", nullable = false, unique = false)
	private EntregaEventual entregaeventual;

	@ManyToOne
	@JoinColumn(name = "material", nullable = false, unique = false)
	private Material material;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_ENTREGAEVENTUAL;

	public DetalleMaterialEntregaEventual() {
		super();
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

	public EntregaEventual getEntregaeventual() {
		return entregaeventual;
	}

	public void setEntregaeventual(EntregaEventual entregaeventual) {
		this.entregaeventual = entregaeventual;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
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
		result = prime * result + cantidad;
		result = prime * result
				+ ((entregaeventual == null) ? 0 : entregaeventual.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
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
		DetalleMaterialEntregaEventual other = (DetalleMaterialEntregaEventual) obj;
		if (cantidad != other.cantidad)
			return false;
		if (entregaeventual == null) {
			if (other.entregaeventual != null)
				return false;
		} else if (!entregaeventual.equals(other.entregaeventual))
			return false;
		if (id != other.id)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.getMaterial().getNombre() + " - " + getCantidad() + " - "
				+ getMaterial().getMedida().getAbreviacion();
	}

	@Override
	public int compareTo(DetalleMaterialEntregaEventual o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_ENTREGAEVENTUAL:
			return getEntregaeventual().compareTo(o.getEntregaeventual());
		case ORDENAMIENTO_POR_MATERIAL:
			return getMaterial().compareTo(o.getMaterial());
		case ORDENAMIENTO_POR_CANTIDAD:
			return Integer.valueOf(getCantidad()).compareTo(o.getCantidad());
		default:
			return 0;
		}
	}
}
