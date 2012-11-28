package game;

import java.awt.Color;
import java.awt.Graphics;

public class Basketball {
	private double x;
	private double y;
	private double Vx;
	private double Vy;
	private double angle;
	private static final double BALL_POSITION_X1 = 401;
	private static final double BALL_POSITION_Y1 = 384;
	private static final double BALL_POSITION_X2 = 501;
	private static final double BALL_POSITION_Y2 = 379;
	private static final double BALL_POSITION_X3 = 171;
	private static final double BALL_POSITION_Y3 = 397;
	
	//Default Constructor
	public Basketball() {
		x = BALL_POSITION_X1;
		y = BALL_POSITION_Y1;
		angle = 0.0;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.cyan);
		g.fillOval((int) x, (int) y, 20, 20);
	}
	

	//* Getters and Setters********************************************
	public double getPositionX() {
		return x;
	}

	public void setPositionX(double x) {
		this.x = x;
	}

	public double getPositionY() {
		return y;
	}

	public void setPositionY(double y) {
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

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public static double getBallPositionX1() {
		return BALL_POSITION_X1;
	}

	public static double getBallPositionY1() {
		return BALL_POSITION_Y1;
	}

	public static double getBallPositionX2() {
		return BALL_POSITION_X2;
	}

	public static double getBallPositionY2() {
		return BALL_POSITION_Y2;
	}

	public static double getBallPositionX3() {
		return BALL_POSITION_X3;
	}

	public static double getBallPositionY3() {
		return BALL_POSITION_Y3;
	}
}
