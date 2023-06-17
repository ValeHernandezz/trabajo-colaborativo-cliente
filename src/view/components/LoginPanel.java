package view.components;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import com.entities.Usuario;

import context.Fabrica;
import services.ServiceUsuario;
import view.helpers.ImagenLogoApp;
import view.helpers.ImagenTextura;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class LoginPanel extends JPanel {

	private JPanel panelLogin;

	private JPanel panelDatos;
	private JPanel panelLogoTipo;
	private JLabel labelIniciarSesion;
	private JLabel labelNombreUsuario;
	private JTextField textFieldMail;
	private JLabel labelClave;
	private JPasswordField passwordFieldClave;
	private JButton buttonIngresar;

	private ImagenTextura imagenTextura;
	private ImagenLogoApp imagenApp;
	private Fabrica oFabrica = new Fabrica();
	private BienvenidoPanel panelBienvenido;
	private MenuAnalista menuAdministrador;
	private MenuEstudiante menuOperador;
	private MenuTutor menuJefe;

	/**
	 * Create the panel.
	 */
	public LoginPanel(MostrarPanel panel) {
		setLayout(null);

		panelLogin = new JPanel();
		panelLogin.setBackground(Color.decode("#d8d8d8"));
		panelLogin.setBounds(0, 0, 1028, 570);
		add(panelLogin);
		panelLogin.setLayout(null);

		panelDatos = new JPanel();
		panelDatos.setBackground(Color.decode("#4bb4ca"));
		panelDatos.setBounds(322, 0, 384, 570);
		panelLogin.add(panelDatos);
		panelDatos.setLayout(null);

		panelLogoTipo = new JPanel();
		panelLogoTipo.setBounds(132, 82, 120, 120);
		panelLogoTipo.setOpaque(false); // Establecer el panel como transparente
		panelDatos.add(panelLogoTipo);
		panelLogoTipo.setLayout(null);

		imagenApp = new ImagenLogoApp();
		imagenApp.setBounds(0, 0, 120, 120);
		panelLogoTipo.add(imagenApp);

		labelIniciarSesion = new JLabel("Iniciar Sesión");
		labelIniciarSesion.setBounds(67, 212, 250, 47);
		panelDatos.add(labelIniciarSesion);
		labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		labelIniciarSesion.setFont(new Font("Cambria", Font.BOLD, 40));

		labelNombreUsuario = new JLabel("Nombre de Usuario");
		labelNombreUsuario.setBounds(114, 288, 156, 13);
		panelDatos.add(labelNombreUsuario);
		labelNombreUsuario.setFont(new Font("Cambria", Font.PLAIN, 15));

		textFieldMail = new JTextField();
		textFieldMail.setBounds(114, 318, 156, 19);
		panelDatos.add(textFieldMail);
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);

		labelClave = new JLabel("Contraseña");
		labelClave.setBounds(114, 358, 74, 19);
		panelDatos.add(labelClave);
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setBounds(114, 388, 156, 19);
		panelDatos.add(passwordFieldClave);
		passwordFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));

		buttonIngresar = new JButton("Ingresar");
		buttonIngresar.setBounds(144, 443, 95, 25);
		panelDatos.add(buttonIngresar);
		buttonIngresar.setFont(new Font("Cambria", Font.PLAIN, 15));
		buttonIngresar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String nombreUsuario = textFieldMail.getText();
				String clave = passwordFieldClave.getText();

				// Validación en caso de que el nombre de usuario y la clave sean menores a las establecidas
				if (nombreUsuario.length() < 4 || clave.length() < 3) {
					JOptionPane.showMessageDialog(null, "Campos incompletos", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					Usuario existeUsuario = ServiceUsuario.login(nombreUsuario, clave);

					// Validación en caso de que el nombre de usuario o contraseña sean incorrectos
					if (existeUsuario == null) {
						JOptionPane.showMessageDialog(null,	"El nombre de usuario o la contraseña ingresados son incorrectos. \nPor favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}

					panelBienvenido = new BienvenidoPanel();
					panelBienvenido.setSize(798, 550);
					panelBienvenido.setLocation(0, 0);
					panel.mostrarPanelContent(panelBienvenido);

					panel.mostrarMenu();
					
					// Si el nombre del rol del usuario ingresado es igual a "Analista" va a mostrar el menú asociado al Analista.
					if (existeUsuario.getRol().getNombre().equals("Analista")) {
						MenuAnalista menuAnalista = new MenuAnalista(panel, existeUsuario);
						menuAnalista.setSize(200, 550);
						menuAnalista.setLocation(0, 0);
						panel.mostrarPanelMenu(menuAnalista);
						return;
					}
					
					// Si el nombre del rol del usuario ingresado es igual a "Tutor" va a mostrar el menú asociado al Tutor.
					if (existeUsuario.getRol().getNombre().equals("Tutor")) {
						MenuTutor menuTutor = new MenuTutor(panel, existeUsuario);
						menuTutor.setSize(200, 550);
						menuTutor.setLocation(0, 0);
						panel.mostrarPanelMenu(menuTutor);
						return;
					}
					
					// Si el nombre del rol del usuario ingresado es igual a "Estudiante" va a mostrar el menú asociado al Estudiante.
					if (existeUsuario.getRol().getNombre().equals("Estudiante")) {
						MenuEstudiante menuEstudiante = new MenuEstudiante(panel, existeUsuario);
						menuEstudiante.setSize(200, 550);
						menuEstudiante.setLocation(0, 0);
						panel.mostrarPanelMenu(menuEstudiante);
						return;
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error en el sistema");
				}
			}
		});

		imagenTextura = new ImagenTextura();
		imagenTextura.setBounds(0, 0, 1200, 1200);
		panelLogin.add(imagenTextura);

	}
}
