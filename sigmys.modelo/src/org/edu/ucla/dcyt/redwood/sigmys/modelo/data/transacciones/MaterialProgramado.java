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

@Table(name = "materialprogramado", schema = "sigmys")
@Entity
public class MaterialProgramado implements Comparable<MaterialProgramado>,
		Serializable {

	public static final int ORDENAMIENTO_POR_PROYECTOPROGRAMACIONANUAL = 1;
	public static final int ORDENAMIENTO_POR_MATERIAL = 2;
	public static final int ORDENAMIENTO_POR_CANTIDAD = 3;
	public static final int ORDENAMIENTO_POR_PRECIO = 4;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "MATERIALPROGRAMADO_ID_GENERATOR", sequenceName = "MATERIALPROGRAMADO_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATERIALPROGRAMADO_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false)
	private int id;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "material")
	private Material material;

	@Column(name = "precio", nullable = false)
	private float precio;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "proyectoprogramacionanual")
	private ProyectoProgramacionAnual proyectoprogramacionanual;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_PROYECTOPROGRAMACIONANUAL;

	public MaterialProgramado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProyectoProgramacionAnual getProyectoprogramacionanual() {
		return proyectoprogramacionanual;
	}

	public void setProyectoprogramacionanual(
			ProyectoProgramacionAnual proyectoprogramacionanual) {
		this.proyectoprogramacionanual = proyectoprogramacionanual;
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

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		return this.getMaterial() + " - " + getCantidad() + " - "
				+ getMaterial().getMedida().getAbreviacion();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + id;
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
		result = prime * result + Float.floatToIntBits(precio);
		result = prime
				* result
				+ ((proyectoprogramacionanual == null) ? 0
						: proyectoprogramacionanual.hashCode());
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
		MaterialProgramado other = (MaterialProgramado) obj;
		if (cantidad != other.cantidad)
			return false;
		if (id != other.id)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (Float.floatToIntBits(precio) != Float.floatToIntBits(other.precio))
			return false;
		if (proyectoprogramacionanual == null) {
			if (other.proyectoprogramacionanual != null)
				return false;
		} else if (!proyectoprogramacionanual
				.equals(other.proyectoprogramacionanual))
			return false;
		return true;
	}

	@Override
	public int compareTo(MaterialProgramado o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_PROYECTOPROGRAMACIONANUAL:
			return getProyectoprogramacionanual().compareTo(
					o.getProyectoprogramacionanual());
		case ORDENAMIENTO_POR_MATERIAL:
			return getMaterial().compareTo(o.getMaterial());
		case ORDENAMIENTO_POR_CANTIDAD:
			return Integer.valueOf(getCantidad()).compareTo(o.getCantidad());
		case ORDENAMIENTO_POR_PRECIO:
			return Float.valueOf(getPrecio()).compareTo(o.getPrecio());
		default:
			return 0;
		}
	}

}
