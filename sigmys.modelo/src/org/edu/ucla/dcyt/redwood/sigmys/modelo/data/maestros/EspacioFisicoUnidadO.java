package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

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

import org.edu.ucla.dcyt.redwood.sigmys.modelo.data.transacciones.Requisicion;

@Table(name = "espaciofisicounidado", schema = "sigmys")
@Entity
public class EspacioFisicoUnidadO {

	@Id
	@SequenceGenerator(name = "ESPACIOFISICOUNIDADO_ID_GENERATOR", sequenceName = "ESPACIOFISICOUNIDADO_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESPACIOFISICOUNIDADO_ID_GENERATOR")
	@Column(name = "id", length = 4, unique = false)
	private int id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "unidadorganizativa", nullable = false, unique = false)
	private UnidadOrganizativa unidadorganizativa;

	@ManyToOne
	@JoinColumn(name = "espaciofisico", nullable = false, unique = false)
	private EspacioFisico espaciofisico;
	
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
	
	public void setEspaciofisico(EspacioFisico espaciofisico) {
		this.espaciofisico = espaciofisico;
	}

	public EspacioFisico getEspaciofisico() {
		return espaciofisico;
	}

	@Override
	public String toString() {
		return espaciofisico.getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		EspacioFisicoUnidadO other = (EspacioFisicoUnidadO) obj;
		if (id != other.id)
			return false;
		return true;
	}
}