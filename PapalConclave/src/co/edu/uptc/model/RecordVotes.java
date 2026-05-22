package co.edu.uptc.model;
/* Names: Sebastian Felipe Rodríguez Sánchez y Paula Estefanía Timarán Amezquita
 * Date: 23/05/26
 * Description: Proyecto Final
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecordVotes {
	private Map <String,Integer> votes;
	private ArrayList<Cardinal>finalist;
	private String firstName;
	private String secondName;

	public RecordVotes() {
		votes=new HashMap<>();
		finalist=new ArrayList<>();
		firstName="";
		secondName="";
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

	public void selectetFinalist(TotalCardinals objectTotalCardinals) {
		finalist.clear();
		firstName = winnerCandidate();
		Cardinal first = objectTotalCardinals.searchCardinal(firstName);
		if (first!=null) {
			finalist.add(first);
		}
		votes.remove(firstName);
		secondName = winnerCandidate();
		Cardinal second = objectTotalCardinals.searchCardinal(secondName);
		if (second !=null) {
			finalist.add(second);
		}
		votes.remove(secondName);
		System.out.println(finalist);
	}

	public Cardinal searchFinalist(String candidate) {
		Cardinal found = null;
		for(Cardinal finalistCandidate : finalist) {
			if(finalistCandidate!=null) {
				if(finalistCandidate.getName().equalsIgnoreCase(candidate)) {
					found = finalistCandidate;
				}
			}
		}
		return found;
	}

	public String showVotes() {
		String message="";
		for(String name : votes.keySet()) {
			message+=name + " : " + votes.get(name)+"\n";
		}
		return message;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSecondName() {
		return secondName;
	}

}
