package view.helpers;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagenUtec extends JPanel {

	public ImagenUtec() {
		this.setSize(200, 300); // Se selecciona el tamaño del panel
	}

	// Se crea un método cuyo parámetro debe ser un objeto Graphics

	public void paint(Graphics grafico) {
		Dimension height = getSize();

		// Se selecciona la imagen que tenemos en el paquete de la ruta del programa

		ImageIcon Img = new ImageIcon(getClass().getResource("/view/img/Utec.png"));

		// Se dibuja la imagen que tenemos en el paquete Imagenes dentro de un panel

		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);

		setOpaque(false);
		super.paintComponent(grafico);
	}

}
