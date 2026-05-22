package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecordVotes {
	private   int maxVotes;
	private Map <String,Integer> votes;
	private ArrayList<String>finalist;
	
	public RecordVotes() {
		votes=new HashMap<>();
		finalist=new ArrayList<>();
		maxVotes=0;
	}
	public void fillVotes(Cardinal found) {
		String name=found.getName();
		if(votes.containsKey(name)) {

	        int currentVotes = votes.get(name);

	        votes.put(name, currentVotes + 1);

	    }
	    else {

	        votes.put(name, 1);

	    }

	}
	public void clean() {
		votes.clear();
	}
	
	public String winnerCandidate() {
	    String winner = "";
	    int maxVotes=0;
	    for(String candidate : votes.keySet()) {
	        int currentVotes = votes.get(candidate);
	        if(currentVotes > maxVotes) {
	            maxVotes = currentVotes;
	            winner = candidate;
	        }
	    }

	    return winner;
	}
	
	public int getVotesWinner(String winner) {
		return votes.get(winner);
	}
	
	public void selectetFinalist() {
		finalist.clear();
		String first=winnerCandidate();
		finalist.add(first);
		votes.remove(first);
		String second=winnerCandidate();
		finalist.add(second);
		votes.remove(second);
	}
	
	public String showVotes() {
String message="";
	    for(String name : votes.keySet()) {

	    	message+=name + " : " + votes.get(name)+"\n";

	    }
return message;
	}
	
	
	}
