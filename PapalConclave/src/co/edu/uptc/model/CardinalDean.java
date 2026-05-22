package co.edu.uptc.model;

public class CardinalDean {
	private int busy;
	private String message;
	private String deanName;
	
	public CardinalDean() {
		busy=0;	
		message="";
		deanName="";
	}
	
	public String roleOccupied(int rol, String name) {
		busy=rol;
		if (busy==1) {
		message="Este rol ya esta ocupado, tu no eres el cardenal Decano";
		}
		else {
			deanName=name;
			message="Cardenal "+deanName+" es usted el cardenal Decano, es un honor";
		}
		return message;
	}
	
	public String confirmPapa() {
		message="Yo "+deanName+ " como el Decano te pregunto, cardenal electo: ¿Acepta ser el Sumo Pontífice?";
		return message;
	}

}

