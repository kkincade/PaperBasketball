package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Court extends JPanel {
	private Player whoseTurn;
	private Scoreboard scoreboard;
	private Basketball bball;
	private Player player;
	private Hoop hoop;
	private double power;
	private Image courtImage;
	private boolean madeShot;
	private int numberOfIterations;
	private static final double A_Y = 9.81;
	private Timer timer;
	
	/** Constructor */
	public Court() {
		super();
		timer = new Timer(25, new TimerListener());
		numberOfIterations = 0;
		madeShot = false;
		scoreboard = new Scoreboard();
		bball = new Basketball();
		player = new Player();
		hoop = new Hoop();
		setPower(0);
		
		//This adds the image of the court - throws an exception if it can't find the file
		MediaTracker tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/Court (700x500).png");
		courtImage = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(courtImage, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) { return; }
	}
	
//*****************************************************************************************************************************
	/** Draws the court and basketball */
	public void paintComponent(Graphics g) {
		int PADDING = 0;
		g.drawImage(courtImage, PADDING, PADDING, 700, 500, null);
		bball.draw(g);
	}

	/** Checks to see if the angle inputed is between 0 and 90. */
	public boolean checkAngle(double angle) {
		if (angle > 90 || angle < 0) {
			return false;
		}
		return true;
	}
	
	/**Calculates the x velocity */
	public double calculateXVelocity(double power, double angle) {
		double xVelocity = power * Math.cos(Math.toRadians(angle));
		return xVelocity;
	}
	
	/**Calculates the y velocity */
	public double calculateYVelocity(double power, double angle) {
		double yVelocity = power * Math.sin(Math.toRadians(angle))*-1;
		return yVelocity;
	}
	
	/**If the players score is ten or above, they won the game. */
	public boolean checkWin(int score) {
		if (score >= 10) {
			return true;
		}
		return false;
	}

//*****************************************************************************************************************************
	/** Initializes madeShot to false, starts the timer, and then calls the shootHelper function*/
	public void shoot() {
		timer.start();
		numberOfIterations = 0;
		madeShot = false;
		//shootHelper(numberOfIterations*(1.0/10.0));
	}
	
	public void shootHelper(double time) {
		repaint();
		if(Math.abs(bball.getPositionX() - hoop.getPositionX()) < 10 && Math.abs(bball.getPositionY() - hoop.getPositionY()) < 10){
			System.out.println("Made basket");
			madeShot = true;
			timer.stop();
		}
		else if(bball.getPositionX() - hoop.getPositionX() > 0 || bball.getPositionY() >= 470){
			System.out.println("Missed the hoop");
			timer.stop();
		}
		else{
			bball.setPositionY(Basketball.getBallPositionY1() + bball.getVelocityY()*time + .5 * (A_Y) * Math.pow(time, 2));
			bball.setPositionX(Basketball.getBallPositionX1() + bball.getVelocityX()*time);
			numberOfIterations++;
			//shootHelper(numberOfIterations*(1.0/10.0));
		}
	}
	
	/** This timer calls the shootHelper function every 25ms and repaints the board*/
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
			shootHelper(numberOfIterations*(1.0/10.0));
		}
	}
	
//* Getters and Setters *****************************************************************************************************
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
		bball.setVelocityX(calculateXVelocity(power, bball.getAngle()));
		bball.setVelocityY(calculateYVelocity(power, bball.getAngle()));
	}

	public Hoop getHoop() {
		return hoop;
	}

	public void setHoop(Hoop hoop) {
		this.hoop = hoop;
	}

	public boolean isMadeShot() {
		return madeShot;
	}

	public void setMadeShot(boolean madeShot) {
		this.madeShot = madeShot;
	}
}
