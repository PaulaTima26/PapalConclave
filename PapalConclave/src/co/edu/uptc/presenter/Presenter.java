package co.edu.uptc.presenter;

import java.util.ArrayList;

import co.edu.uptc.model.*;
import co.edu.uptc.view.IOManager;

public class Presenter {
	private IOManager objectIOManager;
	private CardinalMatrix objectCardenalMatrix;
	private CardinalProtodeacon objectProtodeacon;
	private CardinalDean objectDean;
	private Cardinal objectCardinal;
	private Elected objectElected;
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
	private CardinalVoters objectVoters;
	private RoleAsigned objectRoleAsigned;
	private int abstention;
	private int numberVotes;

	public Presenter() {
		objectIOManager=new IOManager();
		objectCardenalMatrix=new CardinalMatrix();
		objectProtodeacon=new CardinalProtodeacon();
		objectDean =new CardinalDean();
		objectVoters=new CardinalVoters();
		objectRoleAsigned=new RoleAsigned();
		objectElected=new Elected();
		message="";
		age=0;
		numberCardenals=0;
		letterRange="";
		i=0;
		j=0;
		cardinalVoters=0;
		rol=0;
		abstention=0;
		numberVotes=0;
	}
	public void welcome() {
		message="Bienvenido al sistema del conclave, ¿Cuántos cardenales van a votar?";
		numberCardenals= Integer.parseInt(objectIOManager.input(message));
		objectCardenalMatrix.createMatrix(numberCardenals);
		message= "A continuación registraremos la información de los cardenales asistentes";
		objectIOManager.show(message);
		recibeNamesMatrix();
		requestInformation();
	}
	public String requestInformation() {
		boolean protodeacon=false;
		boolean dean=false;
		for (i=0; i<numberCardenals;i++) {
			message="Ingrese su Nombre y Apellido:";
			name=objectIOManager.input(message);
			message="Ahora digite su edad: ";
			age=Integer.parseInt(objectIOManager.input(message));
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

			objectCardinal=new Cardinal(name,age,letterRange);
			objectIOManager.show(objectCardinal.validationVote(age));
			boolean vote=objectCardinal.getVote();
			if (vote==true) {
				objectVoters.fillArray(objectCardinal);
				cardinalVoters++;
				fillNamesMatrix();
			}
			else {
				fillNamesMatrix();
			}

		}
//		showMatrix();
		minimunCardinals();
		return "";
	}	 
	public void minimunCardinals() {
		boolean again=objectRoleAsigned.confirmVoters(objectVoters.getVoters());
		if(again==true) {
			message="Hay menos de 9 cardenales votantes, debes esperar que llegen mas, por eso se repetira el proceso.";
			objectIOManager.show(message);
			welcome();
		}
		else {
			asigmentRoles();
		}
	}
	public void asigmentRoles() {
		
		objectRoleAsigned.assignRoles(objectVoters.getVoters());
		message="Tras el sorteo reglamentario los roles fueron asignados.\nLos escrutadores serán:";
		objectIOManager.show(message);
		ArrayList<Cardinal> list=objectRoleAsigned.getScrutineers();
		objectIOManager.showList(list);
		message="Los revisores serán:";
		objectIOManager.show(message);
		list=objectRoleAsigned.getReviewers();
		objectIOManager.showList(list);
		message="Los asistentes serán:";
		objectIOManager.show(message);
		list=objectRoleAsigned.getAssistants();
		objectIOManager.showList(list);
		
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
	public String votingMenu() {
		message="Las votaciones iniciaran a partir de este momento, estamos en la Capilla Sixtina, adentro solo estan presentes los cardenales votantes.";
		objectIOManager.show(message);
		for(int i=1;i<=cardinalVoters;i++) {
			message="Estimado cardenal ¿Qué va a hacer en este momento? ";
			String []options= {"Abstenerse al voto", "Votar"};
			int election=objectIOManager.optionsInput(message, null, options);
			switch (election) {
			case 0:
				abstention++;
				break;
			case 1:
				boolean repetition=true;
				while(repetition) {
				message="Cardenal: "+ i+ "a continuación digite el nombre y apellido de su candidato.";
				String candidate=objectIOManager.input(message);
				boolean coincidence=objectCardenalMatrix.searchCadidate(namesMatrix, candidate);
				if (coincidence==true) {
					objectElected.getCandidate(candidate);
					repetition=false;
					numberVotes++;
					
				}
				else {
					message="Voto invalido. Para que tu voto sea valido, es necesario que escribas el nombre y apellido correctamente";
					objectIOManager.show(message);
					repetition=true;
				}
				}
				break;
				default:
					break;
			}
			
			
		}
		return "";
	}
	
//RECORDAR BORRAR SHOWMATRIX
	public void showMatrix() {
		for (int i=0; i<namesMatrix.length; i++) {
			for(int j=0; j<namesMatrix[i].length;j++) {
				System.out.print(namesMatrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("cardenales votantes: "+ cardinalVoters);
		ArrayList<Cardinal> voters = objectVoters.getVoters();
		for(Cardinal objectCardinal : voters) {
			System.out.println(objectCardinal);
		}

	}
	public void init() {
		welcome();
	}
}
