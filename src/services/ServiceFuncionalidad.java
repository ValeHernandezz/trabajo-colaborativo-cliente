package services;

import java.util.ArrayList;

import javax.naming.InitialContext;

import com.entities.Funcionalidad;
import com.services.funcionalidad.FuncionalidadBeanRemote;

public class ServiceFuncionalidad {

	// Creamos un método privado que se utilizará sólo en esta clase para poder instanciar el bean y acceder a sus métodos
	private static FuncionalidadBeanRemote getService() {
		try {
			FuncionalidadBeanRemote funcionaldadBean = (FuncionalidadBeanRemote) InitialContext.doLookup(
					"ejb:/TrabajoColaborativoEJB/FuncionalidadBean!com.services.funcionalidad.FuncionalidadBeanRemote");
			return funcionaldadBean;
		} catch (Exception e) {
			return null;
		}
	}

	// Declaramos métodos públicos que interactúan con el bean y devuelven una respuesta según el método al que se llame
	public static Funcionalidad crearFuncionalidad(Funcionalidad oFuncionalidad) {
		try {
			var funcionalidadBean = getService();
			return funcionalidadBean.crearFuncionalidad(oFuncionalidad);
		} catch (Exception e) {
			return null;
		}
	}

	public static Funcionalidad actualizarFuncionalidad(Funcionalidad oFuncionalidad) {
		try {
			var funcionalidadBean = getService();
			return funcionalidadBean.actualizarFuncionalidad(oFuncionalidad);
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean eliminarFuncionalidad(Long idFuncionalidad) {
		try {
			var funcionalidadBean = getService();
			return funcionalidadBean.eliminarFuncionalidad(idFuncionalidad);
		} catch (Exception e) {
			return false;
		}
	}

	public static ArrayList<Funcionalidad> listarFuncionalidades() {
		try {
			var funcionalidadBean = getService();
			return funcionalidadBean.listarFuncionalidades();
		} catch (Exception e) {
			return null;
		}
	}

	public static ArrayList<Funcionalidad> listarFuncionalidadesFiltro(String filtro) {
		try {
			var funcionalidadBean = getService();
			return funcionalidadBean.listarFuncionalidadesFiltro(filtro);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static ArrayList<Funcionalidad> listarFuncionalidadesPorRol(Long idRol){
		try {
			var funcionalidadBean = getService();
			return funcionalidadBean.listarFuncionalidadesPorRol(idRol);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static ArrayList<Funcionalidad> listarFuncionalidadesSinAccesoPorRol(Long idRol){
		try {
			var funcionalidadBean = getService();
			return funcionalidadBean.listarFuncionalidadesSinAccesoPorRol(idRol);
		} catch (Exception e) {
			return null;
		}
	}
}
