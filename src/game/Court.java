package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Court extends JPanel {
	private Player whoseTurn;
	private ScoreboardPanel scoreboard;
	private Basketball bball;
	private Player player;
	private Hoop hoop;
	private double power;
	private Image courtImage;
	private boolean madeShot;
	private int numberOfIterations;
	private static final double A_Y = 9.81;
	private Timer timer;
	private int angle;
	private JLabel scoreLabel;
	
	/** Constructor */
	public Court() {
		super();
		scoreLabel = new JLabel("0");
		timer = new Timer(15, new TimerListener());
		numberOfIterations = 0;
		angle = 45;
		madeShot = false;
		scoreboard = new ScoreboardPanel();
		bball = new Basketball();
		player = new Player();
		hoop = new Hoop();
		setPower(50);
//		setLayout(new GridLayout(0,1));
		setLayout(null);
		add(scoreLabel);
		scoreLabel.setLocation(25,10);
		scoreLabel.setFont(new Font("Serif", Font.BOLD, 16));
		scoreLabel.setSize(100,100);
		//add(scoreboard);
		
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
		scoreboard.draw(g);
		bball.draw(g);
		if(numberOfIterations == 0){
			drawTrajectory(g);
		}
	}
	
	/** Draws the first three trajectory positions of the ball */
	public void drawTrajectory(Graphics g) {
		g.setColor(Color.black);
		g.fillOval( (int) (getBball().getXi() + bball.getVelocityX()*1), (int) (getBball().getYi() + bball.getVelocityY()*1 + .5 * (A_Y) * Math.pow(1, 2)), 10, 10);
		g.fillOval((int) (getBball().getXi() + bball.getVelocityX()*2), (int) (getBball().getYi() + bball.getVelocityY()*2 + .5 * (A_Y) * Math.pow(2, 2)), 10, 10);
		g.fillOval((int) (getBball().getXi() + bball.getVelocityX()*3), (int) (getBball().getYi() + bball.getVelocityY()*3 + .5 * (A_Y) * Math.pow(3, 2)), 10, 10);
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
		//numberOfIterations = 0;
		madeShot = false;
		getBball().setVelocityX(calculateXVelocity(getPower(), angle));
		getBball().setVelocityY(calculateYVelocity(getPower(), angle));
		timer.start();
		//shootHelper(numberOfIterations*(1.0/10.0));
	}
	
	public void shootHelper(double time) {
		repaint();
		if(Math.abs(bball.getPositionX() - hoop.getPositionX()) < 10 && Math.abs(bball.getPositionY() - hoop.getPositionY()) < 10){
			System.out.println("Made basket");
			madeShot = true;
			//TODO increment score
			scoreboard.setScore(scoreboard.getScore()+1);
			String stringScore = "" + scoreboard.getScore();
			scoreLabel.setText(stringScore);
			chooseNewBallLocation();
			numberOfIterations = 0;
			repaint();
			timer.stop();
		}
		else if(bball.getPositionX() - hoop.getPositionX() > 0 || bball.getPositionY() >= 470){
			System.out.println("Missed the hoop");
			chooseNewBallLocation();
			numberOfIterations = 0;
			repaint();
			timer.stop();
		}
		else{
			bball.setPositionY((int) (getBball().getYi() + bball.getVelocityY()*time + .5 * (A_Y) * Math.pow(time, 2)));
			bball.setPositionX((int) (getBball().getXi() + bball.getVelocityX()*time));
			numberOfIterations++;
			//shootHelper(numberOfIterations*(1.0/10.0));
		}
	}
	
	public void chooseNewBallLocation() {
		Random rand = new Random();
		int randomX = rand.nextInt(450) + 175;
		int randomY = rand.nextInt(100) + 300;
		getBball().setPositionX(randomX);	//sets x position to anywhere between 100-550
		getBball().setPositionY(randomY);	//sets y position to anywhere between 300-400
		getBball().setXi(randomX);
		getBball().setYi(randomY);
		repaint();
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

//	public ScoreboardPanel getScoreboard() {
//		return scoreboard;
//	}
//
//	public void setScoreboard(ScoreboardPanel scoreboard) {
//		this.scoreboard = scoreboard;
//	}

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
		bball.setVelocityX(calculateXVelocity(power, angle));
		bball.setVelocityY(calculateYVelocity(power, angle));
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
		bball.setVelocityX(calculateXVelocity(power, angle));
		bball.setVelocityY(calculateYVelocity(power, angle));
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
