package services;

import java.util.ArrayList;

import javax.naming.InitialContext;

import com.entities.Usuario;
import com.services.usuario.UsuarioBeanRemote;

public class ServiceUsuario {
	
	// Creamos un método privado que se utilizará sólo en esta clase para poder instanciar el bean y acceder a sus métodos
	private static UsuarioBeanRemote getService() {
		try {
			UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext
					.doLookup("ejb:/TrabajoColaborativoEJB/UsuarioBean!com.services.usuario.UsuarioBeanRemote");
			return usuarioBean;
		} catch (Exception e) {
			return null;
		}
	}

	// Declaramos métodos públicos que interactúan con el bean y devuelven una respuesta según el método al que se llame
	public static Usuario login(String nombreUsuario, String clave) {
		try {
			var usuarioBean = getService();
			return usuarioBean.login(nombreUsuario, clave);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static Usuario crearUsuario(Usuario oUsuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.crearUsuario(oUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	public static Usuario actualizarUsuario(Usuario oUsuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.actualizarUsuario(oUsuario);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean eliminarUsuario(Long idUsuario) {
		try {
			var usuarioBean = getService();
			return usuarioBean.eliminarUsuario(idUsuario);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Usuario> listarUsuarios() {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuarios();
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Usuario> listarUsuariosFiltro(String filtro) {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuariosFiltro(filtro);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean tienePermiso(Long idRol, Long idFuncionalidad) {
		try {
			var usuarioBean = getService();
			return usuarioBean.tienePermiso(idRol, idFuncionalidad);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Usuario> buscarUsuarioPorCampoYFiltro(String filtro, String campo) {
		try {
			var usuarioBean = getService();
			return usuarioBean.listarUsuariosFiltroPersonalizado(filtro, campo);
		} catch (Exception e) {
			return null;
		}
	}
}
