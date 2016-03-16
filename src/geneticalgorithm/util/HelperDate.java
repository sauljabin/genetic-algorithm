/**
 * Copyright (c) 2014 Saúl Piña <sauljabin@gmail.com>.
 * 
 * This file is part of GeneticAlgorithm.
 * 
 * GeneticAlgorithm is licensed under The MIT License.
 * For full copyright and license information please see the LICENSE file.
 */

package geneticalgorithm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Clase para el manejo de la fecha
 * 
 * @author Saul Pina - sauljp07@gmail.com
 * @see http://docs.oracle.com/javase/tutorial/i18n/format/simpleDateFormat.html
 */
public abstract class HelperDate {
	private static SimpleDateFormat sdf;
	public static final String FORMATO_FECHA_SLASH = "dd/MM/yyyy";
	public static final String FORMATO_FECHA_GUION = "dd-MM-yyyy";
	public static final String FORMATO_HORA = "h:mm a";
	public static final String FORMATO_FECHA_HORA_SLASH = "dd/MM/yyyy h:mm a";
	public static final String FORMATO_FECHA_HORA_GUION = "dd-MM-yyyy h:mm a";
	public static final String FORMATO_POSTGRES_TIME = "H:mm:ss";
	public static final String FORMATO_POSTGRES_DATE = "yyyy-MM-dd";
	public static final String FORMATO_POSTGRES_TIMESTAMP = "yyyy-MM-dd H:mm:ss";

	public static final int ANNO = Calendar.YEAR;
	public static final int HORA = Calendar.HOUR;
	public static final int MINUTO = Calendar.MINUTE;
	public static final int SEGUNDO = Calendar.SECOND;
	public static final int DIA = Calendar.DAY_OF_MONTH;
	public static final int MES = Calendar.MONTH;

	/**
	 * Esta funcion formatea una fecha
	 * 
	 * @param date
	 *            Fecha que se va a formatear
	 * @param format
	 *            Formato a utilizar
	 * @return Fecha como String con el formato establecido
	 */
	public static String format(Date date, String format) {
		if (format == null)
			format = FORMATO_FECHA_GUION;
		sdf = new SimpleDateFormat(format, new Locale("es"));
		return sdf.format(date);
	}

	/**
	 * Envuelve la funcion Calendar.getInstance().getTime()
	 * 
	 * @return Fecha y hora actual
	 */
	public static Date now() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * Envuelve la funcion Calendar.getInstance().getTime()
	 * 
	 * @return Fecha y hora actual con formato
	 */
	public static String nowFormat(String format) {
		if (format == null)
			format = FORMATO_FECHA_GUION;
		sdf = new SimpleDateFormat(format, new Locale("es"));
		return sdf.format(Calendar.getInstance().getTime());
	}

	/**
	 * Esta funcion retorna una fecha futura, para el pasado usarnumeros
	 * negativos en cantidad ejemplo: HelperDate.future(HelperDate.MES,-3) tres
	 * meses atras
	 * 
	 * @param campo
	 *            ANNO, DIA, MES, HORA, MINUTO, SEGUNDO
	 * @param cantidad
	 *            Cuanto se va a sumar
	 * @return Fecha futura
	 */
	public static Date future(int campo, int cantidad) {
		Calendar ca = Calendar.getInstance();
		ca.add(campo, cantidad);
		return ca.getTime();
	}

	/**
	 * Esta funcion retorna una fecha futura, para el pasado usarnumeros
	 * negativos en cantidad
	 * 
	 * @param ca
	 *            Calendar
	 * @param campo
	 *            ANNO, DIA, MES, HORA, MINUTO, SEGUNDO
	 * @param cantidad
	 *            Cuanto se va a sumar
	 * @return Fecha futura
	 */
	public static Date future(Calendar ca, int campo, int cantidad) {
		Calendar caclone = (Calendar) ca.clone();
		caclone.add(campo, cantidad);
		return caclone.getTime();
	}

}
