package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodriguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
import java.util.Random;

public class CardinalScrutiners {
	private int code;
	private Random random;

	public CardinalScrutiners() {
		random=new Random();
		code=0;
	}

	public int generateAccess() {
		code=random.nextInt(9000)+1000;
		return code;
	}

	public boolean confirmAccess(int inputPin) {
		boolean access=false;
		if(inputPin==code) {
			access=true;
		}
		else {
			access=false;
		}
		return access; 
	}
}
