package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
public class CardinalMatrix {
	private String [][] namesMatrix;

	public void createMatrix(int numberCardenals){
		int cardenals=numberCardenals;
		namesMatrix=new String[cardenals][2];
	}

	public String[][] getNamesMatrix() {
		return namesMatrix;
	}

	public boolean searchCadidate(String[][] namesMatrix, String candidate) {
		boolean coincidence=false;
		String searched=candidate;
		for (int i=0; i<namesMatrix.length;i++) {
			if (namesMatrix[i][0].equalsIgnoreCase(searched)) {
				coincidence=true;
			}
			else {
				coincidence=false;
			}
		}
		return coincidence;
	}
}
