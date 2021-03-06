package com.sistema.modelo.data;

import java.io.Serializable;


//import com.jgoodies.binding.beans.Model;

public class DataGenerica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7347883374637930628L;
	public final static String DATA_ACTIVO = "A"; 
	public final static String DATA_INACTIVO = "I";
	public final static String ESTADO = "estado";
	
	private String estado = "";

	private String auxBinding;
	
	public DataGenerica(){
		this.auxBinding = null;				
	}

	public DataGenerica(String auxBinding){
		this.auxBinding = auxBinding;
	}
	
	public String toString(){
		/*String valor = "";
		try {
			valor = (String)PropertyUtils.getProperty(this, this.propiedadComboBinding);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;*/
		return "";
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAuxBinding() {
		return auxBinding;
	}

	public void setAuxBinding(String auxBinding) {
		this.auxBinding = auxBinding;
	}

}
