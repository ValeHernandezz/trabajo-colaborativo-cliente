package view.utils;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.entities.Funcionalidad;

public class TableModelFuncionalidad  implements TableModel {

	private ArrayList<Funcionalidad> listaDeFuncionalidades;

	public TableModelFuncionalidad(ArrayList<Funcionalidad> listaDeFuncionalidades) {
		this.listaDeFuncionalidades = listaDeFuncionalidades;
	}

	public int getRowCount() {
		return listaDeFuncionalidades.size();
	}

	public int getColumnCount() {
		return 2;
	}

	public String getColumnName(int columnIndex) {

		String nombreColumna = null;

		switch (columnIndex) {

		case 0:
			nombreColumna = "Nombre";
			break;

		case 1:
			nombreColumna = "Descripción";
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

		Funcionalidad oFuncionalidad = listaDeFuncionalidades.get(rowIndex);

		String valor = null;

		switch (columnIndex) {

		case 0:
			valor = oFuncionalidad.getNombre();
			break;

		case 1:
			valor = oFuncionalidad.getDescripcion();
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
