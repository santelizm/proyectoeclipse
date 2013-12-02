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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Motivo;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialSolicitado;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoMaterial;

@Table(name = "materialsolicitado", schema = "sigmys")
@Entity
public class MaterialSolicitado implements Serializable,
		Comparable<MaterialSolicitado> {

	public static final int ORDENAMIENTO_POR_SOLICITUDMATERIAL = 1;
	public static final int ORDENAMIENTO_POR_MATERIAL = 2;
	public static final int ORDENAMIENTO_POR_ESTADOMATERIALSOLICITADO = 3;
	public static final int ORDENAMIENTO_POR_CANTIDAD = 4;
	public static final int ORDENAMIENTO_POR_MOTIVO = 5;
	public static final int ORDENAMIENTO_POR_CANTIDADAPROBADA = 6;
	public static final int ORDENAMIENTO_POR_TIPOMATERIAL = 7;
	public static final int ORDENAMIENTO_POR_MEDIDA = 8;
	public static final int ORDENAMIENTO_POR_EXISTENCIA = 9;

	private static final long serialVersionUID = 77815032747137758L;

	@Id
	@SequenceGenerator(name = "MATERIALSOLICITADO_ID_GENERATOR", sequenceName = "MATERIALSOLICITADO_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATERIALSOLICITADO_ID_GENERATOR")
	@Column(name = "id", length = 4)
	private int id;

	@ManyToOne
	@JoinColumn(name = "materialid", nullable = false)
	private Material material;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "solicitudmaterialid", nullable = false)
	private SolicitudMaterial solicitudMaterial;

	@ManyToOne
	@JoinColumn(name = "estadomaterialsolicitadoid", nullable = false)
	private EstadoMaterialSolicitado estadoMaterialSolicitado;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	@Column(name = "status")
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "motivoid")
	private Motivo motivo;

	@Column(name = "cantidadaprobada", nullable = true)
	private int cantidadAprobada;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_SOLICITUDMATERIAL;

	public MaterialSolicitado() {
		// TODO Auto-generated constructor stub
		this.status = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public SolicitudMaterial getSolicitudMaterial() {
		return solicitudMaterial;
	}

	public void setSolicitudMaterial(SolicitudMaterial solicitudMaterial) {
		this.solicitudMaterial = solicitudMaterial;
	}

	public EstadoMaterialSolicitado getEstadoMaterialSolicitado() {
		return estadoMaterialSolicitado;
	}

	public void setEstadoMaterialSolicitado(
			EstadoMaterialSolicitado estadoMaterialSolicitado) {
		this.estadoMaterialSolicitado = estadoMaterialSolicitado;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCantidadAprobada() {
		return cantidadAprobada;
	}

	public void setCantidadAprobada(int cantidadAprobada) {
		this.cantidadAprobada = cantidadAprobada;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Motivo getMotivo() {
		return motivo;
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
		result = prime * result + id;
		result = prime * result
				+ ((material == null) ? 0 : material.hashCode());
		result = prime
				* result
				+ ((solicitudMaterial == null) ? 0 : solicitudMaterial
						.hashCode());
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
		MaterialSolicitado other = (MaterialSolicitado) obj;
		if (cantidad != other.cantidad)
			return false;
		if (id != other.id)
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (solicitudMaterial == null) {
			if (other.solicitudMaterial != null)
				return false;
		} else if (!solicitudMaterial.equals(other.solicitudMaterial))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getMaterial() + " - " + getCantidad() + " - "
				+ getMaterial().getMedida().getAbreviacion();
	}

	@Override
	public int compareTo(MaterialSolicitado o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_SOLICITUDMATERIAL:
			return getSolicitudMaterial().compareTo(o.getSolicitudMaterial());
		case ORDENAMIENTO_POR_MATERIAL:
			return getMaterial().compareTo(o.getMaterial());
		case ORDENAMIENTO_POR_ESTADOMATERIALSOLICITADO:
			return getEstadoMaterialSolicitado().compareTo(
					o.getEstadoMaterialSolicitado());
		case ORDENAMIENTO_POR_CANTIDAD:
			return Integer.valueOf(getCantidad()).compareTo(o.getCantidad());
		case ORDENAMIENTO_POR_MOTIVO:
			return getMotivo().compareTo(o.getMotivo());
		case ORDENAMIENTO_POR_CANTIDADAPROBADA:
			return Integer.valueOf(getCantidadAprobada()).compareTo(
					o.getCantidadAprobada());
		case ORDENAMIENTO_POR_TIPOMATERIAL:
			return getMaterial().getTipomaterial().compareTo(
					o.getMaterial().getTipomaterial());
		case ORDENAMIENTO_POR_MEDIDA:
			return getMaterial().getMedida().compareTo(
					o.getMaterial().getMedida());
		case ORDENAMIENTO_POR_EXISTENCIA:
			return Integer.valueOf(getMaterial().getExistencia()).compareTo(
					o.getMaterial().getExistencia());
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
