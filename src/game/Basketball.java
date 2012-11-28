package game;

import java.awt.Color;
import java.awt.Graphics;

public class Basketball {
	private double xPosition;
	private double yPosition;
	private double xVelocity;
	private double yVelocity;
	private double launchAngle;
	private static final double BALL_POSITION_X1 = 401;
	private static final double BALL_POSITION_Y1 = 384;
	private static final double BALL_POSITION_X2 = 501;
	private static final double BALL_POSITION_Y2 = 379;
	private static final double BALL_POSITION_X3 = 171;
	private static final double BALL_POSITION_Y3 = 397;
	
	
	//Default Constructor
	public Basketball() {
		xPosition = BALL_POSITION_X1;
		yPosition = BALL_POSITION_Y1;
		launchAngle = 0.0;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.cyan);
		g.fillOval((int) xPosition, (int) yPosition, 20, 20);
	}
	
	public double calcPositionX(double time) {
		return 0;
	}
	
	public double calcPositionY(double time) {
		return 0;
	}

	//* Getters and Setters********************************************
	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	public double getxVelocity() {
		return xVelocity;
	}

	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}

	public double getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}

	public double getLaunchAngle() {
		return launchAngle;
	}

	public void setLaunchAngle(double launchAngle) {
		this.launchAngle = launchAngle;
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
