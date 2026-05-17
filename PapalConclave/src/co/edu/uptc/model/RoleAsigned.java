package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Random;

public class RoleAsigned {

	private ArrayList <Cardinal> voters;
	private ArrayList<Cardinal> scrutineers;
	private ArrayList<Cardinal> reviewers;
	private ArrayList<Cardinal> assistants;
	private Random random;
	private int position;
	
	public RoleAsigned() {
		voters=new ArrayList<>();
		scrutineers =new ArrayList<>();
		reviewers=new ArrayList<>();
		assistants=new ArrayList<>();
		random=new Random();
		position=0;
	}
	public boolean confirmVoters(ArrayList<Cardinal> arrayList) {
		boolean again;
		if (arrayList.size()<9) {
			again=true;
		}
		else {
			again=false;
		}
		return again;
	}
	public void assignRoles(ArrayList<Cardinal> arrayList) {
		voters=arrayList;
		ArrayList <Cardinal> temporal=new ArrayList<Cardinal>();
		while(temporal.size()<9) {
			position=random.nextInt(voters.size());
			Cardinal objectCardinal=voters.get(position);
			if (!temporal.contains(objectCardinal)) {
				temporal.add(objectCardinal);
			}
			else {
			//repite el random. 
			}
		}
		
		for(int i=0;i<3;i++) {
			scrutineers.add(temporal.get(i));
		}
		for(int i=3;i<6;i++) {
			reviewers.add(temporal.get(i));
		}
		for(int i=6;i<9;i++) {
			assistants.add(temporal.get(i));
		}
	}
	
	public ArrayList<Cardinal> getScrutineers(){
		return scrutineers;
	}
	public ArrayList<Cardinal> getReviewers(){
		return reviewers;
	}
	public ArrayList<Cardinal> getAssistants(){
		return assistants;
	}
	
}
