package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Basketball extends JPanel {
	private int x;
	private int y;
	private int Xi;
	private int Yi;
	private double Vx;
	private double Vy;
	//private int angle;
	private static final int MIDCOURT_X = 401;
	private static final int MIDCOURT_Y = 384;
	private Image basketballScaled;
	
	//Default Constructor
	public Basketball() {
		x = MIDCOURT_X;
		y = MIDCOURT_Y;
		Xi = MIDCOURT_X;
		Yi = MIDCOURT_Y;
		//angle = 45;
		
		//This adds the image of the basketball - throws an exception if it can't find the file
		MediaTracker tracker = new MediaTracker(this);
		URL url = getClass().getResource("/Images/Basketball (200x200).png");
		Image basketballImage = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(basketballImage, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) { return; }
		basketballScaled = basketballImage.getScaledInstance(20, 20,  Image.SCALE_FAST);
	}
	
	public void draw(Graphics g){
		g.drawImage(basketballScaled, (int) x, (int) y, null);
	}
	

	//* Getters and Setters********************************************
	public int getPositionX() {
		return x;
	}

	public void setPositionX(int x) {
		this.x = x;
	}

	public int getPositionY() {
		return y;
	}

	public void setPositionY(int y) {
		this.y = y;
	}

	public double getVelocityX() {
		return Vx;
	}

	public void setVelocityX(double Vx) {
		this.Vx = Vx;
	}

	public double getVelocityY() {
		return Vy;
	}

	public void setVelocityY(double Vy) {
		this.Vy = Vy;
	}

//	public int getAngle() {
//		return angle;
//	}
//
//	public void setAngle(int angle) {
//		this.angle = angle;
//	}

	public static int getMidcourtX() {
		return MIDCOURT_X;
	}

	public static int getMidcourtY() {
		return MIDCOURT_Y;
	}


	public int getXi() {
		return Xi;
	}

	
	public void setXi(int xi) {
		Xi = xi;
	}

	public int getYi() {
		return Yi;
	}

	public void setYi(int yi) {
		Yi = yi;
	}
}
