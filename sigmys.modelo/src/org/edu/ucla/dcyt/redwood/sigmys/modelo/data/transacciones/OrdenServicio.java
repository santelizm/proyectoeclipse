package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Material;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.OrigenCompra;
import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proveedor;

@Table(name = "ordenservicio", schema = "sigmys")
@Entity
public class OrdenServicio implements Comparable<OrdenServicio>, Serializable {

	public static final int ORDENAMIENTO_POR_NUMERO = 1;
	public static final int ORDENAMIENTO_POR_FECHA = 2;
	public static final int ORDENAMIENTO_POR_NUMEROCOMPROMISO = 3;
	public static final int ORDENAMIENTO_POR_ORIGENCOMPRA = 4;
	public static final int ORDENAMIENTO_POR_DESCRIPCION = 5;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ORDENSERVICIO_ID_GENERATOR", sequenceName = "ORDENSERVICIO_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDENSERVICIO_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false, unique = false)
	private int id;

	@Column(name = "descripcion", length = 80, nullable = false, unique = false)
	private String descripcion;

	@Column(name = "fecha", length = 10, nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "status", length = 1, nullable = false, unique = false)
	private String status;

	@Column(name = "numerocompromiso", length = 15, nullable = false, unique = true)
	private String numerocompromiso;

	@Column(name = "numero", length = 15, nullable = false, unique = true)
	private String numero;

	@ManyToOne
	@JoinColumn(name = "origencompra", nullable = false, unique = false)
	private OrigenCompra origencompra;
	
	@ManyToOne
	@JoinColumn(name = "proveedor", nullable = false, unique = false)
	private Proveedor proveedor;


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "ordendeservicio")
	private List<MaterialRecibido> materialesrecibidos = new ArrayList<MaterialRecibido>();

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NUMERO;

	public OrdenServicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public void setOrigenCompra(OrigenCompra origencompra) {
		this.origencompra = origencompra;

	}

	public List<MaterialRecibido> getMaterialesrecibidos() {
		return materialesrecibidos;
	}

	public void setMaterialesrecibidos(List<MaterialRecibido> detalles) {
		this.materialesrecibidos = detalles;
	}

	public OrigenCompra getOrigencompra() {
		return origencompra;
	}

	public void setOrigencompra(OrigenCompra origencompra) {
		this.origencompra = origencompra;
	}

	public String getNumerocompromiso() {
		return numerocompromiso;
	}

	public void setNumerocompromiso(String numerocompromiso) {
		this.numerocompromiso = numerocompromiso;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		result = prime
				* result
				+ ((numerocompromiso == null) ? 0 : numerocompromiso.hashCode());
		result = prime * result
				+ ((origencompra == null) ? 0 : origencompra.hashCode());
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
		OrdenServicio other = (OrdenServicio) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (id != other.id)
			return false;
		if (numerocompromiso == null) {
			if (other.numerocompromiso != null)
				return false;
		} else if (!numerocompromiso.equals(other.numerocompromiso))
			return false;
		if (origencompra == null) {
			if (other.origencompra != null)
				return false;
		} else if (!origencompra.equals(other.origencompra))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getNumero();
	}

	@Override
	public int compareTo(OrdenServicio o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NUMERO:
			return getNumero().compareTo(o.getNumero());
		case ORDENAMIENTO_POR_FECHA:
			return getFecha().compareTo(o.getFecha());
		case ORDENAMIENTO_POR_NUMEROCOMPROMISO:
			return getNumerocompromiso().compareTo(o.getNumerocompromiso());
		case ORDENAMIENTO_POR_ORIGENCOMPRA:
			return getOrigencompra().compareTo(o.getOrigencompra());
		case ORDENAMIENTO_POR_DESCRIPCION:
			return getDescripcion().compareTo(o.getDescripcion());
		default:
			return 0;
		}
	}

	public List<Material> getMateriales() {
		List<MaterialRecibido> aux = new ArrayList<MaterialRecibido>(
				materialesrecibidos);
		List<Material> materiales = new ArrayList<Material>();
		for (int i = 0; i < materialesrecibidos.size(); i++) {
			materiales.add(aux.get(i).getMaterial());
		}
		return materiales;
	}
}