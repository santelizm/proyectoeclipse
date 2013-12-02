package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sinergia.modelo.data.general.Archivo;
import javax.persistence.Entity;

@Table(name = "noticia", schema = "sigmys")
@Entity
public class Noticia implements Comparable<Noticia>, Serializable {

	public static final int ORDENAMIENTO_POR_TITULO = 1;
	public static final int ORDENAMIENTO_POR_SUBTITULO = 2;
	public static final int ORDENAMIENTO_POR_AUTOR = 3;
	public static final int ORDENAMIENTO_POR_FECHAPUBLICACION = 4;
	public static final int ORDENAMIENTO_POR_FECHAFIN = 5;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "NOTICIA_ID_GENERATOR", sequenceName = "NOTICIA_CODIGO_SEQ", allocationSize = 1, schema = "sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTICIA_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false, unique = false)
	private int id;

	@Column(name = "titulo", length = 100, nullable = false, unique = false)
	private String titulo;

	@Column(name = "subtitulo", length = 100, nullable = false, unique = false)
	private String subtitulo;

	private Archivo imagen = new Archivo();

	@Column(name = "autor", length = 30, nullable = false, unique = false)
	private String autor;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechapublicacion", nullable = false, unique = false)
	private Date fechapublicacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fechafin", nullable = false, unique = false)
	private Date fechafin;

	@Column(name = "contenido", length = 255, nullable = false, unique = false)
	private String contenido;

	@ManyToOne
	@JoinColumn(name = "unidadorganizativa", nullable = false, unique = false)
	private UnidadOrganizativa unidadorganizativa;

	@Column(name = "status", length = 1, nullable = false, unique = false)
	private String status;

	private static int tipoOrdenamiento = ORDENAMIENTO_POR_TITULO;

	public Noticia() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSubtitulo() {
		return subtitulo;
	}

	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFechapublicacion() {
		return fechapublicacion;
	}

	public void setFechapublicacion(Date fechapublicacion) {
		this.fechapublicacion = fechapublicacion;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
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

	public void setUnidadOrganizativa(UnidadOrganizativa unidadOrganizativa) {
		this.unidadorganizativa = unidadOrganizativa;
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
		return this.getTitulo() + " - " + this.getFechapublicacion();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result
				+ ((contenido == null) ? 0 : contenido.hashCode());
		result = prime * result
				+ ((fechafin == null) ? 0 : fechafin.hashCode());
		result = prime
				* result
				+ ((fechapublicacion == null) ? 0 : fechapublicacion.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((subtitulo == null) ? 0 : subtitulo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		Noticia other = (Noticia) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (contenido == null) {
			if (other.contenido != null)
				return false;
		} else if (!contenido.equals(other.contenido))
			return false;
		if (fechafin == null) {
			if (other.fechafin != null)
				return false;
		} else if (!fechafin.equals(other.fechafin))
			return false;
		if (fechapublicacion == null) {
			if (other.fechapublicacion != null)
				return false;
		} else if (!fechapublicacion.equals(other.fechapublicacion))
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (subtitulo == null) {
			if (other.subtitulo != null)
				return false;
		} else if (!subtitulo.equals(other.subtitulo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public int compareTo(Noticia o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_TITULO:
			return getTitulo().compareTo(o.getTitulo());
		case ORDENAMIENTO_POR_SUBTITULO:
			return getSubtitulo().compareTo(o.getSubtitulo());
		case ORDENAMIENTO_POR_AUTOR:
			return getAutor().compareTo(o.getAutor());
		case ORDENAMIENTO_POR_FECHAPUBLICACION:
			return getFechapublicacion().compareTo(o.getFechapublicacion());
		case ORDENAMIENTO_POR_FECHAFIN:
			return getFechafin().compareTo(o.getFechafin());
		default:
			return 0;
		}
	}

}
