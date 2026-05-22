package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class Images {
	private ImageIcon habemusPapaIcon;
	private ImageIcon cardinalsIcon;
	private ImageIcon urnaIcon;
	private ImageIcon noPapaIcon;

	public Images() {
		cardinalsIcon =new ImageIcon(getClass().getResource("/Icons/cardenales.png"));
		habemusPapaIcon =new ImageIcon(getClass().getResource("/Icons/habemus papa.png"));
		urnaIcon = new ImageIcon(getClass().getResource("/Icons/urna.png"));
		noPapaIcon =new ImageIcon(getClass().getResource("/Icons/no hay papa.png"));
	}

	public ImageIcon getCardinalsIcon() {
		return cardinalsIcon;
	}

	public ImageIcon getHabemusPapaIcon() {
		return habemusPapaIcon;
	}

	public ImageIcon getUrnaIcon() {
		return urnaIcon;
	}

	public ImageIcon getNoPapaIcon() {
		return noPapaIcon;
	}
}
