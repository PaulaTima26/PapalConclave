package co.edu.uptc.model;

public class CardinalDean {
	private int busy;
	private String message;
	public CardinalDean() {
		busy=0;	
		message="";
	}

	public String roleOccupied(int rol) {

		busy=rol;
		if (busy==1) {
			message="Este rol ya esta ocupado, tu no eres el cardenal Decano";
		}
		else {
			message="Es usted el cardenal Decano, es un honor";
		}
		return message;
	}
	public String confirmPapa() {
		message="Yo como el Decano te pregunto: ¿Acepta ser el Sumo Pontífice?";
		return message;
	}

}

