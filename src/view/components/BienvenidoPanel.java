package view.components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import view.helpers.ImagenLogoEquipo;
import view.helpers.ImagenUtec;

import java.awt.Color;

public class BienvenidoPanel extends JPanel {

	private JPanel panelBienvenido;
	private JLabel labelTitulo1;

	private JPanel panelImagenLogoEquipo;
	private ImagenLogoEquipo imagenLogoEquipo = new ImagenLogoEquipo();

	private JPanel panelImagenUtec;
	private ImagenUtec imagenUtec = new ImagenUtec();

	/**
	 * Create the panel.
	 */
	public BienvenidoPanel() {
		setLayout(null);

		panelBienvenido = new JPanel();
		panelBienvenido.setBackground(Color.decode("#9ED7E2"));
		panelBienvenido.setBounds(0, 0, 798, 550);
		add(panelBienvenido);
		panelBienvenido.setLayout(null);

		labelTitulo1 = new JLabel("Bienvenido");
		labelTitulo1.setBounds(196, 188, 405, 60);
		labelTitulo1.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo1.setFont(new Font("Cambria", Font.BOLD, 40));
		panelBienvenido.add(labelTitulo1);

		panelImagenLogoEquipo = new JPanel();
		panelImagenLogoEquipo.setBounds(446, 299, 115, 67);
		panelBienvenido.add(panelImagenLogoEquipo);
		panelImagenLogoEquipo.setLayout(null);

		imagenLogoEquipo.setBounds(0, 0, 115, 67);
		panelImagenLogoEquipo.add(imagenLogoEquipo);

		panelImagenUtec = new JPanel();
		panelImagenUtec.setBounds(231, 285, 115, 81);
		panelBienvenido.add(panelImagenUtec);
		panelImagenUtec.setLayout(null);

		imagenUtec.setBounds(0, 0, 115, 81);
		panelImagenUtec.add(imagenUtec);

	}
}
