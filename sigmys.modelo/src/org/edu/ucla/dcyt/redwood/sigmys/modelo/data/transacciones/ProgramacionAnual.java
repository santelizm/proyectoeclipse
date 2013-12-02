package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones;

import java.io.Serializable;
import java.util.HashSet;
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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.EstadoProgramacionAnual;

@Table(name = "programacionanual", schema = "sigmys")
@Entity
public class ProgramacionAnual implements Comparable<ProgramacionAnual>,
		Serializable {

	public static final int ORDENAMIENTO_POR_ANIO = 1;
	public static final int ORDENAMIENTO_POR_ESTADOPROGRAMACIONANUAL = 2;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "PROGRAMACIONANUAL_ID_GENERATOR", sequenceName = "PROGRAMACIONANUAL_CODIGO_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROGRAMACIONANUAL_ID_GENERATOR")
	@Column(name = "id", length = 4)
	private Integer id;

	@Column(name = "ano")
	private String ano;

	@ManyToOne
	@JoinColumn(name = "estadoprogramacionanual")
	private EstadoProgramacionAnual estadoprogramacionanual;

	@Column(name = "status")
	private String status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "programacionanual")
	private Set<ProyectoProgramacionAnual> proyectosprogramadoss = new HashSet<ProyectoProgramacionAnual>();

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_ANIO;

	public ProgramacionAnual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public EstadoProgramacionAnual getEstadoprogramacionanual() {
		return estadoprogramacionanual;
	}

	public void setEstadoprogramacionanual(
			EstadoProgramacionAnual estadoprogramacionanual) {
		this.estadoprogramacionanual = estadoprogramacionanual;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<ProyectoProgramacionAnual> getProyectosprogramadoss() {
		return proyectosprogramadoss;
	}

	public void setProyectosprogramadoss(
			Set<ProyectoProgramacionAnual> proyectosprogramadoss) {
		this.proyectosprogramadoss = proyectosprogramadoss;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	@Override
	public String toString() {
		return getAno() + " - " + getEstadoprogramacionanual().getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime
				* result
				+ ((estadoprogramacionanual == null) ? 0
						: estadoprogramacionanual.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ProgramacionAnual other = (ProgramacionAnual) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
		if (estadoprogramacionanual == null) {
			if (other.estadoprogramacionanual != null)
				return false;
		} else if (!estadoprogramacionanual
				.equals(other.estadoprogramacionanual))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(ProgramacionAnual o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_ANIO:
			return getAno().compareTo(o.getAno());
		case ORDENAMIENTO_POR_ESTADOPROGRAMACIONANUAL:
			return getEstadoprogramacionanual().compareTo(
					o.getEstadoprogramacionanual());
		default:
			return 0;
		}
	}

}
