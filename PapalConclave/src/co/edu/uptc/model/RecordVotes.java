package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecordVotes {

	Map <String,Integer> votes;
	
	public RecordVotes() {
		votes=new HashMap<>();
		
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
	//Pruebita
	public void showVotes() {

	    for(String name : votes.keySet()) {

	        System.out.println(name + " : " + votes.get(name));

	    }

	}
	
	
	}
