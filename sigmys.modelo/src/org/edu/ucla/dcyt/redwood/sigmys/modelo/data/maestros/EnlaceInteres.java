package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sinergia.modelo.data.general.Archivo;
import javax.persistence.Entity;

@Table(name = "enlaceinteres", schema = "sigmys")
@Entity
public class EnlaceInteres implements Comparable<EnlaceInteres>, Serializable {

	public static final int ORDENAMIENTO_POR_LINKENLACE = 1;
	public static final int ORDENAMIENTO_POR_UNIDAD = 2;

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
	@SequenceGenerator(name = "ENLACEINTERES_ID_GENERATOR", sequenceName = "ENLACEINTERES_ID_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENLACEINTERES_ID_GENERATOR")
	@Column(name = "id", length = 4)
	private int id;

	private Archivo imagen;

	@Column(name = "linkenlace", length = 255, nullable = false)
	private String linkenlace;

	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "unidadorganizativa", nullable = false)
	private UnidadOrganizativa unidadorganizativa;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_LINKENLACE;

	public EnlaceInteres() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Archivo getImagen() {
		return imagen;
	}

	public void setImagen(Archivo imagen) {
		this.imagen = imagen;
		if (this.imagen != null) {
			if (this.imagen.getContenido().length > 0) {
				this.imagen.setTipo("unknown");
			} else {
				this.imagen.setContenido(new byte[] {});
				this.imagen.setTipo("");
			}
		} else {
			this.imagen = new Archivo();
		}
	}

	public String getLinkenlace() {
		return linkenlace;
	}

	public void setLinkenlace(String linkenlace) {
		this.linkenlace = linkenlace;
	}

	public UnidadOrganizativa getUnidadorganizativa() {
		return unidadorganizativa;
	}

	public void setUnidadOrganizativa(UnidadOrganizativa unidadorganizativa) {
		this.unidadorganizativa = unidadorganizativa;
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
	public String toString() {
		return this.getLinkenlace();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		EnlaceInteres other = (EnlaceInteres) obj;
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
	public int compareTo(EnlaceInteres o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_LINKENLACE:
			return getLinkenlace().compareTo(o.getLinkenlace());
		case ORDENAMIENTO_POR_UNIDAD:
			return getUnidadorganizativa().compareTo(o.getUnidadorganizativa());
		default:
			return 0;
		}
	}

}
