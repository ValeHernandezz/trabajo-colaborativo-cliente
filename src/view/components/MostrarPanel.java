package view.components;

import javax.swing.JPanel;

public interface MostrarPanel {

	// Aquí declararemos los métodos que nos ayudan a poder interactuar entre los paneles

	void mostrarPanelMenu(JPanel panel);

	void mostrarPanelContent(JPanel panel);

	void mostrarMenu();

	void ocultarMenu();

}
