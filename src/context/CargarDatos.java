package context;

import java.util.ArrayList;

import com.entities.Funcionalidad;
import com.entities.Rol;
import com.entities.Usuario;

import services.ServiceFuncionalidad;
import services.ServiceRol;
import services.ServiceUsuario;

public class CargarDatos {

	public static void empezar() {
		
		var contador = ServiceRol.listarRoles().size();

		if (contador != 0) {
			return;
		}

		Funcionalidad oFuncionalidad = new Funcionalidad("Añade nuevos usuarios al sistema.", "Crear usuarios");
		Funcionalidad oFuncionalidad2 = new Funcionalidad("Modifica los datos de los usuarios existentes.", "Editar usuarios");
		Funcionalidad oFuncionalidad3 = new Funcionalidad("Elimina usuarios del sistema permanentemente.", "Eliminar usuarios");
		Funcionalidad oFuncionalidad4 = new Funcionalidad("Administra los permisos y roles de los usuarios en el sistema.", "Gestionar Permisos de Usuario");
		Funcionalidad oFuncionalidad5 = new Funcionalidad("Muestra una lista de usuarios registrados.", "Listar usuarios");
		Funcionalidad oFuncionalidad6 = new Funcionalidad("Genera un documento oficial que certifica una asistencia específica.", "Emitir Constancia");
		Funcionalidad oFuncionalidad7 = new Funcionalidad("Crea un documento que explica o justifica una acción o situación específica.", "Emitir Justificación");

		Funcionalidad oFuncionalidad8 = new Funcionalidad("Muestra una lista de usuarios registrados como estudiantes.", "Listar usuarios estudiantes");
		Funcionalidad oFuncionalidad9 = new Funcionalidad("Registra la presencia de un usuario en un evento específico.", "Registrar Asistencia a Evento");
		Funcionalidad oFuncionalidad10 = new Funcionalidad(" Crea documentos formales que recopilan información relevante sobre un evento o reunión.", "Generar Actas");

		Funcionalidad oFuncionalidad11 = new Funcionalidad("Listar todas las funcionalidades del sistema.", "Listar funcionalidades");
		Funcionalidad oFuncionalidad12 = new Funcionalidad("Permite a los usuarios solicitar un documento oficial que certifique una asistencia específica.", "Solicitar Constancia");
		Funcionalidad oFuncionalidad13 = new Funcionalidad("Permite a los usuarios solicitar una explicación o justificación para una acción o situación específica.", "Solicitar Justificación");

		Funcionalidad oFuncionalidadCreada = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad2);
		Funcionalidad oFuncionalidadCreada2 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad);
		Funcionalidad oFuncionalidadCreada3 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad3);
		Funcionalidad oFuncionalidadCreada4 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad4);
		Funcionalidad oFuncionalidadCreada5 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad5);
		Funcionalidad oFuncionalidadCreada6 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad6);
		Funcionalidad oFuncionalidadCreada7 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad7);
		Funcionalidad oFuncionalidadCreada8 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad8);
		Funcionalidad oFuncionalidadCreada9 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad9);
		Funcionalidad oFuncionalidadCreada10 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad10);
		Funcionalidad oFuncionalidadCreada11 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad11);
		Funcionalidad oFuncionalidadCreada12 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad12);
		Funcionalidad oFuncionalidadCreada13 = ServiceFuncionalidad.crearFuncionalidad(oFuncionalidad13);

		Rol oRol = new Rol("Gestor del sistema y solicitudes.", "Analista");
		Rol oRol2 = new Rol("Guía educativo y motivador.", "Tutor");
		Rol oRol3 = new Rol("Buscador de conocimiento y crecimiento.", "Estudiante");

		Rol oRolCreado = ServiceRol.crearRol(oRol);
		Rol oRolCreado2 = ServiceRol.crearRol(oRol2);
		Rol oRolCreado3 = ServiceRol.crearRol(oRol3);

		// Asignación de Funcionalidades a ANALISTA
		boolean seAsigno = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada);
		boolean seAsigno2 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada2);
		boolean seAsigno3 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada3);
		boolean seAsigno4 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada4);
		boolean seAsigno5 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada5);
		boolean seAsigno6 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada6);
		boolean seAsigno7 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada7);
		boolean seAsigno8 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado, oFuncionalidadCreada11);

		// Asignación de Funcionalidades a TUTOR
		boolean seAsigno9 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado2, oFuncionalidadCreada8);
		boolean seAsigno10 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado2, oFuncionalidadCreada9);
		boolean seAsigno11 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado2, oFuncionalidadCreada10);
		boolean seAsigno12 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado2, oFuncionalidadCreada11);

		// Asignación de Funcionalidades a ESTUDIANTE
		boolean seAsigno13 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado3, oFuncionalidadCreada11);
		boolean seAsigno14 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado3, oFuncionalidadCreada12);
		boolean seAsigno15 = ServiceRol.asignarFuncionalidadAUnRol(oRolCreado3, oFuncionalidadCreada13);

		Usuario oUsuario = new Usuario("Melendez", "1234", "23123122", "nico@nico.com", "Nicolás", "nicolas.melendez", oRolCreado);
		Usuario oUsuario2 = new Usuario("García", "5678", "98765432", "garcia@gmail.com", "Gabriel", "gabriel.garcia", oRolCreado);
		Usuario oUsuario3 = new Usuario("López", "abcd", "54321678", "lopez@gmail.com", "Laura", "laura.lopez", oRolCreado2);
		Usuario oUsuario4 = new Usuario("Rodríguez", "efgh", "87654321", "rodriguez@gmail.com", "Roberto", "roberto.rodriguez", oRolCreado2);
		Usuario oUsuario5 = new Usuario("Pérez", "ijkl", "13579246", "perez@gmail.com", "Patricia", "patricia.perez", oRolCreado2);
		Usuario oUsuario6 = new Usuario("González", "mnop", "62417358", "gonzalez@gmail.com", "Gustavo", "gustavo.gonzalez", oRolCreado3);
		Usuario oUsuario7 = new Usuario("Martínez", "qrst", "35824791", "martinez@gmail.com", "María", "maria.martinez", oRolCreado3);
		Usuario oUsuario8 = new Usuario("Hernández", "uvwx", "91742835", "hernandez@gmail.com", "Héctor", "hector.hernandez", oRolCreado3);
		Usuario oUsuario9 = new Usuario("Torres", "yzab", "26847593", "torres@gmail.com", "Tatiana", "tatiana.torres", oRolCreado);
		Usuario oUsuario10 = new Usuario("Díaz", "5678", "54328976", "diaz@gmail.com", "Diego", "diego.diaz", oRolCreado);
		Usuario oUsuario11 = new Usuario("Sanchez", "abcd", "87654321", "sanchez@gmail.com", "Sofía", "sofia.sanchez", oRolCreado2);
		Usuario oUsuario12 = new Usuario("Ramírez", "efgh", "31472589", "ramirez@gmail.com", "Ricardo", "ricardo.ramirez", oRolCreado2);
		Usuario oUsuario13 = new Usuario("Herrera", "ijkl", "98563417", "herrera@gmail.com", "Helena", "helena.herrera", oRolCreado2);
		Usuario oUsuario14 = new Usuario("Fernández", "mnop", "75983142", "fernandez@gmail.com", "Federico", "federico.fernandez", oRolCreado3);
		Usuario oUsuario15 = new Usuario("López", "qrst", "21457836", "lopez@gmail.com", "Lucía", "lucia.lopez", oRolCreado3);

		Usuario oUsuarioCreado = ServiceUsuario.crearUsuario(oUsuario);
		Usuario oUsuarioCreado2 = ServiceUsuario.crearUsuario(oUsuario2);
		Usuario oUsuarioCreado3 = ServiceUsuario.crearUsuario(oUsuario3);
		Usuario oUsuarioCreado4 = ServiceUsuario.crearUsuario(oUsuario4);
		Usuario oUsuarioCreado5 = ServiceUsuario.crearUsuario(oUsuario5);
		Usuario oUsuarioCreado6 = ServiceUsuario.crearUsuario(oUsuario6);
		Usuario oUsuarioCreado7 = ServiceUsuario.crearUsuario(oUsuario7);
		Usuario oUsuarioCreado8 = ServiceUsuario.crearUsuario(oUsuario8);
		Usuario oUsuarioCreado9 = ServiceUsuario.crearUsuario(oUsuario9);
		Usuario oUsuarioCreado10 = ServiceUsuario.crearUsuario(oUsuario10);
		Usuario oUsuarioCreado11 = ServiceUsuario.crearUsuario(oUsuario11);
		Usuario oUsuarioCreado12 = ServiceUsuario.crearUsuario(oUsuario12);
		Usuario oUsuarioCreado13 = ServiceUsuario.crearUsuario(oUsuario13);
		Usuario oUsuarioCreado14 = ServiceUsuario.crearUsuario(oUsuario14);
		Usuario oUsuarioCreado15 = ServiceUsuario.crearUsuario(oUsuario15);

	}

}
