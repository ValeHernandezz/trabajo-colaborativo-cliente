package view.helpers;

import javax.swing.JOptionPane;

public class Helper {

	public static boolean esUnDocumento(String documento) {

		boolean esUnNumero;

		try {

			int numero = Integer.parseInt(documento);
			return esUnNumero = true;

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "No es un documento válido \nEjemplo: 5555555", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			return esUnNumero = false;

		}
	}

	public static boolean validarCedulaUruguaya(String cedula) {

		// Para evitar que todos los digitos de la cédula sean iguales.
		if (cedula.matches("(\\d)[-]*[$1]+")) {
			return false;
		}

		int suma = 0;
		for (int i = 0; i < 7; i++) {
			int digito = Integer.parseInt(String.valueOf(cedula.charAt(i)));
			int factor = Integer.parseInt(String.valueOf("2987634".charAt(i)));
			suma += digito * factor;
		}
		
		int verificador = 10 - (suma % 10);
		if (verificador > 9) {
			verificador = 0;
		}
		
		int ultimoDigito = Integer.parseInt(String.valueOf(cedula.charAt(7)));
		return verificador == ultimoDigito;

	}

	public static boolean comprobarFecha(String dia, String mes, String anio) {

		boolean esUnNumero;
		if (dia.equals("Día") || mes.equals("Mes") || anio.equals("Año")) {
			JOptionPane.showMessageDialog(null, "La fecha no puede estar vacía", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		try {

			int diaEsNumero = Integer.parseInt(dia);
			int mesEsNumero = Integer.parseInt(mes);
			int anioEsNumero = Integer.parseInt(anio);

			return esUnNumero = true;

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null, "Ingrese una fecha válida", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return esUnNumero = false;

		}

	}

	public static boolean esUnaFechaValida(int dia, int mes, int anio) {
		
		if (dia > 31 || mes > 12 || anio > 2005 || anio < 1930) {
			JOptionPane.showMessageDialog(null, "Fecha inválida", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return false;
			
		}else {
			return true;
		}
	}

	public static boolean comprobarDatos(String primerNombre, String primerApellido, String fechaNacimiento,
			String documento, String clave, int idRol, String mail) {

		boolean respuesta;

		if (primerNombre.length() < 3 || primerApellido.length() < 3 || fechaNacimiento == null
				|| documento.length() < 6 || clave.length() < 5 || idRol == 0 || mail.length() < 6) {

			JOptionPane.showMessageDialog(null, "Debe completar los campos", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			return respuesta = false;

		}

		return respuesta = true;
	}

}
