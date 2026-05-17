package co.edu.uptc.model;

public class CardinalProtodeacon {

	private int busy;
	
	public CardinalProtodeacon() {
		busy=0;
	}
	
	public String roleOccupied(int rol) {
		busy=rol;
		String message="";
		if (busy==1) {
			message="Este rol ya esta ocupado, tu no eres el cardenal protodiácono";
		}
		else {
			message="Es usted el cardenal protodiácono, es un honor";
		}
		return message;
	}
	
}
