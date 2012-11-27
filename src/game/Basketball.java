package game;

public class Basketball {
	private double time;
	private double xPosition;
	private double yPosition;
	private double xVelocity;
	private double yVelocity;
	private double launchAngle;
	private static final double BALL_POSITION_X1 = 408;
	private static final double BALL_POSITION_Y1 = 434;
	private static final double BALL_POSITION_X2 = 508;
	private static final double BALL_POSITION_Y2 = 429;
	private static final double BALL_POSITION_X3 = 178;
	private static final double BALL_POSITION_Y3 = 447;
	
	
	//Default Constructor
	public Basketball() {
		xPosition = BALL_POSITION_X1;
		yPosition = BALL_POSITION_Y1;
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
}
