package game;

public class Scoreboard {
	private int timeRemaining;
	private int score;
	
	public Scoreboard() {
		super();
		score = 0;
		timeRemaining = 90;
	}

	//* Getters and Setters ***************************************
	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
