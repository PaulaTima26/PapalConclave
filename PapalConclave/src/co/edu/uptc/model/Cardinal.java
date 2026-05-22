package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
public class Cardinal {
	private String name;
	private int age; 
	private String range;
	private boolean vote;
	
	public Cardinal(String name, int age, String letterRange) {
		this.name=name;
		this.age=age;
		range=letterRange;
		vote=false;
	}

	public String validationVote(int age) {
		String message="";
		this.age=age;
		if (this.age<80) {
			message="Usted está autorizado a votar.";
			vote= true;
		}
		else {
			message="Usted no está autorizado para votar.";
			vote=false;
		}
		return message;
	}
	@Override
	public String toString() {
		return "Nombre: "+name+"\nEdad: "+age+"\nRango: "+ range+"\n";	
	}
	public String getName() {
		return name;
	}
	public boolean getVote() {
		return vote;
	}
}