package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
import java.util.ArrayList;

public class CardinalVoters {
	private ArrayList <Cardinal>voters;

	public CardinalVoters() {
		voters= new ArrayList<Cardinal>();
	}

	public void fillArray(Cardinal objectCardinal) {
		voters.add(objectCardinal);

	}
	public ArrayList <Cardinal>getVoters() {
		return voters;
	}
}
