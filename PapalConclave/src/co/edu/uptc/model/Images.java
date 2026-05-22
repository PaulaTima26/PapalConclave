package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
import javax.swing.ImageIcon;

public class Images {
	private ImageIcon habemusPapaIcon;
	private ImageIcon cardinalsIcon;
	private ImageIcon urnaIcon;
	private ImageIcon noPapaIcon;
	private ImageIcon genericError;
	private ImageIcon vote;
	private ImageIcon cardenalInformation;

	public Images() {
		cardinalsIcon =new ImageIcon(getClass().getResource("/Icons/cardenales.png"));
		habemusPapaIcon =new ImageIcon(getClass().getResource("/Icons/habemus papa.png"));
		urnaIcon = new ImageIcon(getClass().getResource("/Icons/urna.png"));
		noPapaIcon =new ImageIcon(getClass().getResource("/Icons/no hay papa.png"));
		genericError=new ImageIcon(getClass().getResource("/Icons/Error generico.png"));
		vote=new ImageIcon(getClass().getResource("/Icons/voto.png"));
		cardenalInformation=new ImageIcon(getClass().getResource("/Icons/CardenalInformación.png"));

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
	
	public ImageIcon getGenericError() {
		return genericError;
	}
	
	public ImageIcon getVote() {
		return vote;
	}
	public ImageIcon getCardenalInformation() {
		return cardenalInformation;
	}
	
}
