/********************************************************
 * Interfaz: TipoMaterial
 * Autor: Skarla - Zurveli(18-12-2012 y 5:34pm)                           *
 * Estandarizado: Si                                       *
 * Modificado Nro1 por: Skarla - Zurveli(18-12-2012 y 5:34pm)            *                                                                      
 *Motivo: Creacion de Servicio y Vista                                                                   *
 *********************************************************/

package org.edu.ucla.dcyt.redwood.sigmys.modelo.data.maestros;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "tipomaterial", schema = "sigmys")
@Entity
public class TipoMaterial implements Comparable<TipoMaterial>, Serializable {
	
	public static final int ORDENAMIENTO_POR_NOMBRE = 1;

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "TIPOMATERIAL_ID_GENERATOR", sequenceName = "TIPOMATERIAL_CODIGO_SEQ", allocationSize = 1,  schema="sigmys")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIPOMATERIAL_ID_GENERATOR")
	@Column(name = "id", length = 4, nullable = false)
	private int id;

	@Column(name = "nombre", length = 30, nullable = false, unique = true)
	private String nombre;

	@Column(name = "status", length = 1, nullable = false)
	private String status;
	
	private static int tipoOrdenamiento = ORDENAMIENTO_POR_NOMBRE;

	public TipoMaterial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
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
		return this.getNombre();
	}

	public String infoResumida() {
		return this.getNombre();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		TipoMaterial other = (TipoMaterial) obj;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public int compareTo(TipoMaterial o) {
		switch (getTipoOrdenamiento()) {
		case ORDENAMIENTO_POR_NOMBRE:
			return getNombre().compareTo(o.getNombre());
		default:
			return 0;
		}
	}

}
