package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecordVotes {
	private   int maxVotes;
	private Map <String,Integer> votes;
	
	public RecordVotes() {
		votes=new HashMap<>();
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
	  

	    for(String candidate : votes.keySet()) {

	        int currentVotes = votes.get(candidate);

	        if(currentVotes > maxVotes) {

	            maxVotes = currentVotes;
	            winner = candidate;

	        }
	    }

	    return winner;
	}
	public int getMaxVotes() {
		return maxVotes;
	}
	//Pruebita
	public String showVotes() {
String message="";
	    for(String name : votes.keySet()) {

	    	message+=name + " : " + votes.get(name)+"\n";

	    }
return message;
	}
	
	
	}
