package co.edu.uptc.model;

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
		message="Usted esta autorizado a votar.";
		vote= true;
	}
	else {
		message="Usted no esta autorizado para votar.";
		vote=false;
	}
	return message;
}
public boolean getVote() {
	return vote;
}
}