package co.edu.uptc.model;

public class CardinalDean {
	int busy;

	public CardinalDean() {
		busy=0;	
	}

	public String roleOccupied(int rol) {

		String message="";
		busy=rol;
		if (busy==1) {
			message="Este rol ya esta ocupado, tu no eres el cardenal Decano";
		}
		else {
			message="Es usted el cardenal Decano, es un honor";
		}
		return message;
	}
	
}

