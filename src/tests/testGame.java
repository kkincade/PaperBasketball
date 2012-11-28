package tests;

import junit.framework.Assert;
import game.Basketball;
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
		double expectedXVelocity = 5 * Math.cos(Math.toRadians(45));
		double expectedYVelocity = 5 * Math.sin(Math.toRadians(45))*-1;
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
		
		//Power of 8 and an angle of 80
		court.getBball().setLaunchAngle(80);
		court.setPower(8);
		power = court.getPower();
		xVelocity = court.getBball().getxVelocity();
		yVelocity = court.getBball().getyVelocity();
		expectedXVelocity = 8 * Math.cos(Math.toRadians(80));
		expectedYVelocity = 8 * Math.sin(Math.toRadians(80))*-1;
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
		
		//Power of 2 and an angle of 90
		court.getBball().setLaunchAngle(90);
		court.setPower(2);
		power = court.getPower();
		xVelocity = court.getBball().getxVelocity();
		yVelocity = court.getBball().getyVelocity();
		expectedXVelocity = 2 * Math.cos(Math.toRadians(90));
		expectedYVelocity = 2 * Math.sin(Math.toRadians(90))*-1;
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
	}
	
	
	@Test
	//Tests angle and power that should result in a made basket.
	public void testMakeBasket() {
		court.getBball().setLaunchAngle(72);
		court.setPower(65);
		court.shoot();
		Assert.assertTrue(court.isMadeShot());
		
		court.getBball().setxPosition(Basketball.getBallPositionX1());
		court.getBball().setyPosition(Basketball.getBallPositionY1());
		court.getBball().setLaunchAngle(45);
		court.setPower(55);
		court.shoot();
		Assert.assertTrue(court.isMadeShot());
	}
	
	@Test
	//Tests angle and power that should result in a missed basket
	public void testMissedBasket() {
		court.getBball().setxPosition(Basketball.getBallPositionX1());
		court.getBball().setyPosition(Basketball.getBallPositionY1());
		court.getBball().setLaunchAngle(55);
		court.setPower(30);
		court.shoot();
		Assert.assertFalse(court.isMadeShot());
		
		court.getBball().setxPosition(Basketball.getBallPositionX1());
		court.getBball().setyPosition(Basketball.getBallPositionY1());
		court.getBball().setLaunchAngle(90);
		court.setPower(70);
		court.shoot();
		Assert.assertFalse(court.isMadeShot());
		
		court.getBball().setxPosition(Basketball.getBallPositionX1());
		court.getBball().setyPosition(Basketball.getBallPositionY1());
		court.getBball().setLaunchAngle(40);
		court.setPower(70);
		court.shoot();
		Assert.assertFalse(court.isMadeShot());
		
		court.getBball().setxPosition(Basketball.getBallPositionX1());
		court.getBball().setyPosition(Basketball.getBallPositionY1());
		court.getBball().setLaunchAngle(65);
		court.setPower(30);
		court.shoot();
		Assert.assertFalse(court.isMadeShot());
	}
	
	@Test
	//Tests if player wins game
	public void testWin() {	
		Assert.assertTrue(court.checkWin(10));
		
	}
}
