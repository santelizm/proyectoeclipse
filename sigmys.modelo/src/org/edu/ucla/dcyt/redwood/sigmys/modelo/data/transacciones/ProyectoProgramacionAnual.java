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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros.Proyecto;

@Table(name = "proyectoprogramacionanual", schema = "sigmys")
@Entity
public class ProyectoProgramacionAnual implements
		Comparable<ProyectoProgramacionAnual>, Serializable {

	public static final int ORDENAMIENTO_POR_PROYECTO = 1;
	public static final int ORDENAMIENTO_POR_CODIGOOPSU = 2;
	public static final int ORDENAMIENTO_POR_PROGRAMACIONANUAL = 3;

	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "PROYECTOPROGAMACIONANUAL_ID_GENERATOR", sequenceName = "PROYECTOPROGAMACIONANUAL_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROYECTOPROGAMACIONANUAL_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false)
	private int id;

	@ManyToOne
	@JoinColumn(name = "proyecto", nullable = false)
	private Proyecto proyecto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "programacionanual", nullable = false)
	private ProgramacionAnual programacionanual;

	@Column(name = "codigoopsu")
	private String codigoopsu;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true, mappedBy = "proyectoprogramacionanual")
	private Set<MaterialProgramado> materialesprogramados = new HashSet<MaterialProgramado>();

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_PROYECTO;

	public ProyectoProgramacionAnual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public ProgramacionAnual getProgramacionanual() {
		return programacionanual;
	}

	public void setProgramacionanual(ProgramacionAnual programacionanual) {
		this.programacionanual = programacionanual;
	}

	public String getCodigoopsu() {
		return codigoopsu;
	}

	public void setCodigoopsu(String codigoopsu) {
		this.codigoopsu = codigoopsu;
	}

	public Set<MaterialProgramado> getMaterialesprogramados() {
		return materialesprogramados;
	}

	public void setMaterialesprogramados(
			Set<MaterialProgramado> materialesprogramados) {
		this.materialesprogramados = materialesprogramados;
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
		result = prime * result
				+ ((codigoopsu == null) ? 0 : codigoopsu.hashCode());
		result = prime * result + id;
		result = prime
				* result
				+ ((programacionanual == null) ? 0 : programacionanual
						.hashCode());
		result = prime * result
				+ ((proyecto == null) ? 0 : proyecto.hashCode());
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
		ProyectoProgramacionAnual other = (ProyectoProgramacionAnual) obj;
		if (codigoopsu == null) {
			if (other.codigoopsu != null)
				return false;
		} else if (!codigoopsu.equals(other.codigoopsu))
			return false;
		if (id != other.id)
			return false;
		if (programacionanual == null) {
			if (other.programacionanual != null)
				return false;
		} else if (!programacionanual.equals(other.programacionanual))
			return false;
		if (proyecto == null) {
			if (other.proyecto != null)
				return false;
		} else if (!proyecto.equals(other.proyecto))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getProyecto() + " - " + getCodigoopsu() + " - "
				+ getProgramacionanual().getAno();
	}

	@Override
	public int compareTo(ProyectoProgramacionAnual o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_PROYECTO:
			return getProyecto().compareTo(o.getProyecto());
		case ORDENAMIENTO_POR_CODIGOOPSU:
			return getCodigoopsu().compareTo(o.getCodigoopsu());
		case ORDENAMIENTO_POR_PROGRAMACIONANUAL:
			return getProgramacionanual().compareTo(o.getProgramacionanual());
		default:
			return 0;
		}
	}

}
