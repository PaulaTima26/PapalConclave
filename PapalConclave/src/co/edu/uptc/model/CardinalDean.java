package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
public class CardinalDean extends Cardinal{
	private int busy;
	private String message;

	public CardinalDean(String name, int age, String range) {
		super(name,age,range);
		busy=0;	
		message="";
	}

	public String roleOccupied(int rol) {
		busy=rol;
		if (busy==1) {
			message="Este rol ya esta ocupado, tu no eres el cardenal Decano";
		}
		else {
			message="Cardenal "+name+" es usted el cardenal Decano, es un honor";
		}
		return message;
	}

	public String confirmPapa() {
		message="Yo "+name+ " como el Decano te pregunto, cardenal electo: ¿Acepta ser el Sumo Pontífice?";
		return message;
	}
}

