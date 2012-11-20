package game;

public class Basketball {
	private static final double ACCERLERATIONY = 9.81;
	private double time;
	private double xPosition;
	private double yPosition;
	private double xVelocity;
	private double yVelocity;
	private double launchAngle;
	
	//Default Constructor
	public Basketball() {
		xPosition = 0.0;
		yPosition = 0.0;
		launchAngle = 0.0;
		time = 0;
	}
	
	public double calcPositionX(double time) {
		return 0;
	}
	
	public double calcPositionY(double time) {
		return 0;
	}

	//* Getters and Setters********************************************
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

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

	public static double getAccerlerationy() {
		return ACCERLERATIONY;
	}

}
