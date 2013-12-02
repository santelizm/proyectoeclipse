package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ClasificacionObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.ReferenciaObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoObservacion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;

@Table(name = "observacionentrega", schema = "sigmys")
@Entity
public class ObservacionEntrega implements Comparable<ObservacionEntrega>,
		Serializable {

	public static final int ORDENAMIENTO_POR_TIPOOBSERVACION = 1;
	public static final int ORDENAMIENTO_POR_CLASIFICACION = 2;
	public static final int ORDENAMIENTO_POR_FECHA = 3;
	public static final int ORDENAMIENTO_POR_REFERENCIA = 4;
	public static final int ORDENAMIENTO_POR_UNIDAD = 5;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "OBSERVACIONENTREGA_ID_GENERATOR", sequenceName = "OBSERVACIONENTREGA_CODIGO_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OBSERVACIONENTREGA_ID_GENERATOR")
	@Column(name = "idobservacionentrega", length = 4)
	private int id;

	@Column(name = "fecha", length = 200, nullable = false)
    @Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "contenido", length = 255, nullable = false)
	private String contenido;

	@ManyToOne
	@JoinColumn(name = "unidadorganizativa", nullable = false)
	private UnidadOrganizativa unidadorganizativa;

	@ManyToOne
	@JoinColumn(name = "tipoobservacion", nullable = false)
	private TipoObservacion tipoobservacion;

	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "referenciaobservacion", nullable = false)
	private ReferenciaObservacion referenciaobservacion;

	@ManyToOne
	@JoinColumn(name = "clasificacionobservacion", nullable = false)
	private ClasificacionObservacion clasificacionobservacion;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_TIPOOBSERVACION;
	
	public ObservacionEntrega() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public UnidadOrganizativa getUnidadorganizativa() {
		return unidadorganizativa;
	}

	public void setUnidadorganizativa(UnidadOrganizativa unidadorganizativa) {
		this.unidadorganizativa = unidadorganizativa;
	}

	public TipoObservacion getTipoobservacion() {
		return tipoobservacion;
	}

	public void setTipoobservacion(TipoObservacion tipoobservacion) {
		this.tipoobservacion = tipoobservacion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ReferenciaObservacion getReferenciaobservacion() {
		return referenciaobservacion;
	}

	public void setReferenciaobservacion(
			ReferenciaObservacion referenciaobservacion) {
		this.referenciaobservacion = referenciaobservacion;
	}

	public ClasificacionObservacion getClasificacionobservacion() {
		return clasificacionobservacion;
	}

	public void setClasificacionobservacion(
			ClasificacionObservacion clasificacionobservacion) {
		this.clasificacionobservacion = clasificacionobservacion;
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
		result = prime
				* result
				+ ((clasificacionobservacion == null) ? 0
						: clasificacionobservacion.hashCode());
		result = prime * result
				+ ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime
				* result
				+ ((referenciaobservacion == null) ? 0 : referenciaobservacion
						.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((tipoobservacion == null) ? 0 : tipoobservacion.hashCode());
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
		ObservacionEntrega other = (ObservacionEntrega) obj;
		if (clasificacionobservacion == null) {
			if (other.clasificacionobservacion != null)
				return false;
		} else if (!clasificacionobservacion
				.equals(other.clasificacionobservacion))
			return false;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (referenciaobservacion == null) {
			if (other.referenciaobservacion != null)
				return false;
		} else if (!referenciaobservacion.equals(other.referenciaobservacion))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tipoobservacion == null) {
			if (other.tipoobservacion != null)
				return false;
		} else if (!tipoobservacion.equals(other.tipoobservacion))
			return false;
		if (unidadorganizativa == null) {
			if (other.unidadorganizativa != null)
				return false;
		} else if (!unidadorganizativa.equals(other.unidadorganizativa))
			return false;
		return true;
	}

	
@Override
	public String toString() {
		return getFecha() + " - " + getUnidadorganizativa()
				+ " - " + getTipoobservacion() + " - " + getReferenciaobservacion()
				+ " - "	+ getClasificacionobservacion();
	}

	/*	@Override
	public String toString() {
		return getFecha() + " - " + getTipoobservacion() + " - "
				+ getUnidadorganizativa();
	}
*/
	@Override
	public int compareTo(ObservacionEntrega o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_TIPOOBSERVACION:
			return getTipoobservacion().compareTo(o.getTipoobservacion());
		case ORDENAMIENTO_POR_CLASIFICACION:
			return getClasificacionobservacion().compareTo(
					o.getClasificacionobservacion());
		case ORDENAMIENTO_POR_FECHA:
			return getFecha().compareTo(o.getFecha());
		case ORDENAMIENTO_POR_REFERENCIA:
			return getReferenciaobservacion().compareTo(
					o.getReferenciaobservacion());
		case ORDENAMIENTO_POR_UNIDAD:
			return getUnidadorganizativa().compareTo(o.getUnidadorganizativa());
		default:
			return 0;
		}
	}

}
