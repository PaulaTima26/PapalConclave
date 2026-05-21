package co.edu.uptc.model;

import java.util.ArrayList;

public class TotalCardinals {
private ArrayList <Cardinal>cardinalsPresent;
	
	public TotalCardinals() {
		cardinalsPresent= new ArrayList<Cardinal>();
	}
	
	public void fillArray(Cardinal objectCardinal) {
		cardinalsPresent.add(objectCardinal);
		
	}
	public Cardinal searchCardinal(String candidate) {	
		Cardinal found=null;
		for(Cardinal existing: cardinalsPresent) {
			
			if (existing.getName().equalsIgnoreCase(candidate)) {
				found=existing;
			}
		}
		
		return found;
	}
	public ArrayList <Cardinal>getCardinal() {
		return cardinalsPresent;
	}
}
