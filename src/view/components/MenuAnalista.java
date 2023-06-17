package view.components;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.entities.Usuario;

import context.Fabrica;

import java.awt.Color;

public class MenuAnalista extends JPanel {
	private JPanel panelMenuAdministrador;
	private JLabel labelMenuAnalista;
	private JLabel labelNombreCompleto;
	private JButton buttonFuncionalidades;
	private JButton buttonGestionDeUsuarios;
	private JButton buttonCerrarSesión;

	/**
	 * Create the panel.
	 */
	public MenuAnalista(MostrarPanel panel, Usuario oUsuario) {
		setLayout(null);

		panelMenuAdministrador = new JPanel();
		panelMenuAdministrador.setBackground(Color.decode("#4bb4ca"));
		panelMenuAdministrador.setBounds(0, 0, 200, 550);
		add(panelMenuAdministrador);
		panelMenuAdministrador.setLayout(null);

		labelMenuAnalista = new JLabel("Analista");
		labelMenuAnalista.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuAnalista.setFont(new Font("Cambria", Font.BOLD, 25));
		labelMenuAnalista.setBounds(-19, 25, 238, 44);
		panelMenuAdministrador.add(labelMenuAnalista);

		labelNombreCompleto = new JLabel(oUsuario.getNombreCompleto());
		labelNombreCompleto.setFont(new Font("Cambria", Font.PLAIN, 13));
		labelNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreCompleto.setBounds(10, 80, 180, 13);
		panelMenuAdministrador.add(labelNombreCompleto);

		buttonFuncionalidades = new JButton("Funcionalidades");
		buttonFuncionalidades.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonFuncionalidades.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// Se instancia el panel que se muestra al hacer click en el botón "Funcionalidades"
				FuncionalidadesPanel funcionalidadesPanel = new FuncionalidadesPanel(oUsuario);
				
				// Se le da el tamaño que corresponde en el panel padre y sus coordenadas para que quede alineado
				funcionalidadesPanel.setSize(798, 550);
				funcionalidadesPanel.setLocation(0, 0);
				
				// Llamamos al panel padre y utilizamos el método para mostrarlo
				panel.mostrarPanelContent(funcionalidadesPanel);

			}
		});
		buttonFuncionalidades.setBounds(26, 200, 147, 21);
		panelMenuAdministrador.add(buttonFuncionalidades);

		buttonGestionDeUsuarios = new JButton("Gestión de Usuarios");
		buttonGestionDeUsuarios.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				GestionDeUsuariosPanel gestionarPersonalPanel = new GestionDeUsuariosPanel();
				gestionarPersonalPanel.setSize(798, 550);
				gestionarPersonalPanel.setLocation(0, 0);
				panel.mostrarPanelContent(gestionarPersonalPanel);

			}
		});
		buttonGestionDeUsuarios.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonGestionDeUsuarios.setBounds(26, 250, 147, 21);
		panelMenuAdministrador.add(buttonGestionDeUsuarios);

		buttonCerrarSesión = new JButton("Cerrar Sesión");
		buttonCerrarSesión.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCerrarSesión.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				LoginPanel loginPanel = new LoginPanel(panel);
				loginPanel.setBounds(0, 0, 1028, 570);
				panel.mostrarPanelContent(loginPanel);
				panel.ocultarMenu();

			}
		});
		buttonCerrarSesión.setBounds(26, 500, 147, 21);
		panelMenuAdministrador.add(buttonCerrarSesión);

	}
}
