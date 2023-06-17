package view.components;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.entities.Rol;
import com.entities.Usuario;

import context.Fabrica;
import services.ServiceRol;
import services.ServiceUsuario;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.helpers.Helper;
import view.utils.TableModelUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.border.EtchedBorder;

public class GestionDeUsuariosPanel extends JPanel {
	private JPanel panelPrincipal;
	private JLabel labelGestiónDeUsuarios;

	private JPanel panelBuscar;
	private JLabel labelBuscar;
	private JTextField textFieldBuscar;
	private JComboBox comboBoxFiltroBuscar;
	private JButton buttonBuscar;
	private JButton buttonLimpiarBusqueda;

	private JPanel panelDatos;
	private JLabel labelDocumento;
	private JLabel labelNombres;
	private JLabel labelApellidos;
	private JLabel labelRol;
	private JLabel labelMail;
	private JLabel labelClave;
	private JTextField textFieldDocumento;
	private JTextField textFieldNombres;
	private JTextField textFieldApellidos;
	private JComboBox comboBoxRol;
	private JTextField textFieldMail;
	private JPasswordField passwordFieldClave;
	private JButton buttonRegistrar;
	private JButton buttonModificar;
	private JButton buttonEliminar;
	private JButton buttonLimpiarCampos;

	private JButton buttonMostrarLista;
	private JButton buttonLimpiarTabla;

	private JScrollPane scrollPaneTabla;
	private JTable tablaUsuarios;

	private Fabrica fabrica = new Fabrica();
	private Long idUsuario = null;

	/**
	 * Create the panel.
	 */
	public GestionDeUsuariosPanel() {

		setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.decode("#9ED7E2"));
		panelPrincipal.setBounds(0, 0, 798, 550);
		add(panelPrincipal);
		panelPrincipal.setLayout(null);

		labelGestiónDeUsuarios = new JLabel("Gestión de Usuarios");
		labelGestiónDeUsuarios.setBounds(156, 16, 486, 36);
		labelGestiónDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		labelGestiónDeUsuarios.setFont(new Font("Cambria", Font.BOLD, 40));
		panelPrincipal.add(labelGestiónDeUsuarios);

		panelBuscar = new JPanel();
		panelBuscar.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelBuscar.setBounds(36, 68, 725, 56);
		panelBuscar.setBackground(new Color(124, 200, 216));
		panelPrincipal.add(panelBuscar);
		panelBuscar.setLayout(null);

		labelBuscar = new JLabel("Buscar");
		labelBuscar.setFont(new Font("Cambria", Font.BOLD, 15));
		labelBuscar.setBounds(35, 21, 67, 13);
		panelBuscar.add(labelBuscar);

		textFieldBuscar = new JTextField();
		textFieldBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldBuscar.setBounds(107, 18, 145, 19);
		panelBuscar.add(textFieldBuscar);
		textFieldBuscar.setColumns(10);

		comboBoxFiltroBuscar = new JComboBox();
		comboBoxFiltroBuscar.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione un filtro", "Nombres", "Apellidos", "Documento", "Rol" }));
		comboBoxFiltroBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));
		comboBoxFiltroBuscar.setBounds(273, 17, 134, 21);
		panelBuscar.add(comboBoxFiltroBuscar);

		buttonBuscar = new JButton("Buscar");
		buttonBuscar.setBounds(432, 17, 85, 21);
		panelBuscar.add(buttonBuscar);
		buttonBuscar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				String filtro = textFieldBuscar.getText();
				
				// Comprueba que el textField no esté vacío
				if (filtro.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Debe ingresar una palabra para buscar");
					return;
				}
				
				String campo = comboBoxFiltroBuscar.getSelectedItem().toString();

				// Busca mediante la Fábrica lo que escribimos en el textField y según el campo seleccionado
				ArrayList<Usuario> listaDeUsuarios = Fabrica.buscarUsuarioPorCampoYFiltro(filtro.trim(), campo);

				if (listaDeUsuarios != null) {

					// Si el tamaño de la lista es 0 es porque no existe una persona
					if (listaDeUsuarios.size() == 0) {
						JOptionPane.showMessageDialog(null, "No existe una persona con ese " + campo);
						return;
					}

					// Si la lista tiene registros, va a setearlos en la tabla de usuarios mediante un TableModel creado para listar usuarios en la tabla
					TableModelUsuario oModel = new TableModelUsuario(listaDeUsuarios);
					tablaUsuarios.setModel(oModel);
					textFieldBuscar.setText(null);
					comboBoxFiltroBuscar.setSelectedIndex(0);

				} else {
					JOptionPane.showMessageDialog(null, "No existe una persona con ese " + campo);
					return;
				}
			}
		});
		buttonBuscar.setFont(new Font("Cambria", Font.PLAIN, 13));

		buttonLimpiarBusqueda = new JButton("Limpiar Búsqueda");
		buttonLimpiarBusqueda.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				textFieldBuscar.setText(null);
				comboBoxFiltroBuscar.setSelectedIndex(0);

			}
		});
		buttonLimpiarBusqueda.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarBusqueda.setBounds(540, 17, 140, 21);
		panelBuscar.add(buttonLimpiarBusqueda);

		panelDatos = new JPanel();
		panelDatos.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panelDatos.setBounds(36, 140, 725, 207);
		panelDatos.setBackground(new Color(124, 200, 216));
		panelPrincipal.add(panelDatos);
		panelDatos.setLayout(null);

		labelDocumento = new JLabel("Documento");
		labelDocumento.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelDocumento.setBounds(77, 33, 94, 13);
		panelDatos.add(labelDocumento);

		labelNombres = new JLabel("Nombres");
		labelNombres.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelNombres.setBounds(77, 70, 94, 13);
		panelDatos.add(labelNombres);

		labelApellidos = new JLabel("Apellidos");
		labelApellidos.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelApellidos.setBounds(77, 101, 94, 25);
		panelDatos.add(labelApellidos);

		labelRol = new JLabel("Rol");
		labelRol.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelRol.setBounds(398, 33, 94, 13);
		panelDatos.add(labelRol);

		labelMail = new JLabel("Mail");
		labelMail.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelMail.setBounds(398, 70, 94, 13);
		panelDatos.add(labelMail);

		labelClave = new JLabel("Clave");
		labelClave.setFont(new Font("Cambria", Font.PLAIN, 15));
		labelClave.setBounds(398, 107, 94, 13);
		panelDatos.add(labelClave);

		textFieldDocumento = new JTextField();
		textFieldDocumento.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldDocumento.setBounds(225, 30, 96, 19);
		panelDatos.add(textFieldDocumento);
		textFieldDocumento.setColumns(10);

		textFieldNombres = new JTextField();
		textFieldNombres.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldNombres.setColumns(10);
		textFieldNombres.setBounds(225, 67, 96, 19);
		panelDatos.add(textFieldNombres);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(225, 104, 96, 19);
		panelDatos.add(textFieldApellidos);

		ArrayList<Rol> roles = ServiceRol.listarRoles();

		String[] rolesStrings = new String[roles.size() + 1];
		rolesStrings[0] = "Elige un rol";

		for (int i = 0; i < roles.size(); i++) {
			rolesStrings[i + 1] = roles.get(i).getNombre();
		}

		DefaultComboBoxModel<String> comboBoxModelRol = new DefaultComboBoxModel<>(rolesStrings);
		comboBoxRol = new JComboBox<>(comboBoxModelRol);
		comboBoxRol.setFont(new Font("Cambria", Font.PLAIN, 13));
		comboBoxRol.setBounds(490, 29, 151, 21);
		panelDatos.add(comboBoxRol);

		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Cambria", Font.PLAIN, 13));
		textFieldMail.setColumns(10);
		textFieldMail.setBounds(490, 67, 151, 19);
		panelDatos.add(textFieldMail);

		passwordFieldClave = new JPasswordField();
		passwordFieldClave.setFont(new Font("Cambria", Font.PLAIN, 13));
		passwordFieldClave.setColumns(10);
		passwordFieldClave.setBounds(490, 104, 151, 19);
		panelDatos.add(passwordFieldClave);

		buttonRegistrar = new JButton("Registrar");
		buttonRegistrar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				String documento = textFieldDocumento.getText();
				String nombres = textFieldNombres.getText();
				String apellidos = textFieldApellidos.getText();
				String nombreRol = comboBoxRol.getSelectedItem().toString();
				String mail = textFieldMail.getText();
				String clave = passwordFieldClave.getText();

				// Verifica que los campos no estén vacíos o con un largo menor al establecido
				if (documento.length() < 6 || nombres.length() < 3 || apellidos.length() < 3
						|| nombreRol.equals("Elige un rol") || mail.length() < 6 || clave.length() < 3) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos obligatorios", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

// ___________________________________________________________________________________________________________
//				Otra forma de verificar que el documento no exista en la base de datos.
//				var existeDocumento = Fabrica.buscarUsuarioPorCampoYFiltro(documento, "Documento");
//				if (existeDocumento.size() > 0) {
//					JOptionPane.showMessageDialog(null, "El documento que desea ingresar ya existe", "Error",
//				JOptionPane.ERROR_MESSAGE);
//					return;
//				}
// ___________________________________________________________________________________________________________

				// Verifica si existe ese documento ingresado en la base de datos, si existe no permite el registro
				boolean existeDocumento = Fabrica.existeElDocumento(documento);
				if (existeDocumento) {
					JOptionPane.showMessageDialog(null, "El documento que desea ingresar ya existe", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				Rol oRol = ServiceRol.listarRolesFiltro(nombreRol).get(0);

				String nombreUsuario = nombres + apellidos;

				Usuario oUsuarioACrear = new Usuario(apellidos, clave, documento, mail, nombres, nombreUsuario, oRol);

				try {
					// Creación del usuario a través del método del bean usuario, al cual se puede acceder a través de un service (ServiceUsuario)
					Usuario oUsuarioGuardado = ServiceUsuario.crearUsuario(oUsuarioACrear);

					// Si el oUsuarioGuardado se crea, limpia los campos y vuelve a listar los usuarios
					if (oUsuarioGuardado != null) {
						limpiarCampos();
						listarUsuarios();
						JOptionPane.showMessageDialog(null, "Guardado con éxito", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
					// Si el oUsuarioGuardado no se crea, lanza un cartel de error
					} else {
						JOptionPane.showMessageDialog(null, "No se pudo guardar", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Error en la Base de Datos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		buttonRegistrar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonRegistrar.setBounds(66, 166, 85, 21);
		panelDatos.add(buttonRegistrar);

		buttonModificar = new JButton("Editar");
		buttonModificar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// Para editar una persona debemos asegurarnos que tome los datos de ésta seleccionando una desde la tabla
				if (idUsuario == null) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una persona persona de la lista");
					return;
				}

				String documento = textFieldDocumento.getText();
				String nombre = textFieldNombres.getText();
				String apellido = textFieldApellidos.getText();
				String nombreDelRol = comboBoxModelRol.getSelectedItem().toString();
				String nombreUsuario = nombre + apellido;
				String mail = textFieldMail.getText();
				String clave = passwordFieldClave.getText();

				// Verifica que los campos no estén vacíos o con un largo menor al establecido
				if (documento.length() < 6 || nombre.length() < 3 || nombreDelRol.equals("Elige un rol")
						|| apellido.length() < 3 || mail.length() < 6) {
					JOptionPane.showMessageDialog(null, "Debe completar todos los campos obligatorios", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;

				}

				Rol oRol = ServiceRol.listarRolesFiltro(nombreDelRol).get(0);

				Usuario oUsuarioModificado = new Usuario(apellido, clave, documento, mail, nombre, nombreUsuario, oRol);
				oUsuarioModificado.setIdUsuario(idUsuario);

				// Cartel que pretende verificar si está seguro de realizar la actualización del usuario
				int deseaEliminarPersona = JOptionPane.showConfirmDialog(null,
						"¿Está seguro que desea editar este usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);

				// Si es igual a 0, es decir que la persona eligió "SÍ"
				if (deseaEliminarPersona == 0) {
					try {
						// Actualización del usuario a través del método del bean usuario, al cual se puede acceder a través de un service (ServiceUsuario)
						Usuario oUsuarioEditado = ServiceUsuario.actualizarUsuario(oUsuarioModificado);

						// Si el oUsuarioModificado se actualiza, limpia los campos y vuelve a listar los usuarios
						if (oUsuarioEditado != null) {
							limpiarCampos();
							listarUsuarios();
							JOptionPane.showMessageDialog(null, "Usuario editado con éxito", "Éxito",
									JOptionPane.INFORMATION_MESSAGE);

						// Si el oUsuarioModificado no se actualiza, lanza un cartel de error
						} else {
							JOptionPane.showMessageDialog(null, "Error al editar el usuario", "Error",
									JOptionPane.ERROR_MESSAGE);
						}

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Error en la Base de Datos", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				// Si es igual a 1, es decir que la persona eligió "NO"
				} else {
					return;
				}

			}
		});
		buttonModificar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonModificar.setBounds(217, 166, 85, 21);
		panelDatos.add(buttonModificar);

		buttonEliminar = new JButton("Eliminar");
		buttonEliminar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				// Para eliminar una persona debemos asegurarnos que tome los datos de ésta seleccionando una desde la tabla.
				if (idUsuario == null) {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario de la lista", "Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Cartel que pretende verificar si está seguro de realizar la eliminación del usuario
				int deseaEliminarPersona = JOptionPane.showConfirmDialog(null,
						"¿Está seguro que desea eliminar este usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);

				// Si es igual a 0, es decir que la persona eligió "SÍ"
				if (deseaEliminarPersona == 0) {

					// Eliminación del usuario a través del método del bean usuario, al cual se puede acceder a través de un service (ServiceUsuario)
					boolean respuesta = ServiceUsuario.eliminarUsuario(idUsuario);

					// Si la respuesta es true se elimina el usuario, limpia los campos y vuelve a listar los usuarios
					if (respuesta) {
						JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado con éxito", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						limpiarCampos();
						listarUsuarios();
						return;

					// Si la respuesta es false, lanza un cartel de error
					} else {
						JOptionPane.showMessageDialog(null, "No ha sido posible eliminar el usuario", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

				// Si es igual a 1, es decir que la persona eligió "NO"
				} else {
					return;
				}

			}
		});
		buttonEliminar.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonEliminar.setBounds(368, 166, 85, 21);
		panelDatos.add(buttonEliminar);

		buttonLimpiarCampos = new JButton("Limpiar Campos");
		buttonLimpiarCampos.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				limpiarCampos();
				textFieldDocumento.setText(null);

			}
		});
		buttonLimpiarCampos.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarCampos.setBounds(519, 166, 136, 21);
		panelDatos.add(buttonLimpiarCampos);

		buttonMostrarLista = new JButton("Mostrar Lista");
		buttonMostrarLista.setBounds(272, 363, 116, 21);
		panelPrincipal.add(buttonMostrarLista);
		buttonMostrarLista.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listarUsuarios();
			}
		});
		buttonMostrarLista.setFont(new Font("Cambria", Font.PLAIN, 13));

		buttonLimpiarTabla = new JButton("Limpiar Tabla");
		buttonLimpiarTabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				TableModelUsuario tableModelUsuario = new TableModelUsuario(new ArrayList<Usuario>());
				tablaUsuarios.setModel(tableModelUsuario);

			}
		});
		buttonLimpiarTabla.setFont(new Font("Cambria", Font.PLAIN, 13));
		buttonLimpiarTabla.setBounds(408, 363, 128, 21);
		panelPrincipal.add(buttonLimpiarTabla);

		scrollPaneTabla = new JScrollPane();
		scrollPaneTabla.setBounds(36, 400, 725, 129);
		panelPrincipal.add(scrollPaneTabla);

		tablaUsuarios = new JTable();
		tablaUsuarios.addMouseListener(new MouseAdapter() {
			@Override
			// Método para obtener los datos de un usuario dando click en su fila de la tabla y se setean en los texfield y comboBox correspondientes
			public void mouseClicked(MouseEvent e) {
				int filaSeleccionada = tablaUsuarios.getSelectedRow();
				if (filaSeleccionada != -1) {
					String documento = (String) tablaUsuarios.getValueAt(filaSeleccionada, 0);
					String nombre = (String) tablaUsuarios.getValueAt(filaSeleccionada, 1);
					String apellido = (String) tablaUsuarios.getValueAt(filaSeleccionada, 2);
					String rol = (String) tablaUsuarios.getValueAt(filaSeleccionada, 3);
					String mail = (String) tablaUsuarios.getValueAt(filaSeleccionada, 4);
					idUsuario = ServiceUsuario.listarUsuariosFiltro(nombre).get(0).getIdUsuario();

					textFieldDocumento.setText(documento);
					textFieldDocumento.setEnabled(false);
					textFieldNombres.setText(nombre);
					textFieldApellidos.setText(apellido);
					comboBoxModelRol.setSelectedItem(rol);
					textFieldMail.setText(mail);
				}
			}
		});
		tablaUsuarios.setFont(new Font("Cambria", Font.PLAIN, 13));
		tablaUsuarios.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Documento", "Nombre", "Apellido", "Rol", "Mail" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPaneTabla.setViewportView(tablaUsuarios);

	}

	// Método para limpiar los campos del panelDatos
	public void limpiarCampos() {

		textFieldNombres.setText(null);
		textFieldApellidos.setText(null);
		comboBoxRol.setSelectedIndex(0);
		textFieldMail.setText(null);
		passwordFieldClave.setText(null);
		textFieldDocumento.setEditable(true);
		passwordFieldClave.setEditable(true);
		textFieldDocumento.setText(null);
		textFieldDocumento.setEnabled(true);
		idUsuario = null;

	}

	// Método para limpiar los campos del panelBuscar
	public void limpiarCamposDeBusqueda() {
		textFieldBuscar.setText(null);
		comboBoxFiltroBuscar.setSelectedIndex(0);
	}

	// Método para listar los usuarios obtenidos del método del bean usuario y colocarlos en el TableModel creado específicamente para los datos de Usuario
	public void listarUsuarios() {
		TableModelUsuario oModel = new TableModelUsuario(ServiceUsuario.listarUsuarios());
		tablaUsuarios.setModel(oModel);
	}
}
