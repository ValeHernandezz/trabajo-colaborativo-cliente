package services;

import java.util.ArrayList;

import javax.naming.InitialContext;

import com.entities.Funcionalidad;
import com.entities.Rol;
import com.services.rol.RolBeanRemote;

public class ServiceRol {

	// Creamos un método privado que se utilizará sólo en esta clase para poder instanciar el bean y acceder a sus métodos
	private static RolBeanRemote getService() {
		try {
			RolBeanRemote rolBean = (RolBeanRemote) InitialContext
					.doLookup("ejb:/TrabajoColaborativoEJB/RolBean!com.services.rol.RolBeanRemote");
			return rolBean;
		} catch (Exception e) {
			return null;
		}
	}

	// Declaramos métodos públicos que interactúan con el bean y devuelven una respuesta según el método al que se llame
	public static Rol crearRol(Rol oRol) {
		try {
			var rolBean = getService();
			return rolBean.crearRol(oRol);
		} catch (Exception e) {
			return null;
		}
	}

	public static Rol actualizarRol(Rol oRol) {
		try {
			var rolBean = getService();
			return rolBean.actualizarRol(oRol);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean eliminarRol(Long idRol) {
		try {
			var rolBean = getService();
			return rolBean.eliminarRol(idRol);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Rol> listarRoles() {
		try {
			var rolBean = getService();
			return rolBean.listarRoles();
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Rol> listarRolesFiltro(String filtro) {
		try {
			var rolBean = getService();
			return rolBean.listarRolesFiltro(filtro);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean asignarFuncionalidadAUnRol(Rol oRol, Funcionalidad oFuncionalidad) {
		try {
			var rolBean = getService();
			return rolBean.asignarFuncionalidadAUnRol(oRol, oFuncionalidad);
		} catch (Exception e) {
			return false;
		}
	}
}
