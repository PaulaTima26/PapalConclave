package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
public class Cardinal {
	protected String name;
	protected int age; 
	protected String range;
	protected boolean vote;
	
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
			message="Usted no está autorizado para votar, solo pueden votar cardenales menores de 80";
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

	public String getRange() {
		return range;
	}
	public int getAge() {
		return age;
	}
}