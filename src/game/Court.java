package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Court extends JPanel {
	private Player whoseTurn;
	private Scoreboard scoreboard;
	private Basketball bball;
	private Player player;
	private Hoop hoop;
	private double power;
	private Image courtImage;
	
	//Constructor
	public Court() {
		super();
		scoreboard = new Scoreboard();
		bball = new Basketball();
		player = new Player();
		setPower(0);
		
		MediaTracker tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/Court (700x500).png");
		courtImage = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(courtImage, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) { return; }
		
	}

	public void paintComponent(Graphics g) {
		int PADDING = 0;
		g.drawImage(courtImage, PADDING, PADDING, 700, 500, null);
	}

	//Checks to see if the angle inputed is between 0 and 90.
	public boolean checkAngle(double angle) {
		if (angle > 90 || angle < 0) {
			return false;
		}
		return true;
	}
	
	//Calculates the x and y velocities*****************************
	public double calculateXVelocity(double power, double angle) {
		double xVelocity = power * Math.cos(angle);
		return xVelocity;
	}
	
	public double calculateYVelocity(double power, double angle) {
		double yVelocity = power * Math.sin(angle);
		return yVelocity;
	}
	//**************************************************************
	
	public boolean checkShot() {
		return false;
	}
	
	public boolean checkWin(int score) {
		if (score >= 10) {
			return true;
		}
		return false;
	}

//* Getters and Setters *********************************************
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
		bball.setxVelocity(calculateXVelocity(power, bball.getLaunchAngle()));
		bball.setyVelocity(calculateYVelocity(power, bball.getLaunchAngle()));
	}

	public Hoop getHoop() {
		return hoop;
	}

	public void setHoop(Hoop hoop) {
		this.hoop = hoop;
	}

}
