package game;

public class Court {
	private Player whoseTurn;
	private Scoreboard scoreboard;
	private Basketball bball;
	private Player player;
	private Hoop hoop;
	private double power;
	
	public Court() {
		super();
		scoreboard = new Scoreboard();
		bball = new Basketball();
		player = new Player();
		setPower(0);
	}
	
	public void loadConfigFiles() {
		
	}
	
	public boolean checkAngle(double angle) {
		return false;
	}
	
	public boolean checkShot() {
		return false;
	}
	
	public boolean checkWin(int score) {
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//* Getters and Setters ************************************
	public Player getWhoseTurn() {
		return whoseTurn;
	}

	public Scoreboard getScoreboard() {
		return scoreboard;
	}

	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}

	public Basketball getBball() {
		return bball;
	}

	public void setBball(Basketball bball) {
		this.bball = bball;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setWhoseTurn(Player whoseTurn) {
		this.whoseTurn = whoseTurn;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}

	public Hoop getHoop() {
		return hoop;
	}

	public void setHoop(Hoop hoop) {
		this.hoop = hoop;
	}

}
