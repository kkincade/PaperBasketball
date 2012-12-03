package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ScoreboardPanel extends JPanel{
	private int timeRemaining;
	private int score;
	private int x;
	private int y;
	private static final int TOPCORNER_X = 589;
	private static final int TOPCORNER_Y = 81;
	private Image scoreBoardImage;
	private Image logoImage;
	
	/** Constructor */
	public ScoreboardPanel() {
		super();
		score = 0;
		timeRemaining = 59;
		x = TOPCORNER_X;
		y = TOPCORNER_Y;
		
		//This adds the image of the scoreboard and logo - throws an exception if it can't find the file
		MediaTracker tracker = new MediaTracker(this);
		URL scoreboardURL = getClass().getResource("/Images/Scoreboard (230x150).png");
		URL logoURL = getClass().getResource("/Images/Paper Basketball (230x150).png");
		scoreBoardImage = Toolkit.getDefaultToolkit().getImage(scoreboardURL);
		logoImage = Toolkit.getDefaultToolkit().getImage(logoURL);
		tracker.addImage(scoreBoardImage, 0);
		tracker.addImage(logoImage, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) { return; }
	}
	
	/**Decrements time */
	public void decrementTime(){
		if (timeRemaining >= 0) {
			timeRemaining--;
		}
	}

	/** Draws the scoreboard and logo to the screen */
	public void draw(Graphics g){
		int PADDING_Y = 20;
		int PADDING_X = 415;
		g.drawImage(scoreBoardImage, PADDING_X, PADDING_Y, 250, 175, null);
		g.drawImage(logoImage, 20, 20, 300, 220, null);
	}
	
	/** Getters and Setters ***************************************/
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
