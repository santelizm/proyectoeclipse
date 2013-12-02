package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EspacioFisico;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.UnidadOrganizativa;

@Table(name = "solicitudmaterial", schema = "sigmys")
@Entity
public class SolicitudMaterial implements Comparable<SolicitudMaterial>,
		Serializable {

	public static final int ORDENAMIENTO_POR_NUMERO = 1;
	public static final int ORDENAMIENTO_POR_FECHAEMISION = 2;
	public static final int ORDENAMIENTO_POR_UNIDAD = 3;
	public static final int ORDENAMIENTO_POR_DESTINO = 4;
	public static final int ORDENAMIENTO_POR_ESTADOSOLICITUD = 5;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SOLICITUDMATERIAL_ID_GENERATOR", sequenceName = "SOLICITUDMATERIAL_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SOLICITUDMATERIAL_ID_GENERATOR")
	@Column(name = "id", length = 4)
	private int id = -1;

	@Column(name = "fechaemision", length = 10, nullable = true)
	@Temporal(TemporalType.DATE)
	private Date fechaemision;

	@ManyToOne
	@JoinColumn(name = "unidadorganizativa", nullable = true)
	private UnidadOrganizativa unidadorganizativa;

	@ManyToOne
	@JoinColumn(name = "destino", nullable = false)
	private EspacioFisico destino;

	@Column(name = "status", length = 1, nullable = false, unique = false)
	private String status = "A";

	@Column(name = "numero", length = 10, unique = true)
	private String numero;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "solicitudMaterial")
	private Set<MaterialSolicitado> detalles = new HashSet<MaterialSolicitado>();

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NUMERO;
	
	private String estadosolicitud;

	public SolicitudMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set<MaterialSolicitado> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<MaterialSolicitado> detalles) {
		this.detalles = detalles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaemision() {
		return fechaemision;
	}

	public void setFechaemision(Date fechaemision) {
		this.fechaemision = fechaemision;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result
				+ ((fechaemision == null) ? 0 : fechaemision.hashCode());
		result = prime * result + id;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		SolicitudMaterial other = (SolicitudMaterial) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (fechaemision == null) {
			if (other.fechaemision != null)
				return false;
		} else if (!fechaemision.equals(other.fechaemision))
			return false;
		if (id != other.id)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
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
		if (getNumero() != null) {
			return getNumero() + " - " + getFechaemision() + " - "
					+ getUnidadorganizativa() + " - " + getDestino();
		} else {
			return getFechaemision() + " - " + getUnidadorganizativa() + " - "
					+ getDestino();
		}

	}

	@Override
	public int compareTo(SolicitudMaterial o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NUMERO:
			return getNumero().compareTo(o.getNumero());
		case ORDENAMIENTO_POR_FECHAEMISION:
			return getFechaemision().compareTo(o.getFechaemision());
		case ORDENAMIENTO_POR_UNIDAD:
			return getUnidadorganizativa().compareTo(o.getUnidadorganizativa());
		case ORDENAMIENTO_POR_DESTINO:
			return getDestino().compareTo(o.getDestino());
		case ORDENAMIENTO_POR_ESTADOSOLICITUD:
			return getEstadosolicitud().compareTo(o.getEstadosolicitud());
		default:
			return 0;
		}
	}

	public String getEstadosolicitud() {
		estadosolicitud = "NO PROCESADA";
		int asignado, pendiente, rechazada, aprobada;
		asignado = pendiente = rechazada = aprobada = 0;
		Iterator<MaterialSolicitado> it = getDetalles().iterator();
		String estadoAux;
		while(it.hasNext()) {
			estadoAux  = "";
			estadoAux = it.next().getEstadoMaterialSolicitado().getNombre();
			if (estadoAux.equals("RECHAZADO"))
				rechazada++;
			else if (estadoAux.equals("ENTREGADO"))
				aprobada++;
			else if (estadoAux.equals("ASIGNADO"))
				asignado++;
			else if (estadoAux.equals("PENDIENTE"))
				pendiente++;
		}
		int restoAsignada = 0;
		int restoPendiente = 0;
		int restoRechazada = 0;
		restoAsignada = getDetalles().size() - asignado;
		restoPendiente = getDetalles().size() - asignado;
		restoRechazada = getDetalles().size() - rechazada;
		if (getDetalles().size() == rechazada)
			estadosolicitud = "RECHAZADA";
		else if (getDetalles().size() == asignado)
			estadosolicitud = "TOTALMENTE APROBADA";
		else if (asignado >= 1 && rechazada == restoAsignada)
			estadosolicitud = "PARCIALMENTE APROBADA";
		else if (asignado >= 1 && pendiente == restoPendiente)
			estadosolicitud = "PARCIALMENTE APROBADA";
		else if (rechazada >= 1 && pendiente == restoRechazada)
			estadosolicitud = "PENDIENTE";
		else if (asignado >= 1 && rechazada >= 1 && pendiente >= 1)
			estadosolicitud = "PARCIALMENTE APROBADA";
		return estadosolicitud;
	}

}
