package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "ordenentrega", schema = "sigmys")
@Entity
public class OrdenEntrega implements Comparable<OrdenEntrega>, Serializable {

	public static final int ORDENAMIENTO_POR_NUMERO = 1;
	public static final int ORDENAMIENTO_POR_FECHA = 2;
	public static final int ORDENAMIENTO_POR_OBSERVACIONENTREGA = 3;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "ORDENENTREGA_ID_GENERATOR", sequenceName = "ORDENENTREGA_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDENENTREGA_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false, unique = true)
	private int id;

	@Column(name = "fecha", nullable = false, length = 10, unique = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name = "status", length = 1, nullable = false, unique = false)
	private String status = "A";

	@ManyToOne
	@JoinColumn(name = "observacionentrega", nullable = true, unique = false)
	private ObservacionEntrega observacionentrega;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "ordenentrega")
	private Set<MaterialOrdenEntrega> materialesordenentrega = new HashSet<MaterialOrdenEntrega>();

	@Column(name = "numero", length = 15, nullable = false, unique = true)
	private String numero;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "ordenentrega")
	private Set<UnidadOrdenEntrega> unidadesordenentrega = new HashSet<UnidadOrdenEntrega>();

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NUMERO;

	public OrdenEntrega() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdenEntrega(EntregaEventual entregaEventual) {
		super();
		List<DetalleMaterialEntregaEventual> materialesEntregaEventual = new ArrayList<DetalleMaterialEntregaEventual>(
				entregaEventual.getMaterialesentregaeventual());
		List<DetalleUnidadEntregaEventual> unidadesEntregaEventual = new ArrayList<DetalleUnidadEntregaEventual>(
				entregaEventual.getUnidadesentregaeventual());
		for (int i = 0; i < materialesEntregaEventual.size(); i++) {
			MaterialOrdenEntrega materialOrdenEntrega = new MaterialOrdenEntrega();
			materialOrdenEntrega.setOrdenentrega(this);
			materialOrdenEntrega.setMaterial(materialesEntregaEventual.get(i)
					.getMaterial());
			materialOrdenEntrega.setCantidadentregada(materialesEntregaEventual
					.get(i).getCantidad());
			materialesordenentrega.add(materialOrdenEntrega);
		}
		for (int i = 0; i < unidadesEntregaEventual.size(); i++) {
			UnidadOrdenEntrega unidadOrdenEntrega = new UnidadOrdenEntrega();
			unidadOrdenEntrega.setOrdenEntrega(this);
			unidadOrdenEntrega.setUnidadorganizativa(unidadesEntregaEventual
					.get(i).getUnidadorganizativa());
			unidadOrdenEntrega.setDestino(unidadesEntregaEventual.get(i)
					.getDestino());
			unidadesordenentrega.add(unidadOrdenEntrega);
		}
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ObservacionEntrega getObservacionentrega() {
		return observacionentrega;
	}

	public void setObservacionentrega(ObservacionEntrega observacionentrega) {
		this.observacionentrega = observacionentrega;
	}

	

	@Override
	public String toString() {
		return getNumero() +  " - "  + getFecha();
	}

	public Set<MaterialOrdenEntrega> getMaterialesordenentrega() {
		return materialesordenentrega;
	}

	public void setMaterialesordenentrega(
			Set<MaterialOrdenEntrega> materialesordenentrega) {
		this.materialesordenentrega = materialesordenentrega;
	}

	public Set<UnidadOrdenEntrega> getUnidadesordenentrega() {
		return unidadesordenentrega;
	}

	public void setUnidadesordenentrega(
			Set<UnidadOrdenEntrega> unidadesordenentrega) {
		this.unidadesordenentrega = unidadesordenentrega;
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
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + id;
		// result = prime * result + ((materialesordenentrega == null) ? 0 :
		// materialesordenentrega.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		// result = prime* result + ((unidadesordenentrega == null) ? 0 :
		// unidadesordenentrega.hashCode());
	//	result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		OrdenEntrega other = (OrdenEntrega) obj;
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

		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	
	@Override
	public int compareTo(OrdenEntrega o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NUMERO:
			return getNumero().compareTo(o.getNumero());
		case ORDENAMIENTO_POR_FECHA:
			return getFecha().compareTo(o.getFecha());
		case ORDENAMIENTO_POR_OBSERVACIONENTREGA:
			return getObservacionentrega().compareTo(o.getObservacionentrega());
		default:
			return 0;
		}
	}

}
