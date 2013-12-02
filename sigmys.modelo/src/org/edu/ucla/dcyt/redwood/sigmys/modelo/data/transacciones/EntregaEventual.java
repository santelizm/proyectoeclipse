package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Entity;

@Table(name = "entregaeventual", schema = "sigmys")
@Entity
public class EntregaEventual implements Comparable<EntregaEventual>,
		Serializable {

	public static final int ORDENAMIENTO_POR_MOTIVO = 1;
	public static final int ORDENAMIENTO_POR_FECHA = 2;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ENTREGAEVENTUAL_ID_GENERATOR", sequenceName = "ENTREGAEVENTUAL_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTREGAEVENTUAL_ID_GENERATOR")
	@Column(name = "id", length = 4)
	private int id;

	@Column(name = "motivo", length = 255, nullable = true)
	private String motivo;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "status", length = 1, nullable = false)
	private String status = "A";

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "entregaeventual")
	private Set<DetalleUnidadEntregaEventual> unidadesentregaeventual = new HashSet<DetalleUnidadEntregaEventual>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "entregaeventual")
	private Set<DetalleMaterialEntregaEventual> materialesentregaeventual = new HashSet<DetalleMaterialEntregaEventual>();

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_MOTIVO;

	public EntregaEventual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<DetalleUnidadEntregaEventual> getUnidadesentregaeventual() {
		return unidadesentregaeventual;
	}

	public void setUnidadesentregaeventual(
			Set<DetalleUnidadEntregaEventual> unidadesentregaeventual) {
		this.unidadesentregaeventual = unidadesentregaeventual;
	}

	public Set<DetalleMaterialEntregaEventual> getMaterialesentregaeventual() {
		return materialesentregaeventual;
	}

	public void setMaterialesentregaeventual(
			Set<DetalleMaterialEntregaEventual> materialesentregaeventual) {
		this.materialesentregaeventual = materialesentregaeventual;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		return getFecha() + "-" + getMotivo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((motivo == null) ? 0 : motivo.hashCode());
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
		EntregaEventual other = (EntregaEventual) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (motivo == null) {
			if (other.motivo != null)
				return false;
		} else if (!motivo.equals(other.motivo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(EntregaEventual o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_MOTIVO:
			return getMotivo().compareTo(o.getMotivo());
		case ORDENAMIENTO_POR_FECHA:
			return getFecha().compareTo(o.getFecha());
		default:
			return 0;
		}
	}

}
