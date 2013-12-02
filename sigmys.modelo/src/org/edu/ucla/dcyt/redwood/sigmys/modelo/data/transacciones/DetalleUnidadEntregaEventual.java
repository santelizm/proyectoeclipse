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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;

@Table(name = "detalleunidadentregaeventual", schema = "sigmys")
@Entity
public class DetalleUnidadEntregaEventual implements
		Comparable<DetalleUnidadEntregaEventual>, Serializable {

	public static final int ORDENAMIENTO_POR_ENTREGAEVENTUAL = 1;
	public static final int ORDENAMIENTO_POR_UNIDAD = 2;
	public static final int ORDENAMIENTO_POR_DESTINO = 3;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "DETALLEUNIDADENTREGAEVENTUAL_ID_GENERATOR", sequenceName = "DETALLEUNIDADENTREGAEVENTUAL_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DETALLEUNIDADENTREGAEVENTUAL_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "idunidadorganizativa", nullable = false, unique = false)
	private UnidadOrganizativa unidadorganizativa;

	@ManyToOne
	@JoinColumn(name = "destino", nullable = false, unique = false)
	private EspacioFisico destino;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "identregaeventual", nullable = false, unique = false)
	private EntregaEventual entregaeventual;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_ENTREGAEVENTUAL;

	public DetalleUnidadEntregaEventual() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UnidadOrganizativa getUnidadorganizativa() {
		return unidadorganizativa;
	}

	public void setUnidadorganizativa(UnidadOrganizativa unidadorganizativa) {
		this.unidadorganizativa = unidadorganizativa;
	}

	public EspacioFisico getDestino() {
		return destino;
	}

	public void setDestino(EspacioFisico destino) {
		this.destino = destino;
	}

	public EntregaEventual getEntregaeventua() {
		return entregaeventual;
	}

	public void setEntregaeventua(EntregaEventual entregaeventua) {
		this.entregaeventual = entregaeventua;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		return this.getUnidadorganizativa().getNombre() + " - "
				+ getDestino().getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result
				+ ((entregaeventual == null) ? 0 : entregaeventual.hashCode());
		result = prime * result + id;
		result = prime
				* result
				+ ((unidadorganizativa == null) ? 0 : unidadorganizativa
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
		DetalleUnidadEntregaEventual other = (DetalleUnidadEntregaEventual) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (entregaeventual == null) {
			if (other.entregaeventual != null)
				return false;
		} else if (!entregaeventual.equals(other.entregaeventual))
			return false;
		if (id != other.id)
			return false;
		if (unidadorganizativa == null) {
			if (other.unidadorganizativa != null)
				return false;
		} else if (!unidadorganizativa.equals(other.unidadorganizativa))
			return false;
		return true;
	}

	@Override
	public int compareTo(DetalleUnidadEntregaEventual o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_ENTREGAEVENTUAL:
			return getEntregaeventua().compareTo(o.getEntregaeventua());
		case ORDENAMIENTO_POR_UNIDAD:
			return getUnidadorganizativa().compareTo(o.getUnidadorganizativa());
		case ORDENAMIENTO_POR_DESTINO:
			return getDestino().compareTo(o.getDestino());
		default:
			return 0;
		}
	}

}
