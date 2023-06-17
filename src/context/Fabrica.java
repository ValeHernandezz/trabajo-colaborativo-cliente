package context;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.entities.Usuario;

import services.ServiceRol;
import services.ServiceUsuario;

public class Fabrica {

	private static Map<String, String> diccionarioCampo = new HashMap<>();
	private static ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

	public static ArrayList<Usuario> getListaDeUsuarios() {
		return listaDeUsuarios;
	}

	public static void setListaDeUsuarios(ArrayList<Usuario> listaDeUsuarios) {
		Fabrica.listaDeUsuarios = listaDeUsuarios;
	}

	private static void cargarDiccionario() {
		diccionarioCampo.put("Nombres", "UPPER(u.nombre)");
		diccionarioCampo.put("Apellidos", "UPPER(u.apellido)");
		diccionarioCampo.put("Documento", "u.documento");
	}

	public static ArrayList<Usuario> buscarUsuarioPorCampoYFiltro(String filtro, String campo) {
		cargarDiccionario();
		try {
			String valor = diccionarioCampo.get(campo);
			if (campo.equals("Rol")) {
				return buscarUsuarioPorRol(filtro);
			}
			return ServiceUsuario.buscarUsuarioPorCampoYFiltro(filtro, valor);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean existeElDocumento(String documento) {
		cargarListaUsuarios();
		boolean respuesta = false;
		for (Usuario u : listaDeUsuarios) {
			if (u.getDocumento().equals(documento)) {
				respuesta = true;
				break;
			}
		}

		return respuesta;

	}

	public static void cargarListaUsuarios() {
		setListaDeUsuarios(ServiceUsuario.listarUsuarios());
	}
	
	public static ArrayList<Usuario> buscarUsuarioPorRol(String rol){
		ArrayList<Usuario> listaDeRespuesta = new ArrayList<Usuario>();
		
		for(Usuario usuario : ServiceUsuario.listarUsuarios()) {
			if(usuario.getRol().getNombre().toUpperCase().contains(rol.toUpperCase())) {
				listaDeRespuesta.add(usuario);
			}
		}
		return listaDeRespuesta;
	}

}
