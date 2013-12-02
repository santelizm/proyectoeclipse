/**
 * 
 */
package org.edu.ucla.dcyt.redwood.sigmys.herramientas;

import java.net.URL;

/**
 * Clase de Utilidades del Sistema
 * 
 * @since Viernes 04-01-2013 04:25 PM.
 * @author Greg
 * @version 1.0 Viernes 04-01-2013 04:25 PM.
 * 
 */
public class UtilidadSigmys {

	/**
	 * 
	 * @return El directorio actual de trabajo
	 */
	public static String obtenerDirectorio() {
		URL rutaURL = UtilidadSigmys.class.getProtectionDomain()
				.getCodeSource().getLocation();
		String ruta = rutaURL.getPath();
		return ruta.substring(1, ruta.indexOf(".metadata"));
	}

}
