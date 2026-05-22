package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
public class CardinalProtodeacon {
	private int busy;
	private String protodeaconName;
	private String message;

	public CardinalProtodeacon() {
		busy=0;
		protodeaconName="";
		message="";
	}

	public String roleOccupied(int rol, String name) {
		busy=rol;
		if (busy==1) {
			message="Este rol ya esta ocupado, tu no eres el cardenal protodiácono";
		}
		else {
			protodeaconName=name;
			message="Es usted el cardenal protodiácono, es un honor";
		}
		return message;
	}

	public String announcementPapa(String winner) {
		message="Yo "+protodeaconName+ " como el Protodiácono anuncio: 'Habemus Papam' de nombre: "+ winner;
		return message;
	}
}
