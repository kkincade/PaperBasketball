package tests;

import junit.framework.Assert;
import game.Court;
import org.junit.BeforeClass;
import org.junit.Test;

public class testGame {
	private static Court court;
	
	@BeforeClass
	public static void setup() {
		court = new Court();
	}

	@Test
	//Tests if the angle inputed is between 0 and 90.
	public void testCorrectAngleInput() {
		
		//Test 100 being an incorrect launch angle
		court.getBball().setLaunchAngle(100);
		Assert.assertFalse(court.checkAngle(court.getBball().getLaunchAngle()));
		
		//Test -10 being an incorrect launch angle
		court.getBball().setLaunchAngle(-10);
		Assert.assertFalse(court.checkAngle(court.getBball().getLaunchAngle()));
		
		//Test 70 being a correct launch angle
		court.getBball().setLaunchAngle(70);
		Assert.assertTrue(court.checkAngle(court.getBball().getLaunchAngle()));
	}
	
	
	@Test
	//Tests if the velocity input from the mouse-click is between 0 and 100.
	//Max power = 10
	public void testInitialVelocities() {

		//Power of 5 and an angle of 45
		court.getBball().setLaunchAngle(45);
		court.setPower(5);
		double power = court.getPower();
		double xVelocity = court.getBball().getxVelocity();
		double yVelocity = court.getBball().getyVelocity();
		double expectedXVelocity = 5 * Math.cos(45);
		double expectedYVelocity = 5 * Math.sin(45);
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
		
		//Power of 8 and an angle of 80
		court.getBball().setLaunchAngle(80);
		court.setPower(8);
		power = court.getPower();
		xVelocity = court.getBball().getxVelocity();
		yVelocity = court.getBball().getyVelocity();
		expectedXVelocity = 8 * Math.cos(80);
		expectedYVelocity = 8 * Math.sin(80);
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
		
		//Power of 2 and an angle of 90
		court.getBball().setLaunchAngle(90);
		court.setPower(2);
		power = court.getPower();
		xVelocity = court.getBball().getxVelocity();
		yVelocity = court.getBball().getyVelocity();
		expectedXVelocity = 2 * Math.cos(90);
		expectedYVelocity = 2 * Math.sin(90);
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
	}
	
	
	@Test
	//Tests angle that should result in a made basket.
	public void testMakeBasket() {
		court.setPower(70/Math.sqrt(2));
		court.getBball().setLaunchAngle(45);
		court.shoot(court.getBball().getLaunchAngle(), court.getPower());
		Assert.assertTrue(court.isMadeShot());
		
		court.setPower(35/Math.cos(60));
		court.getBball().setLaunchAngle(60);
		court.shoot(court.getBball().getLaunchAngle(), court.getPower());
		Assert.assertTrue(court.isMadeShot());
	}
	
	@Test
	//Tests various coordinates of basketball
	public void testBallTrajectory() {
		
		//Time 2, Power 5, Angle 45
		court.getBball().setxPosition(100);
		court.getBball().setyPosition(court.getHoop().getPositionY());
		court.getBball().setxVelocity((5 * Math.sqrt(2)) / 2);
		court.getBball().setyVelocity((5 * Math.sqrt(2)) / 2);
		
		double ballXLocation = court.getBball().calcPositionX(2);
		double ballYLocation = court.getBball().calcPositionY(2);
		
		double ballXLocationExpected = 100 + court.getBball().getxVelocity() * 2;
		double ballYLocationExpected = court.getHoop().getPositionY() + court.getBball().getyVelocity() * 2 + (.5 * (9.81) * 4);
		
		Assert.assertEquals(ballXLocationExpected, ballXLocation);
		Assert.assertEquals(ballYLocationExpected, ballYLocation);
		
		//Time 4, Power 1, Angle 80
		court.getBball().setxPosition(100);
		court.getBball().setyPosition(court.getHoop().getPositionY());
		court.getBball().setxVelocity((1*Math.cos(80)));
		court.getBball().setyVelocity(1*Math.sin(80));
		
		ballXLocation = court.getBball().calcPositionX(4);
		ballYLocation = court.getBball().calcPositionY(4);
		
		ballXLocationExpected = 100 + court.getBball().getxVelocity() * 4;
		ballYLocationExpected = court.getHoop().getPositionY() + court.getBball().getyVelocity() * 4 + (.5 * (9.81) * 16);
		
		Assert.assertEquals(ballXLocationExpected, ballXLocation);
		Assert.assertEquals(ballYLocationExpected, ballYLocation);
		
		//Time 3, Power 10, Angle 30
		court.getBball().setxPosition(100);
		court.getBball().setyPosition(court.getHoop().getPositionY());
		court.getBball().setxVelocity((10*Math.cos(30)));
		court.getBball().setyVelocity(10*Math.sin(30));
		
		ballXLocation = court.getBball().calcPositionX(3);
		ballYLocation = court.getBball().calcPositionY(3);
		
		ballXLocationExpected = 100 + court.getBball().getxVelocity() * 3;
		ballYLocationExpected = court.getHoop().getPositionY() + court.getBball().getyVelocity() * 3 + (.5 * (9.81) * 9);
		
		Assert.assertEquals(ballXLocationExpected, ballXLocation);
		Assert.assertEquals(ballYLocationExpected, ballYLocation);
	}
	
	@Test
	//Tests if player wins game
	public void testWin() {	
		Assert.assertTrue(court.checkWin(10));
	}
}
