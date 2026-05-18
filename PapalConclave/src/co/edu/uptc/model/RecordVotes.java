package co.edu.uptc.model;

public class RecordVotes {
private Cardinal candidate;
private int votes;

public RecordVotes() {
	this.candidate=candidate;
	votes=1;
}

public void addVote() {
	votes++;
}
public Cardinal getCandidate() {
	return candidate;
}
public int getVotes() {
	return votes;
}
}
