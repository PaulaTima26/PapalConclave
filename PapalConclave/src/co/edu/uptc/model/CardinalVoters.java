package co.edu.uptc.model;

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
