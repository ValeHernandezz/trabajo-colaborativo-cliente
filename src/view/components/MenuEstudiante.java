package view.components;

import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.entities.Usuario;

import context.Fabrica;

public class MenuEstudiante extends JPanel {

	private Fabrica fabrica = new Fabrica();
	private Usuario oPersona;

	/**
	 * Create the panel.
	 */
	public MenuEstudiante(MostrarPanel panel, Usuario oUsuario) {
		setLayout(null);

		JPanel panelMenuOperador = new JPanel();
		panelMenuOperador.setBounds(0, 0, 200, 550);
		panelMenuOperador.setBackground(Color.decode("#4bb4ca"));
		add(panelMenuOperador);
		panelMenuOperador.setLayout(null);

		JButton buttonCerrarSesion = new JButton("Cerrar Sesión");
		buttonCerrarSesion.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCerrarSesion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

                LoginPanel loginPanel = new LoginPanel(panel);
                loginPanel.setBounds(0, 0, 1028, 570);
                panel.mostrarPanelContent(loginPanel);
                panel.ocultarMenu();

			}
		});
		buttonCerrarSesion.setBounds(26, 500, 147, 21);
		panelMenuOperador.add(buttonCerrarSesion);

		JLabel labelMenuEstudiante = new JLabel("Estudiante");
		labelMenuEstudiante.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuEstudiante.setFont(new Font("Cambria", Font.BOLD, 25));
		labelMenuEstudiante.setBounds(-19, 25, 238, 44);
		panelMenuOperador.add(labelMenuEstudiante);

		JButton buttonFuncionalidades = new JButton("Funcionalidades");
		buttonFuncionalidades.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				FuncionalidadesPanel funcionalidadesPanel = new FuncionalidadesPanel(oUsuario);
				funcionalidadesPanel.setSize(798, 550);
				funcionalidadesPanel.setLocation(0, 0);
				panel.mostrarPanelContent(funcionalidadesPanel);

			}
		});
		buttonFuncionalidades.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonFuncionalidades.setBounds(26, 200, 147, 21);
		panelMenuOperador.add(buttonFuncionalidades);

		JLabel labelNombreCompleto = new JLabel(oUsuario.getNombreCompleto());
		labelNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreCompleto.setFont(new Font("Cambria", Font.PLAIN, 13));
		labelNombreCompleto.setBounds(10, 80, 180, 13);
		panelMenuOperador.add(labelNombreCompleto);

	}
}
