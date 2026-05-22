package co.edu.uptc.model;

public class VotingDayControl {
private int day;
private String journey;
private int morningVotes;
private int afternoonVotes;
private int totalVotes;
	
	public VotingDayControl() {
		day=1;
		journey="Mañana";
		morningVotes=0;
		afternoonVotes=0;
		totalVotes=0;
	}
	
	public void registerVoting() {
		totalVotes++;
		if(journey.equals("Mañana")) {
			morningVotes++;
			if(morningVotes==2) {
				journey="Tarde";
				morningVotes=0;
			}
		}
		else {
			afternoonVotes++;
			if(afternoonVotes==2) {
				day++;
				journey="Mañana";
				afternoonVotes=0;
			}
		}
	}

	public String getProces() {
		String message="Día: "+ day+ "\nJornada: "+ journey;
		return message;
	}
	public int getTotalVotes() {
		return totalVotes;
	}
	public int getDay() {
		return day;
	}
	
}