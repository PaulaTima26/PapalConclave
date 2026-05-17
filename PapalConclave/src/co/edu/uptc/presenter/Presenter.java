package co.edu.uptc.presenter;

import co.edu.uptc.model.*;
import co.edu.uptc.view.IOManager;

public class Presenter {
	private IOManager objectIOManager;
	private CardinalMatrix objectCardenalMatrix;
	private CardinalProtodeacon objectProtodeacon;
	private CardinalDean objectDean;
	private String message;
	private int age;
	private String[][] namesMatrix;
	private int numberCardenals;
	private String name;
	private String letterRange;
	private int i;
	private int j;
	private int cardinalVoters;
	private int rol;

	public Presenter() {
		objectIOManager=new IOManager();
		objectCardenalMatrix=new CardinalMatrix();
		objectProtodeacon=new CardinalProtodeacon();
		objectDean =new CardinalDean();
		message="";
		age=0;
		numberCardenals=0;
		letterRange="";
		i=0;
		j=0;
		cardinalVoters=0;
		rol=0;
	}
	public void welcome() {
		message="Bienvenido al sistema del conclave, ¿Cuántos cardenales van a votar?";
		numberCardenals= Integer.parseInt(objectIOManager.input(message));
		objectCardenalMatrix.createMatrix(numberCardenals);
		message= "A continuación registraremos la información de los cardenales asistentes";
		objectIOManager.show(message);
	}
	public String requestInformation() {
		boolean protodeacon=false;
		boolean dean=false;
		for (i=0; i<numberCardenals;i++) {
			message="Ingrese su Nombre y Apellido:";
			name=objectIOManager.input(message);
			message="Ahora digite su edad: ";
			age=Integer.parseInt(objectIOManager.input(message));
			objectIOManager.show(validationAge());
			int range=0;
			while(range<1 || range>5) {
				message="Ahora ingrese su rango en la iglesia. \nCardenal Obispo(1)\n"
						+ "Cardenal Presbítero (2)\nCardenal Diácono (3)\nCardenal Decano (4)\nCardenal Protodiácono (5)\n";
				range=Integer.parseInt(objectIOManager.input(message));
				switch (range) {
				case 1:
					letterRange="Cardenal Obispo";
					break;
				case 2:
					letterRange="Cardenal Presbítero";
						break;
				case 3:
					letterRange="Cardenal Diácono";
					break;
				case 4:
					if (dean==false) {
						rol=0;
						letterRange= "Cardenal Decano";
						dean=true;
					}				
					else{
						rol=1;
					range=0;	
					}
					message=objectDean.roleOccupied(rol);
					objectIOManager.show(message);
					break;
				case 5:
					if (protodeacon==false) {
						rol=0;
						letterRange= "Cardenal Protodiacono";
						protodeacon=true;
					}
					else {
						rol=1;
						range=0;
					}
					message=objectProtodeacon.roleOccupied(rol);
					objectIOManager.show(message);
				break;
				default:
					objectIOManager.show("Opción invalida");
					break;
				}
			}
			
			recibeNamesMatrix();
			fillNamesMatrix();
		}
		showMatrix();
		return "";
	}
	public String validationAge() {
		if (age<80) {
			message="Usted esta autorizado a votar.";
			cardinalVoters++;
		}
		else {
			message="Usted no esta autorizado para votar.";
		}
		return message;
	}
	
	public void recibeNamesMatrix(){
		namesMatrix=new String [numberCardenals][2];
		namesMatrix=objectCardenalMatrix.getNamesMatrix();
	}
	public void fillNamesMatrix() {
		namesMatrix[i][j]=name;
		namesMatrix[i][j+1]=letterRange;
	//	namesMatrix[i][j+2]=age;
	}
	public void showMatrix() {
		for (int i=0; i<namesMatrix.length; i++) {
			for(int j=0; j<namesMatrix[i].length;j++) {
				System.out.print(namesMatrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("cardenales votantes: "+ cardinalVoters);

	}
	public void init() {
		welcome();
		requestInformation();
	}
}
