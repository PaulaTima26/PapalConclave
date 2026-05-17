package co.edu.uptc.model;

public class CardinalMatrix {
	private String [][] namesMatrix;
	public CardinalMatrix() {

	}
	public void createMatrix(int numberCardenals){
		int cardenals=numberCardenals;
		namesMatrix=new String[cardenals][2];
	}
	public String[][] getNamesMatrix() {
		return namesMatrix;
	}
	
}
