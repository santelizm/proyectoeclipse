package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoMaterialRequerido;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoRequisicion;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.TipoRequisicion;

@Table(name = "requisicion", schema = "sigmys")
@Entity
public class Requisicion implements Comparable<Requisicion>, Serializable {

	public static final int ORDENAMIENTO_POR_NUMERO = 1;
	public static final int ORDENAMIENTO_POR_FECHA = 2;
	public static final int ORDENAMIENTO_POR_TIPOREQUISICION = 3;
	public static final int ORDENAMIENTO_POR_ESTADOREQUISICION = 4;
	public static final int ORDENAMIENTO_POR_OBSERVACION = 5;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "REQUISICION_ID_GENERATOR", sequenceName = "REQUSICION_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REQUISICION_ID_GENERATOR")
	@Column(name = "id", length = 4)
	private int id;

	@Column(name = "numero", length = 8, nullable = true, unique = true)
	private String numero;

	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "observacion", nullable = true, length = 255)
	private String observacion;

	@ManyToOne
	@JoinColumn(name = "tiporequisicion", nullable = false)
	private TipoRequisicion tiporequisicion;

	@ManyToOne
	@JoinColumn(name = "estadorequisicion", nullable = false)
	private EstadoRequisicion estadorequisicion;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "requisicion", orphanRemoval = true)
	private Set<MaterialRequerido> materialesrequeridos = new HashSet<MaterialRequerido>();

	@Column(name = "status", nullable = false, length = 1)
	private String status = "A";

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NUMERO;

	public Requisicion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public TipoRequisicion getTiporequisicion() {
		return tiporequisicion;
	}

	public void setTiporequisicion(TipoRequisicion tiporequisicion) {
		this.tiporequisicion = tiporequisicion;
	}

	public EstadoRequisicion getEstadorequisicion() {
		return estadorequisicion;
	}

	public void setEstadorequisicion(EstadoRequisicion estadorequisicion) {
		this.estadorequisicion = estadorequisicion;
	}

	public Set<MaterialRequerido> getMaterialesrequeridos() {
		return materialesrequeridos;
	}

	public void setMaterialesrequeridos(
			Set<MaterialRequerido> materialesrequeridos) {
		this.materialesrequeridos = materialesrequeridos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
				+ ((estadorequisicion == null) ? 0 : estadorequisicion
						.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result
				+ ((observacion == null) ? 0 : observacion.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((tiporequisicion == null) ? 0 : tiporequisicion.hashCode());
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
		Requisicion other = (Requisicion) obj;
		if (estadorequisicion == null) {
			if (other.estadorequisicion != null)
				return false;
		} else if (!estadorequisicion.equals(other.estadorequisicion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (observacion == null) {
			if (other.observacion != null)
				return false;
		} else if (!observacion.equals(other.observacion))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tiporequisicion == null) {
			if (other.tiporequisicion != null)
				return false;
		} else if (!tiporequisicion.equals(other.tiporequisicion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (getNumero() != null) {
			return getNumero() + " - " + getFecha() + " - "
			+ getEstadorequisicion().getNombre();
		} else {
			return getFecha() + " - "
			+ getEstadorequisicion().getNombre();
		}	
	}

	@Override
	public int compareTo(Requisicion o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NUMERO:
			return getNumero().compareTo(o.getNumero());
		case ORDENAMIENTO_POR_FECHA:
			return getFecha().compareTo(o.getFecha());
		case ORDENAMIENTO_POR_TIPOREQUISICION:
			return getTiporequisicion().compareTo(o.getTiporequisicion());
		case ORDENAMIENTO_POR_ESTADOREQUISICION:
			return getEstadorequisicion().compareTo(o.getEstadorequisicion());
		case ORDENAMIENTO_POR_OBSERVACION:
			return getObservacion().compareTo(o.getObservacion());
		default:
			return 0;
		}
	}

	public List<Material> getMateriales() {
		List<MaterialRequerido> aux = new ArrayList<MaterialRequerido>(
				materialesrequeridos);
		List<Material> materiales = new ArrayList<Material>();
		for (int i = 0; i < materialesrequeridos.size(); i++) {
			materiales.add(aux.get(i).getMaterial());
		}
		return materiales;
	}

	public List<Material> getMateriales(EstadoMaterialRequerido estado) {
		List<MaterialRequerido> materialesRequeridos = new ArrayList(
				materialesrequeridos);
		List<Material> materiales = new ArrayList<Material>();
		for (int i = 0; i < materialesRequeridos.size(); i++) {
			if (materialesRequeridos.get(i).getEstadomaterialrequerido()
					.equals(estado)) {
				materiales.add(materialesRequeridos.get(i).getMaterial());
			}
		}
		return materiales;
	}

	public void actualizarEstadoMaterialesRequeridos(List<Material> materiales,
			EstadoMaterialRequerido estado) {
		List<MaterialRequerido> materialesRequeridos = new ArrayList(
				materialesrequeridos);
		for (int y = 0; y < materiales.size(); y++) {
			for (int i = 0; i < materialesRequeridos.size(); i++) {
				if (materiales.get(y).equals(
						materialesRequeridos.get(i).getMaterial())) {
					materialesRequeridos.get(i).setEstadomaterialrequerido(
							estado);
					i = materialesRequeridos.size();
					System.out.println("Actualizando Estado");
				}
			}
		}
		actualizaEstadoRequisicion();
		this.materialesrequeridos.clear();
		this.materialesrequeridos.addAll(materialesRequeridos);
	}

	private void actualizaEstadoRequisicion() {
		int pendites = 0;
		List<MaterialRequerido> materialesRequeridos = new ArrayList(
				materialesrequeridos);
		for (int i = 0; i < materialesRequeridos.size(); i++) {
			if (materialesRequeridos.get(i).getEstadomaterialrequerido()
					.getId() == 1) {
				pendites++;
				i = materialesRequeridos.size();
			}
		}
		if (pendites == 0) {
			this.setStatus("R");
		}
	}
	
	public String getEstadoRequisicion() {
		String estadoRequisicion = "EN TRAMITE";
		int pendiente, recibido;
		pendiente = recibido = 0;
		Iterator<MaterialRequerido> it = getMaterialesrequeridos().iterator();
		String estadoAux;
		while(it.hasNext()) {
			estadoAux  = "";
			estadoAux = it.next().getEstadomaterialrequerido().getNombre();
			if (estadoAux.equals("RECIBIDO")){
				recibido++;
			}else if (estadoAux.equals("PENDIENTE"))
				pendiente++;
		}
		int restoRecibido = 0;
		int restoPendiente = 0;
		restoRecibido = getMaterialesrequeridos().size() - recibido;
		if (restoRecibido==0)
			estadoRequisicion = "TOTALMENTE APROBADA";
		else if (recibido>=1 && pendiente>=1)
			estadoRequisicion = "PARCIALMENTE APROBADA";
		return estadoRequisicion;
	}
}
