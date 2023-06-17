package view.utils;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.entities.Usuario;

public class TableModelUsuario implements TableModel {

	private ArrayList<Usuario> listaDeUsuarios;

	public TableModelUsuario(ArrayList<Usuario> listaPersonas) {
		this.listaDeUsuarios = listaPersonas;
	}

	public int getRowCount() {
		return listaDeUsuarios.size();
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int columnIndex) {

		String nombreColumna = null;

		switch (columnIndex) {

		case 0:
			nombreColumna = "Documento";
			break;

		case 1:
			nombreColumna = "Nombre";
			break;

		case 2:
			nombreColumna = "Apellido";
			break;

		case 3:
			nombreColumna = "Rol";
			break;

		case 4:
			nombreColumna = "Mail";
			break;

		}

		return nombreColumna;

	}

	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		Usuario oUsuario = listaDeUsuarios.get(rowIndex);

		String valor = null;

		switch (columnIndex) {

		case 0:
			valor = oUsuario.getDocumento();
			break;

		case 1:
			valor = oUsuario.getNombre();
			break;

		case 2:
			valor = oUsuario.getApellido();
			break;

		// Acá hay que conseguir el rol mediante el service si es que no lo trae con
		// inner join
		case 3:
			valor = oUsuario.getRol().getNombre();
			break;

		case 4:
			valor = oUsuario.getMail();
			break;

		}

		return valor;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
	}

	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}