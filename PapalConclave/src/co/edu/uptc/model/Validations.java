package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
public class Validations {
	
	public boolean empty(String name) {
		return name == null || name.trim().isEmpty();
	}
	
	public boolean noNumbers(String name) {
		return name.matches(".*\\d.*");
	}
	
	public boolean onlyNumbers(String ageText) {
		return ageText.matches("\\d+");
	}
	
	public boolean validAge(int age) {
		return age >= 40;
	}
}