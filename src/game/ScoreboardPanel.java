package game;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreboardPanel extends JPanel{

	private int timeRemaining;
	private int score;
	private int x;
	private int y;
	//private int angle;
	private static final int TOPCORNER_X = 589;
	private static final int TOPCORNER_Y = 81;
	private Image scoreBoardImage;
	
	public ScoreboardPanel() {
		super();
		score = 0;
		timeRemaining = 90;
		x = TOPCORNER_X;
		y = TOPCORNER_Y;
		//angle = 45;
		
		//This adds the image of the basketball - throws an exception if it can't find the file
		MediaTracker tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/Scoreboard (230x150).png");
		scoreBoardImage = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(scoreBoardImage, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) { return; }
	}

	public void draw(Graphics g){
		int PADDING = 0;
		g.drawImage(scoreBoardImage, PADDING, PADDING, 175, 175, null);
	}
	//* Getters and Setters ***************************************
	public int getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(int timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	public static int getTopcornerX() {
		return TOPCORNER_X;
	}

	public static int getTopcornerY() {
		return TOPCORNER_Y;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
