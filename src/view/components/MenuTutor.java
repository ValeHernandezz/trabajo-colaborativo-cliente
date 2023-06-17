package view.components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.entities.Usuario;

import context.Fabrica;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuTutor extends JPanel {

	private JPanel panelMenuJefe;
	private JLabel labelMenuTutor;
	private JLabel labelNombreCompleto;
	private JButton buttonFuncionalidades;
	private JButton buttonCerrarSesion;

	/**
	 * Create the panel.
	 */
	public MenuTutor(MostrarPanel panel, Usuario oUsuario) {
		setLayout(null);

		panelMenuJefe = new JPanel();
		panelMenuJefe.setBounds(0, 0, 200, 550);
		panelMenuJefe.setBackground(Color.decode("#4bb4ca"));
		add(panelMenuJefe);
		panelMenuJefe.setLayout(null);

		labelMenuTutor = new JLabel("Tutor");
		labelMenuTutor.setFont(new Font("Cambria", Font.BOLD, 25));
		labelMenuTutor.setHorizontalAlignment(SwingConstants.CENTER);
		labelMenuTutor.setBounds(-17, 25, 234, 44);
		panelMenuJefe.add(labelMenuTutor);

		labelNombreCompleto = new JLabel(oUsuario.getNombreCompleto());
		labelNombreCompleto.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreCompleto.setFont(new Font("Cambria", Font.PLAIN, 13));
		labelNombreCompleto.setBounds(10, 80, 180, 13);
		panelMenuJefe.add(labelNombreCompleto);

		buttonFuncionalidades = new JButton("Funcionalidades");
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
		panelMenuJefe.add(buttonFuncionalidades);

		buttonCerrarSesion = new JButton("Cerrar Sesión");
		buttonCerrarSesion.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginPanel loginPanel = new LoginPanel(panel);
				loginPanel.setBounds(0, 0, 1028, 570);
				panel.mostrarPanelContent(loginPanel);
				panel.ocultarMenu();

			}
		});
		buttonCerrarSesion.setFont(new Font("Cambria", Font.PLAIN, 12));
		buttonCerrarSesion.setBounds(26, 500, 147, 21);
		panelMenuJefe.add(buttonCerrarSesion);

	}
}
