package co.edu.uptc.model;

public class ValidationVotes {


	public boolean comparison(int cardinalVoters, int numberVotes, int abstention) {
		boolean comparation=false;
		if (numberVotes< cardinalVoters) {
			comparation=false;
		}
		else {
			comparation=true;
		}
		return comparation;
	}

	public boolean validateWinner(int votesWinner, int cardinalVoters) {

		double requiredVotes = (cardinalVoters * 2.0) / 3.0;
		boolean elected = false;
		if(votesWinner >= requiredVotes) {
			elected = true;
		}
		else {
			elected=false;
		}
		return elected;
	}
}
