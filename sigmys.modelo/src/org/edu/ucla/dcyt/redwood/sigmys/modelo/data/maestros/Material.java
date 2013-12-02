package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sinergia.modelo.data.general.Archivo;
import com.sun.istack.internal.NotNull;


@Table(name = "material", schema = "sigmys")
@Entity
public class Material implements Comparable<Material>, Serializable {

	public static final int ORDENAMIENTO_POR_CODIGO=1;
	public static final int ORDENAMIENTO_POR_NOMBRE=2;
	public static final int ORDENAMIENTO_POR_TIPOMATERIAL=3;
	public static final int ORDENAMIENTO_POR_EXISTENCIA=4;
	public static final int ORDENAMIENTO_POR_STOCKMIN=5;
	public static final int ORDENAMIENTO_POR_STOCKMAX=6;
	public static final int ORDENAMIENTO_POR_MEDIDA=7;
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", length = 4)
	@SequenceGenerator(name = "ID_MATERIAL_GENERATOR", sequenceName = "MATERIAL_ID_SEQ", allocationSize = 1,  schema="sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MATERIAL_GENERATOR")
	private int id;

	@Column(name = "codigo", length = 30, nullable = false)
	private String codigo;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "descripcion", length = 80, nullable = false)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "tipomaterial", nullable = false)
	private TipoMaterial tipomaterial;

	@Embedded
	private Archivo imagen = new Archivo();

	@Column(name = "stockminimo", nullable = false)
	private int stockminimo;

	@NotNull
	@Column(name = "stockmaximo", nullable = false)
	private int stockmaximo;

	@NotNull
	@Column(name = "existencia", nullable = false)
	private int existencia;

	@Column(name = "status", length = 1, nullable = false)
	private String status;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medida", nullable = false)
	private Medida medida;
	
	private static int tipoOrdenamiento=ORDENAMIENTO_POR_NOMBRE;
	
	public Material() {
	}

	public int getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoMaterial getTipomaterial() {
		return tipomaterial;
	}

	public void setTipomaterial(TipoMaterial tipomaterial) {
		this.tipomaterial = tipomaterial;
	}

	public Archivo getImagen() {
		return imagen;
	}

	public int getTipoOrdenamiento() {
		return tipoOrdenamiento;
	}

	public void setTipoOrdenamiento(int tipoOrdenamiento) {
		this.tipoOrdenamiento = tipoOrdenamiento;
	}

	public void setImagen(Archivo imagen) {
		this.imagen = imagen;
		if (this.imagen != null) {
			// this.imagen.setnombreArchivo("foto.jpg");
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

	public int getStockminimo() {
		return stockminimo;
	}

	public void setStockminimo(int stockminimo) {
		this.stockminimo = stockminimo;
	}

	public int getStockmaximo() {
		return stockmaximo;
	}

	public void setStockmaximo(int stockmaximo) {
		this.stockmaximo = stockmaximo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	@Override
	public String toString() {
		return this.getNombre();
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
		Material other = (Material) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int compareTo(Material o) {
		switch (getTipoOrdenamiento()) {
			case ORDENAMIENTO_POR_CODIGO: return getCodigo().compareTo(o.getCodigo());
			case ORDENAMIENTO_POR_NOMBRE: return getNombre().compareTo(o.getNombre());
			case ORDENAMIENTO_POR_MEDIDA: return getMedida().compareTo(o.getMedida());
			case ORDENAMIENTO_POR_EXISTENCIA: return Integer.valueOf(getExistencia()).compareTo(o.getExistencia());
			case ORDENAMIENTO_POR_STOCKMAX: return Integer.valueOf(getStockmaximo()).compareTo(o.getStockmaximo());
			case ORDENAMIENTO_POR_STOCKMIN: return Integer.valueOf(getStockminimo()).compareTo(o.getStockminimo());
			case ORDENAMIENTO_POR_TIPOMATERIAL: return getTipomaterial().compareTo(o.getTipomaterial());
		default:
			return 0;
		}
	}
}
