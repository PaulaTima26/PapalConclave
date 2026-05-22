package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
public class CardinalProtodeacon extends Cardinal{
	private int busy;
	private String message;

	public CardinalProtodeacon(String name, int age, String range) {
		super(name,age,range);
		busy=0;
		message="";
	}

	public String roleOccupied(int rol) {
		busy=rol;
		if (busy==1) {
			message="Este rol ya esta ocupado, tu no eres el cardenal protodiácono";
		}
		else {
			message="Cardenal "+name + " es usted el cardenal protodiácono, es un honor";
		}
		return message;
	}

	public String announcementPapa(String winner) {
		message="Yo "+name+ " como el Protodiácono anuncio: 'Habemus Papam' de nombre: "+ winner;
		return message;
	}
}
