package view.components;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.entities.Funcionalidad;
import com.entities.Usuario;

import services.ServiceFuncionalidad;
import services.ServiceUsuario;
import view.utils.TableModelFuncionalidad;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FuncionalidadesPanel extends JPanel {

	private JPanel panelPrincipal;
	private JLabel labelFuncionalidades;
	private JLabel lblListaDeFuncionalidades;
	private JLabel lblSeleccionaUnaOpcion;
	private JComboBox comboBoxFuncionalidades;
	private JTable tableFuncionalidades;
	private JScrollPane scrollPaneTablaFuncionalidades;
	private JLabel lblSeleccioneUnaFuncionalidad;
	private JLabel lblPermisoDeAcceso;

	private Long idRol = null;

	/**
	 * Create the panel.
	 */
	public FuncionalidadesPanel(Usuario oUsuario) {
		setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.decode("#9ED7E2"));
		panelPrincipal.setBounds(0, 0, 798, 550);
		add(panelPrincipal);
		panelPrincipal.setLayout(null);

		labelFuncionalidades = new JLabel("Funcionalidades");
		labelFuncionalidades.setHorizontalAlignment(SwingConstants.CENTER);
		labelFuncionalidades.setFont(new Font("Cambria", Font.BOLD, 40));
		labelFuncionalidades.setBounds(156, 17, 486, 36);
		panelPrincipal.add(labelFuncionalidades);

		lblListaDeFuncionalidades = new JLabel("Lista de Funcionalidades");
		lblListaDeFuncionalidades.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaDeFuncionalidades.setFont(new Font("Cambria", Font.BOLD, 20));
		lblListaDeFuncionalidades.setBounds(156, 70, 486, 36);
		panelPrincipal.add(lblListaDeFuncionalidades);
		
		lblSeleccionaUnaOpcion = new JLabel("Seleccione las funcionalidades que desea listar");
		lblSeleccionaUnaOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaUnaOpcion.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblSeleccionaUnaOpcion.setBounds(105, 123, 588, 18);
		panelPrincipal.add(lblSeleccionaUnaOpcion);

		comboBoxFuncionalidades = new JComboBox();
		comboBoxFuncionalidades.setFont(new Font("Cambria", Font.PLAIN, 15));
		comboBoxFuncionalidades.setModel(new DefaultComboBoxModel(new String[] {"Tiene acceso", "No tiene acceso", "Todas"}));
		comboBoxFuncionalidades.setBounds(340, 158, 117, 21);
		comboBoxFuncionalidades.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Object itemSeleccionado = e.getItem();
					
					lblSeleccioneUnaFuncionalidad.setVisible(false);
					lblPermisoDeAcceso.setVisible(false);
					
					ArrayList<Funcionalidad> listaFuncionalidadesConAcceso;
					ArrayList<Funcionalidad> listafuncionalidadesSinAcceso;
					TableModelFuncionalidad oModel;
					
					// Si se selecciona el ítem "Tiene acceso" sólo se van a listar las funcionalidades a las que tiene acceso el usuario mediante su rol
					if (itemSeleccionado.equals("Tiene acceso")) {
						idRol = oUsuario.getRol().getIdRol();
						listaFuncionalidadesConAcceso = ServiceFuncionalidad.listarFuncionalidadesPorRol(idRol);
						oModel = new TableModelFuncionalidad(listaFuncionalidadesConAcceso);
						tableFuncionalidades.setModel(oModel);
					
					// Si se selecciona el ítem "No tiene acceso" sólo se van a listar las funcionalidades a las que NO tiene acceso el usuario mediante su rol
					} else if (itemSeleccionado.equals("No tiene acceso")) {
						idRol = oUsuario.getRol().getIdRol();
						listafuncionalidadesSinAcceso = ServiceFuncionalidad.listarFuncionalidadesSinAccesoPorRol(idRol);
						oModel = new TableModelFuncionalidad(listafuncionalidadesSinAcceso);
						tableFuncionalidades.setModel(oModel);
					
					// Si se selecciona el ítem "Todas" se van a listar todas las funcionalidades independientemente del rol
					} else if (itemSeleccionado.equals("Todas")) {

						listarFuncionalidades();
						lblSeleccioneUnaFuncionalidad.setVisible(true);
						lblPermisoDeAcceso.setVisible(true);

						tableFuncionalidades.addMouseListener(new MouseAdapter() {
							// Método para que al hacer click en una fila de la tabla, sepamos si el rol tiene acceso a una u otra funcionalidad
							public void mouseClicked(MouseEvent e) {

								int filaSeleccionada = tableFuncionalidades.getSelectedRow();
								if (filaSeleccionada != -1) {

									String nombre = (String) tableFuncionalidades.getValueAt(filaSeleccionada, 0);

									Long idRol = oUsuario.getRol().getIdRol();
									Long idFuncionalidad = ServiceFuncionalidad.listarFuncionalidadesFiltro(nombre).get(0).getIdFuncionalidad();

									// Método que a partir del idRol e idFuncionalidad permite saber si esa funcionalidad pertenece a ese rol o no
									boolean tienePermiso = ServiceUsuario.tienePermiso(idRol, idFuncionalidad);

									// Si el usuario (debido a su rol) tiene acceso a la funcionalidad, el texto del label cambiará y también su color, a verde
									if (tienePermiso) {
										lblPermisoDeAcceso.setText("Tiene acceso");
										lblPermisoDeAcceso.setForeground(Color.decode("#008F39"));
										return;
										
									// Si el usuario (debido a su rol) no tiene acceso a la funcionalidad, el texto del label cambiará y también su color, a rojo
									} else {
										lblPermisoDeAcceso.setText("No tiene acceso");
										lblPermisoDeAcceso.setForeground(Color.RED);
										return;
									}
								}
							}
						});
					}
				}

			}
		});
		panelPrincipal.add(comboBoxFuncionalidades);

		scrollPaneTablaFuncionalidades = new JScrollPane();
		scrollPaneTablaFuncionalidades.setBounds(105, 196, 588, 266);
		panelPrincipal.add(scrollPaneTablaFuncionalidades);

		tableFuncionalidades = new JTable();
		tableFuncionalidades.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre", "Descripci\u00F3n" }));
		scrollPaneTablaFuncionalidades.setViewportView(tableFuncionalidades);

		lblSeleccioneUnaFuncionalidad = new JLabel("Seleccione una funcionalidad de la lista y sabrá si tiene acceso o no a ella");
		lblSeleccioneUnaFuncionalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUnaFuncionalidad.setFont(new Font("Cambria", Font.PLAIN, 18));
		lblSeleccioneUnaFuncionalidad.setBounds(105, 479, 588, 18);
		lblSeleccioneUnaFuncionalidad.setVisible(false);
		panelPrincipal.add(lblSeleccioneUnaFuncionalidad);

		lblPermisoDeAcceso = new JLabel("");
		lblPermisoDeAcceso.setLabelFor(this);
		lblPermisoDeAcceso.setFont(new Font("Cambria", Font.BOLD, 18));
		lblPermisoDeAcceso.setHorizontalAlignment(SwingConstants.CENTER);
		lblPermisoDeAcceso.setBounds(48, 514, 701, 18);
		panelPrincipal.add(lblPermisoDeAcceso);
		
		// Si el usuario no es nulo, listamos las funcionalidades a las que tiene acceso
		if(oUsuario != null) {
			tableFuncionalidades.setModel(new TableModelFuncionalidad(ServiceFuncionalidad.listarFuncionalidadesPorRol(oUsuario.getRol().getIdRol())));
		}

	}

	// Método para listar todas las funcionalidades que hay en la Base de Datos y setearlas en un TableModel creado específicamente para los datos de usuario
	public void listarFuncionalidades() {
		TableModelFuncionalidad oModel = new TableModelFuncionalidad(ServiceFuncionalidad.listarFuncionalidades());
		tableFuncionalidades.setModel(oModel);
	}

}
