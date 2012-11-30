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
		court.getBball().setAngle(100);
		Assert.assertFalse(court.checkAngle(court.getBball().getAngle()));
		
		//Test -10 being an incorrect launch angle
		court.getBball().setAngle(-10);
		Assert.assertFalse(court.checkAngle(court.getBball().getAngle()));
		
		//Test 70 being a correct launch angle
		court.getBball().setAngle(70);
		Assert.assertTrue(court.checkAngle(court.getBball().getAngle()));
	}
	
	@Test
	//Tests if the velocity input from the mouse-click is between 0 and 100.
	//Max power = 10
	public void testInitialVelocities() {

		//Power of 5 and an angle of 45
		court.getBball().setAngle(45);
		court.setPower(5);
		double xVelocity = court.getBball().getVelocityX();
		double yVelocity = court.getBball().getVelocityY();
		double expectedXVelocity = 5 * Math.cos(Math.toRadians(45));
		double expectedYVelocity = 5 * Math.sin(Math.toRadians(45))*-1;
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
		
		//Power of 8 and an angle of 80
		court.getBball().setAngle(80);
		xVelocity = court.getBball().getVelocityX();
		yVelocity = court.getBball().getVelocityY();
		expectedXVelocity = 8 * Math.cos(Math.toRadians(80));
		expectedYVelocity = 8 * Math.sin(Math.toRadians(80))*-1;
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
		
		//Power of 2 and an angle of 90
		court.getBball().setAngle(90);
		court.setPower(2);
		xVelocity = court.getBball().getVelocityX();
		yVelocity = court.getBball().getVelocityY();
		expectedXVelocity = 2 * Math.cos(Math.toRadians(90));
		expectedYVelocity = 2 * Math.sin(Math.toRadians(90))*-1;
		
		Assert.assertEquals(xVelocity, expectedXVelocity);
		Assert.assertEquals(yVelocity, expectedYVelocity);
	}
	
	@Test
	//Tests angle and power that should result in a made basket.
	public void testMakeBasket() {
		court.getBball().setAngle(72);
		court.setPower(65);
		court.shoot();
		Assert.assertTrue(court.isMadeShot());
		
		court.getBball().setPositionX(Basketball.getMidcourtX());
		court.getBball().setPositionY(Basketball.getMidcourtY());
		court.getBball().setAngle(45);
		court.setPower(55);
		court.shoot();
		Assert.assertTrue(court.isMadeShot());
	}
	
	@Test
	//Tests angle and power that should result in a missed basket
	public void testMissedBasket() {
		court.getBball().setPositionX(Basketball.getMidcourtX());
		court.getBball().setPositionY(Basketball.getMidcourtY());
		court.getBball().setAngle(55);
		court.setPower(30);
		court.shoot();
		Assert.assertFalse(court.isMadeShot());
		
		court.getBball().setPositionX(Basketball.getMidcourtX());
		court.getBball().setPositionY(Basketball.getMidcourtY());
		court.getBball().setAngle(90);
		court.setPower(70);
		court.shoot();
		Assert.assertFalse(court.isMadeShot());
		
		court.getBball().setPositionX(Basketball.getMidcourtX());
		court.getBball().setPositionY(Basketball.getMidcourtY());
		court.getBball().setAngle(40);
		court.setPower(70);
		court.shoot();
		Assert.assertFalse(court.isMadeShot());
		
		court.getBball().setPositionX(Basketball.getMidcourtX());
		court.getBball().setPositionY(Basketball.getMidcourtY());
		court.getBball().setAngle(65);
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
