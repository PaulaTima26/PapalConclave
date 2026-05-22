package co.edu.uptc.presenter;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
import java.util.ArrayList;
import javax.swing.ImageIcon;
import co.edu.uptc.model.*;
import co.edu.uptc.view.IOManager;

public class Presenter {
	private IOManager objectIOManager;
	private CardinalMatrix objectCardenalMatrix;
	private CardinalProtodeacon objectProtodeacon;
	private CardinalDean objectDean;
	private CardinalScrutiners objectScrutiners;
	private Cardinal objectCardinal;
	private RecordVotes objectRecordVotes;
	private TotalCardinals objectTotalCardinals;
	private ValidationVotes objectValidationVote;
	private Images objectImages;
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
	private VotingDayControl objectDayControl;
	private int voterPossition;
	private int abstention;
	private int numberVotes;
	private int inputPin;
	private String winner;
	private ImageIcon icon;
	private boolean specialVoting;
	private Validations objectValidations;
	private boolean stringValid;
	private boolean onlyNumbers;


	public Presenter() {
		objectIOManager=new IOManager();
		objectCardenalMatrix=new CardinalMatrix();
		objectProtodeacon=new CardinalProtodeacon(name, age, letterRange);
		objectDean =new CardinalDean(name, age, letterRange);
		objectVoters=new CardinalVoters();
		objectRoleAsigned=new RoleAsigned();
		objectRecordVotes=new RecordVotes();
		objectTotalCardinals=new TotalCardinals();
		objectValidationVote=new ValidationVotes();
		objectScrutiners=new CardinalScrutiners();
		objectDayControl=new VotingDayControl();
		objectImages=new Images();
		objectValidations=new Validations();
		message="";
		age=0;
		numberCardenals=0;
		letterRange="";
		i=0;
		j=0;
		cardinalVoters=0;
		rol=0;
		voterPossition=0;
		abstention=0;
		numberVotes=0;
		inputPin=0;
		winner="";
		specialVoting=false;
		stringValid=true;
		onlyNumbers=false;
	}
	public void welcome() {
		onlyNumbers=false;
		while (!onlyNumbers) {
			message="Bienvenido al sistema del conclave, ¿Cuántos cardenales asistieron al conclave?";
			icon=objectImages.getCardinalsIcon();
			String numberCardenalsText=objectIOManager.inputMessageIcon(message,"INGRESO AL SISTEMA", icon);
			if (!objectValidations.onlyNumbers(numberCardenalsText)) {
				icon=objectImages.getGenericError();
				objectIOManager.showMessageIconError("Solo puedes colocar números enteros positivos", icon);
			}
			else {
				numberCardenals=Integer.parseInt(numberCardenalsText);
				onlyNumbers = true;
			}
		}
		objectCardenalMatrix.createMatrix(numberCardenals);
		message= "A continuación registraremos la información de los cardenales asistentes";
		icon=objectImages.getCardinalsIcon();
		objectIOManager.showMessageIcon(message,"Información cardenales", icon);
		recibeNamesMatrix();
		requestInformation();
	}
	public void requestInformation() {
		boolean protodeacon=false;
		boolean dean=false;
		for (i=0; i<numberCardenals;i++) {
			stringValid = true;
			while (stringValid) {
				icon=objectImages.getCardenalInformation();
				message="Ingrese su Nombre y Apellido:";
				name=objectIOManager.inputMessageIcon(message,"Registro Cardenales",icon);
				icon=objectImages.getGenericError();
				if (objectValidations.empty(name)) {
					objectIOManager.showMessageIconError("No puede estar vacío", icon);
				} 
				else if (objectValidations.noNumbers(name)) {
					objectIOManager.showMessageIconError("No puede colocar números", icon);
				}
				else {
					stringValid = false;
				}
			}
			onlyNumbers=false;
			while (!onlyNumbers) {
				icon=objectImages.getCardenalInformation();
				message="Ahora digite su edad: ";
				String ageText=objectIOManager.inputMessageIcon(message,"Registro Cardenales",icon);
				icon=objectImages.getGenericError();
				if (!objectValidations.onlyNumbers(ageText)) {
					objectIOManager.showMessageIconError("Solo puedes colocar números enteros positivos", icon);
				}
				else {
					age=Integer.parseInt(ageText);
					if (!objectValidations.validAge(age)) {
						objectIOManager.showMessageIconError("La edad mínima permitida es 40 años", icon);
					}else {
						onlyNumbers = true;
					}
				}
			}
			int range=0;
			while(range<1 || range>5) {
				icon=objectImages.getCardenalInformation();
				onlyNumbers=false;
				while (!onlyNumbers) {
					icon=objectImages.getCardenalInformation();
					message="Ahora ingrese su rango en la iglesia. \nCardenal Obispo(1)\n"
							+ "Cardenal Presbítero (2)\nCardenal Diácono (3)\nCardenal Decano (4)\nCardenal Protodiácono (5)\n";
					String rangeText=objectIOManager.inputMessageIcon(message,"Registro Cardenales",icon);
					icon=objectImages.getGenericError();
					if (!objectValidations.onlyNumbers(rangeText)) {
						objectIOManager.showMessageIconError("Solo puedes colocar números enteros positivos", icon);
					}
					else {
						range=Integer.parseInt(rangeText);
						onlyNumbers = true;
					}
				}
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
					icon=objectImages.getCardinalsIcon();
					if (dean==false) {
						letterRange= "Cardenal Decano";
						rol=0;
						objectDean=new CardinalDean(name,age,letterRange);
						dean=true;
					}				
					else{
						rol=1;
						range=0;	
					}
					message=objectDean.roleOccupied(rol);
					objectIOManager.showMessageIcon(message, letterRange, icon);
					break;
				case 5:
					icon=objectImages.getCardinalsIcon();
					if (protodeacon==false) {
						rol=0;
						letterRange= "Cardenal Protodiácono";
						objectProtodeacon=new CardinalProtodeacon(name,age,letterRange);
						protodeacon=true;
					}
					else {
						rol=1;
						range=0;
					}
					message=objectProtodeacon.roleOccupied(rol);
					objectIOManager.showMessageIcon(message, letterRange, icon);
					break;
				default:
					icon=objectImages.getGenericError();
					objectIOManager.showMessageIconError("Opción invalida", icon);
					break;
				}
			}
			icon=objectImages.getCardinalsIcon();
			objectCardinal=new Cardinal(name,age,letterRange);
			objectIOManager.showMessageIcon(objectCardinal.validationVote(age), "Validación de voto por la edad", icon);
			boolean vote=objectCardinal.getVote();
			if (vote==true) {
				objectVoters.fillArray(objectCardinal);
				cardinalVoters++;
				fillNamesMatrix();
				voterPossition++;
				objectTotalCardinals.fillArray(objectCardinal);
			}
			else {
				objectTotalCardinals.fillArray(objectCardinal);
			}
		}
		minimunCardinals();
	}

	public void minimunCardinals() {
		boolean again=objectRoleAsigned.confirmVoters(objectVoters.getVoters());
		if(again==true) {
			icon=objectImages.getGenericError();
			message="Hay menos de 9 cardenales votantes, debes esperar que llegen mas, por eso se repetira el proceso.";
			objectIOManager.showMessageIconError(message, icon);
			welcome();
		}
		else {
			asigmentRoles();
		}
	}

	public void asigmentRoles() {
		icon=objectImages.getCardinalsIcon();
		objectRoleAsigned.assignRoles(objectVoters.getVoters());
		message="Tras el sorteo reglamentario los roles fueron asignados.\nLos escrutadores serán:";
		objectIOManager.showMessageIcon(message, "Asignación de roles", icon);
		ArrayList<Cardinal> list=objectRoleAsigned.getScrutineers();
		objectIOManager.showList(list,icon);
		message="El pin de acceso para los escrutadores es: "+ objectScrutiners.generateAccess();
		objectIOManager.showMessageIcon(message, "Pin escrutadores", icon);
		message="Los revisores serán:";
		objectIOManager.showMessageIcon(message, "Asignación de roles", icon);
		list=objectRoleAsigned.getReviewers();
		objectIOManager.showList(list,icon);
		message="Los asistentes serán:";
		objectIOManager.showMessageIcon(message, "Asignación de roles", icon);
		list=objectRoleAsigned.getAssistants();
		objectIOManager.showList(list,icon);
		votingMenu();
	}

	public void recibeNamesMatrix(){
		namesMatrix=new String [numberCardenals][2];
		namesMatrix=objectCardenalMatrix.getNamesMatrix();
	}

	public void fillNamesMatrix() {
		namesMatrix[voterPossition][j]=name;
		namesMatrix[voterPossition][j+1]=letterRange;
	}

	public void votingMenu() {
		icon=objectImages.getCardinalsIcon();
		message="Las votaciones iniciarán a partir de este momento, estamos en la Capilla Sixtina "+ objectDayControl.getProces();
		objectIOManager.showMessageIcon(message, "PROCESO DE VOTACIÓN", icon);
		for(int j=0; j<cardinalVoters; j++) {
			String name = namesMatrix[j][0];
			String range = namesMatrix[j][1];
			boolean continuation=false;
			while(continuation==false) {
				icon=objectImages.getVote();
				message=range+ " "+ name +" ¿Qué va a hacer en este momento? ";
				String []options= {"Abstenerse al voto", "Votar"};
				int election=objectIOManager.optionsInput(message, icon, options);
				switch (election) {
				case 0:
					abstention++;
					continuation=true;
					break;
				case 1:
					boolean repetition=true;
					while(repetition) {
						icon=objectImages.getVote();
						message="Cardenal: "+ name+ ", digite el nombre y apellido de su candidato.";
						String candidate=objectIOManager.inputMessageIcon(message,"Proceso de votación",icon);
						Cardinal found;
						if(specialVoting==true) {
							found=objectRecordVotes.searchFinalist(candidate);
							if (found==null) {
								icon=objectImages.getGenericError();
								message="Voto invalido. Para que tu voto sea valido, debes votar por los 2 cardenales más votados: \n "+ objectRecordVotes.getFirstName()+ " o "+ objectRecordVotes.getSecondName();
								objectIOManager.showMessageIcon(message,"Cardenal no disponible", icon);
								repetition=true;
							}
						} 
						else {
							found=objectTotalCardinals.searchCardinal(candidate);
						}
						if (found==null) {
							icon=objectImages.getGenericError();
							message="Voto invalido. Para que tu voto sea valido, es necesario que escribas el nombre y apellido correctamente";
							objectIOManager.showMessageIcon(message, "Cardenal no encontrado", icon);
							repetition=true;
						}
						if (found!=null) {
							objectRecordVotes.fillVotes(found);
							repetition=false;
							numberVotes++;
						}
					}
					continuation=true;
					break;
				default:
					icon=objectImages.getGenericError();
					message="opcion invalida, vuelva a intentar";
					objectIOManager.showMessageIconError(message, icon);
					break;
				}
			}
		}
		validationQuantity();
	}

	public void validationQuantity() {
		objectDayControl.registerVoting();
		boolean comparation=objectValidationVote.comparison(cardinalVoters,numberVotes, abstention);
		if (comparation) {
			icon=objectImages.getUrnaIcon();
			message="Se guardaron los resultados de la votación";
			objectIOManager.showMessageIcon(message, "Resultados", icon);
			boolean access=false;
			while(access==false) {
				icon=objectImages.getUrnaIcon();
				onlyNumbers=false;
				while (!onlyNumbers) {
					icon=objectImages.getUrnaIcon();
					message="Cardenal escrutador, para acceder a los resultados, digite el pin: ";
					String inputPinText=objectIOManager.inputMessageIcon(message,"Escrutinio",icon);
					if (!objectValidations.onlyNumbers(inputPinText)) {
						icon=objectImages.getGenericError();
						objectIOManager.showMessageIconError("Solo puedes colocar números enteros positivos", icon);
					}
					else {
						inputPin=Integer.parseInt(inputPinText);
						onlyNumbers = true;
					}
				}
				access=objectScrutiners.confirmAccess(inputPin);
				if (access) {
					icon=objectImages.getUrnaIcon();
					access=true;
					message=objectRecordVotes.showVotes();
					objectIOManager.showMessageIcon(message, "Resultados", icon); 
					validationWinner();
				}
				else {
					access=false;
					icon=objectImages.getGenericError();
					message="Ese no es el pin, intentelo de nuevo.";
					objectIOManager.showMessageIconError(message, icon);
				}
			}
		}
		else {
			objectRecordVotes.clean();
			icon=objectImages.getNoPapaIcon();
			message="El número de votos fue menor al de cardenales votantes. Resultados anulados.";
			objectIOManager.showMessageIcon(message,"Sede Vacante", icon);
			numberVotes = 0;
			abstention = 0;
			votingMenu();
		}
	}

	public void validationWinner() {
		winner = objectRecordVotes.winnerCandidate();
		int votesWinner = objectRecordVotes.getVotesWinner(winner);
		boolean elected =objectValidationVote.validateWinner(votesWinner, cardinalVoters);
		if(elected == true) {
			icon=objectImages.getUrnaIcon();
			message = winner +"ha obtenido los votos necesarios para ser elegido Papa. Pase al frente";
			objectIOManager.showMessageIcon(message, "Candidato electo", icon);
			confirmPapa();
		}
		else {
			icon=objectImages.getNoPapaIcon();
			message = "Ningún candidato alcanzó los 2/3. Iniciara una nueva votación.";
			objectIOManager.showMessageIcon(message, "Sede Vacante", icon);
			specialVotation();
			objectRecordVotes.clean();
			numberVotes = 0;
			abstention = 0;
			votingMenu();
		}
	}

	public void confirmPapa() {
		message=objectDean.confirmPapa();
		icon=objectImages.getCardinalsIcon();
		String [] options = {"Sí acepto", "No acepto"};
		int answer =objectIOManager.optionsInput(message,icon,options);
		if(answer==0) {
			announcement();
		}
		else {
			objectRecordVotes.clean();
			icon=objectImages.getNoPapaIcon();
			message="El cardenal ha rechazado el puesto. Iniciaremos otra ronda de votación";
			objectIOManager.showMessageIcon(message, "Sede Vacante", icon);
			numberVotes = 0;
			abstention = 0;
			votingMenu();
		}
	}

	public void specialVotation() {
		if(objectDayControl.getDay()==4 && specialVoting==false) {
			icon=objectImages.getUrnaIcon();
			objectRecordVotes.selectetFinalist(objectTotalCardinals);
			specialVoting=true;
			message= "A partir del día 4 solo podrán ser votados los dos candidatos más apoyados";
			objectIOManager.showMessageIcon(message, "Escrutinio Extraordinario", icon);
		}
	}

	public void announcement() {
		icon=objectImages.getHabemusPapaIcon();
		Cardinal pope = objectTotalCardinals.searchCardinal(winner);
		message = objectProtodeacon.announcementPapa(winner) + "\n\nInformación del nuevo Papa:\n" + "Nombre: " + pope.getName()
		+ "\nEdad: " + pope.getAge() + "\nRango: " + pope.getRange();
		objectIOManager.showMessageIcon(message, "ANUNCIO OFICIAL", icon);
		historial();
	}

	public void historial() {
		icon=objectImages.getCardinalsIcon();
		message="Hemos finalizado el proceso del conclave, este proceso ha durado: \n"+objectDayControl.getDay() +" Días \n"+"Se realizaron "+objectDayControl.getTotalVotes()+" votaciones" ;
		objectIOManager.showMessageIcon(message, "Historial conclave", icon);
	}

	public void init() {
		welcome();
	}
}
